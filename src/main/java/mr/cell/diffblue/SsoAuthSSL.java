package mr.cell.diffblue;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.cookie.Cookie;
import org.apache.hc.client5.http.cookie.CookieStore;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.TrustAllStrategy;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.protocol.BasicHttpContext;
import org.apache.hc.core5.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SsoAuthSSL implements AutoCloseable {

    private final CookieStore cookieStore;
    private final CloseableHttpClient httpClient;

    SsoAuthSSL(URL cert, char[] certKey, Map<String, String> requestHeaders, CloseableHttpClient... httpClients) throws Exception {
        final int TIMEOUT_HTTP_CLIENT = 180;

        SSLContext sslContext = SSLContext.getDefault();
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);

        cookieStore = new BasicCookieStore();
        httpClient = (httpClients.length > 0) ?
                httpClients[0] :
                HttpClients.custom()
                        .useSystemProperties()
                        .setConnectionManager(PoolingHttpClientConnectionManagerBuilder.create().setSSLSocketFactory(sslConnectionSocketFactory).build())
                        .setDefaultCookieStore(cookieStore)
                        .build();
    }

    public static SSLContext getSSLContext(KeyStore keyStore, char[] keystorePassword) throws Exception {
        char[] passcodeStore = "secure".toCharArray();

        return SSLContexts.custom()
                .loadTrustMaterial(SsoAuthSSL.class.getResource("cert.pem"), passcodeStore, new TrustAllStrategy())
                .loadKeyMaterial(keyStore, keystorePassword)
                .build();
    }

    List<Cookie> execute(HttpUriRequest initialRequest) throws Exception {
        return (isOldSsoLogin(initialRequest)) ? getOldSsoCookies(initialRequest) : getSsoCookies(initialRequest);
    }

    private boolean isOldSsoLogin(HttpUriRequest httpRequest) throws IOException, ParseException {
        boolean isLegacySso = false;
        try (CloseableHttpResponse response = httpClient.execute(httpRequest)) {
            if (EntityUtils.toString(response.getEntity()).contains("OldSSO Login")) {
                isLegacySso = true;
            }
        }
        return isLegacySso;
    }

    private List<Cookie> getOldSsoCookies(HttpUriRequest initialRequest) {
        return Collections.emptyList();
    }

    private List<Cookie> getSsoCookies(HttpUriRequest initialRequest) throws Exception {
        int requestNum = 0;
        HttpUriRequest httpRequest = initialRequest;
        while (true) {
            if (++requestNum == 10) {
                throw new RuntimeException("error");
            }

            BasicHttpContext httpContext = new BasicHttpContext();
            try (CloseableHttpResponse response = httpClient.execute(httpRequest, httpContext)) {
                HttpEntity httpEntity = response.getEntity();

                String body = EntityUtils.toString(httpEntity);
                EntityUtils.consume(httpEntity);

                List<Cookie> cookies = cookieStore.getCookies().stream()
                        .filter(c -> c.getDomain() != null)
                        .collect(Collectors.toList());

                if (response.getCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
                    httpRequest = createRedirectRequest(initialRequest, httpRequest, response);
                } else if (isCreatePostForm(body)) {
                    httpRequest = createPostRequest(httpContext, body);
                } else if (response.getCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                    final String hostname = httpRequest.getUri().getHost();
                    if (cookies.stream().map(Cookie::getDomain).anyMatch(hostname::equals)) {
                        return cookies;
                    } else if (requestNum == 9) {
                        throw new RuntimeException("error");
                    }
                } else {
                    if (cookies.isEmpty()) {
                        throw new RuntimeException("error");
                    }
                    return cookies;
                }
            }
        }
    }

    private HttpUriRequest createPostRequest(BasicHttpContext httpContext, String body) {
        return new HttpGet("example.com/test");
    }

    private boolean isCreatePostForm(String body) {
        return body.contains("<form>");
    }

    private HttpUriRequest createRedirectRequest(HttpUriRequest initialRequest, HttpUriRequest httpRequest, CloseableHttpResponse response) {
        return new HttpGet("example.com/redirect");
    }

    @Override
    public void close() throws Exception {
        httpClient.close();
    }
}
