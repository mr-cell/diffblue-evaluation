package mr.cell.diffblue;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.concurrent.TimeUnit;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.classic.MinimalHttpClient;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.util.Timeout;
import org.junit.Test;

public class ComplexInputParametersTest {
    @Test
    public void testExecuteStatic() {
        // TODO: This test is incomplete.
        //   Reason: Attempting to run the method under test violated the sandboxing policy.
        //
        //   See https://diff.blue/R011

        ComplexInputParameters.executeStatic(new HttpDelete("https://example.org/example"));
    }

    @Test
    public void testExecuteStatic2() {
        assertThrows(IllegalStateException.class, () -> ComplexInputParameters.executeStatic(new HttpDelete("Uri")));
    }

    @Test
    public void testExecuteStatic3() {
        // TODO: This test is incomplete.
        //   Reason: Attempting to run the method under test violated the sandboxing policy.
        //
        //   See https://diff.blue/R011

        HttpDelete httpDelete = new HttpDelete("https://example.org/example");
        httpDelete.setEntity(new StringEntity("https://example.org/example"));
        ComplexInputParameters.executeStatic(httpDelete);
    }

    @Test
    public void testExecute() {
        // TODO: This test is incomplete.
        //   Reason: Attempting to run the method under test violated the sandboxing policy.
        //
        //   See https://diff.blue/R011

        ComplexInputParameters complexInputParameters = new ComplexInputParameters();
        MinimalHttpClient httpClient = HttpClients.createMinimal();
        complexInputParameters.execute(httpClient, new HttpDelete("https://example.org/example"));
    }

    @Test
    public void testExecute2() {
        // TODO: This test is incomplete.
        //   Reason: Attempting to run the method under test violated the sandboxing policy.
        //
        //   See https://diff.blue/R011

        ComplexInputParameters complexInputParameters = new ComplexInputParameters();
        MinimalHttpClient httpClient = HttpClients.createMinimal();
        complexInputParameters.execute(httpClient, new HttpGet("https://example.org/example"));
    }

    @Test
    public void testExecute3() {
        // TODO: This test is incomplete.
        //   Reason: Attempting to run the method under test violated the sandboxing policy.
        //
        //   See https://diff.blue/R011

        ComplexInputParameters complexInputParameters = new ComplexInputParameters();
        MinimalHttpClient httpClient = HttpClients.createMinimal();
        RequestConfig requestConfig = mock(RequestConfig.class);
        when(requestConfig.getConnectTimeout()).thenReturn(Timeout.of(1L, TimeUnit.NANOSECONDS));
        when(requestConfig.getConnectionRequestTimeout()).thenReturn(Timeout.of(1L, TimeUnit.NANOSECONDS));

        HttpDelete httpDelete = new HttpDelete("https://example.org/example");
        httpDelete.setConfig(requestConfig);
        complexInputParameters.execute(httpClient, httpDelete);
    }

    @Test
    public void testExecute4() {
        // TODO: This test is incomplete.
        //   Reason: Attempting to run the method under test violated the sandboxing policy.
        //
        //   See https://diff.blue/R011

        ComplexInputParameters complexInputParameters = new ComplexInputParameters();
        MinimalHttpClient httpClient = HttpClients.createMinimal();
        RequestConfig requestConfig = mock(RequestConfig.class);
        when(requestConfig.getConnectTimeout()).thenReturn(Timeout.of(0L, TimeUnit.NANOSECONDS));
        when(requestConfig.getConnectionRequestTimeout()).thenReturn(Timeout.of(1L, TimeUnit.NANOSECONDS));

        HttpDelete httpDelete = new HttpDelete("https://example.org/example");
        httpDelete.setConfig(requestConfig);
        complexInputParameters.execute(httpClient, httpDelete);
    }
}

