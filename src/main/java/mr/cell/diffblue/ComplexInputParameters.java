package mr.cell.diffblue;

import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class ComplexInputParameters {

    private static CloseableHttpClient httpClient;

    public static String executeStatic(HttpUriRequest request) {
        httpClient = HttpClients.createDefault();
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            String body = EntityUtils.toString(response.getEntity());
            EntityUtils.consume(response.getEntity());
            return body;
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public String execute(CloseableHttpClient httpClient, HttpUriRequest request) {
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            String body = EntityUtils.toString(response.getEntity());
            EntityUtils.consume(response.getEntity());
            return body;
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
}
