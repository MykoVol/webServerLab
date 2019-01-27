package com.mykovol.webServerLab;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.*;

public class UnitTest {

    @Test
    public void InjectUriAndMethodTest() {
        Request request = new Request();

        RequestParser.injectUriAndMethod(request, "GET /wiki/HTTP HTTP/1.1");
        assertEquals(HttpMethod.GET, request.getHttpMethod());
        assertEquals("/wiki/HTTP", request.getUri());
        assertEquals("HTTP/1.1", request.getVersion());
    }

    @Test
    public void injectHeadersTest() throws IOException {
        Request request = new Request();
        BufferedReader bufferedReader = new BufferedReader(new StringReader("Host: uk.wikipedia.org\n" +
                "User-Agent: firefox/5.0 (Linux; Debian 5.0.8; en-US; rv:1.8.1.7) Gecko/20070914 Firefox/2.0.0.7\n" +
                "Connection: close\n\n"));

        RequestParser.injectHeaders(request, bufferedReader);
        assertEquals("uk.wikipedia.org", request.getHeaders().get("Host"));
        assertEquals("firefox/5.0 (Linux; Debian 5.0.8; en-US; rv:1.8.1.7) Gecko/20070914 Firefox/2.0.0.7", request.getHeaders().get("User-Agent"));
        assertEquals("close", request.getHeaders().get("Connection"));
    }


}
