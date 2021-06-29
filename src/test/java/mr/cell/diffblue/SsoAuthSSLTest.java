package mr.cell.diffblue;

import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;

import org.apache.hc.client5.http.classic.methods.HttpDelete;

import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.classic.MinimalHttpClient;
import org.junit.Test;

public class SsoAuthSSLTest {
    @Test
    public void testConstructor() throws Exception {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: the constructed class does not have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the class.
        //   See https://diff.blue/R002

        URL cert = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
        char[] certKey = "AAAAAAAA".toCharArray();
        HashMap<String, String> requestHeaders = new HashMap<String, String>(1);
        MinimalHttpClient createMinimalResult = HttpClients.createMinimal();
        MinimalHttpClient createMinimalResult1 = HttpClients.createMinimal();
        (new SsoAuthSSL(cert, certKey, requestHeaders, createMinimalResult, createMinimalResult1,
                HttpClients.createMinimal())).close();
    }

    @Test
    public void testConstructor2() throws Exception {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: the constructed class does not have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the class.
        //   See https://diff.blue/R002

        URL cert = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
        char[] certKey = "AAAAAAAA".toCharArray();
        (new SsoAuthSSL(cert, certKey, new HashMap<String, String>(1))).close();
    }

    @Test
    public void testConstructor3() throws Exception {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: the constructed class does not have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the class.
        //   See https://diff.blue/R002

        URL cert = Paths.get("First", "test.txt").toUri().toURL();
        char[] certKey = "AAAAAAAA".toCharArray();
        (new SsoAuthSSL(cert, certKey, new HashMap<String, String>(1))).close();
    }

    @Test
    public void testExecute() throws Exception {
        // TODO: This test is incomplete.
        //   Reason: Attempting to run the method under test violated the sandboxing policy.
        //
        //   See https://diff.blue/R011

        URL cert = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
        char[] certKey = "AAAAAAAA".toCharArray();
        HashMap<String, String> requestHeaders = new HashMap<String, String>(1);
        MinimalHttpClient createMinimalResult = HttpClients.createMinimal();
        MinimalHttpClient createMinimalResult1 = HttpClients.createMinimal();
        SsoAuthSSL ssoAuthSSL = new SsoAuthSSL(cert, certKey, requestHeaders, createMinimalResult, createMinimalResult1,
                HttpClients.createMinimal());
        ssoAuthSSL.execute(new HttpDelete("https://example.org/example"));
    }

    @Test
    public void testExecute2() throws Exception {
        // TODO: This test is incomplete.
        //   Reason: Attempting to run the method under test violated the sandboxing policy.
        //
        //   See https://diff.blue/R011

        URL cert = Paths.get(System.getProperty("Key"), "test.txt").toUri().toURL();
        char[] certKey = "AAAAAAAA".toCharArray();
        HashMap<String, String> requestHeaders = new HashMap<String, String>(1);
        MinimalHttpClient createMinimalResult = HttpClients.createMinimal();
        MinimalHttpClient createMinimalResult1 = HttpClients.createMinimal();
        SsoAuthSSL ssoAuthSSL = new SsoAuthSSL(cert, certKey, requestHeaders, createMinimalResult, createMinimalResult1,
                HttpClients.createMinimal());
        ssoAuthSSL.execute(new HttpDelete("https://example.org/example"));
    }

    @Test
    public void testExecute3() throws Exception {
        // TODO: This test is incomplete.
        //   Reason: Attempting to run the method under test violated the sandboxing policy.
        //
        //   See https://diff.blue/R011

        URL cert = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
        char[] certKey = "AAAAAAAA".toCharArray();
        SsoAuthSSL ssoAuthSSL = new SsoAuthSSL(cert, certKey, new HashMap<String, String>(1));
        ssoAuthSSL.execute(new HttpDelete("https://example.org/example"));
    }

    @Test
    public void testExecute4() throws Exception {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        URL cert = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
        char[] certKey = "AAAAAAAA".toCharArray();
        SsoAuthSSL ssoAuthSSL = new SsoAuthSSL(cert, certKey, new HashMap<String, String>(1));
        ssoAuthSSL.execute(new HttpDelete("Uri"));
    }

    @Test
    public void testClose() throws Exception {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: neither the return value type of the method under test nor the types of its parameters have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the declaring class
        //   of the method under test, its return type or any of its parameter
        //   types.
        //   See https://diff.blue/R003

        URL cert = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
        char[] certKey = "AAAAAAAA".toCharArray();
        HashMap<String, String> requestHeaders = new HashMap<String, String>(1);
        MinimalHttpClient createMinimalResult = HttpClients.createMinimal();
        MinimalHttpClient createMinimalResult1 = HttpClients.createMinimal();
        (new SsoAuthSSL(cert, certKey, requestHeaders, createMinimalResult, createMinimalResult1,
                HttpClients.createMinimal())).close();
    }

    @Test
    public void testClose2() throws Exception {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: neither the return value type of the method under test nor the types of its parameters have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the declaring class
        //   of the method under test, its return type or any of its parameter
        //   types.
        //   See https://diff.blue/R003

        URL cert = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
        char[] certKey = "AAAAAAAA".toCharArray();
        (new SsoAuthSSL(cert, certKey, new HashMap<String, String>(1))).close();
    }
}

