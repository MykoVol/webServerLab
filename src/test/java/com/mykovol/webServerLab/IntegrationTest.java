package com.mykovol.webServerLab;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.junit.Assert.*;

public class IntegrationTest {
    public Server webServer;

    @Before
    public void setUpServer() throws IOException {
        webServer = new Server();
        webServer.setWebAppPath("src/main/resources/webapp");
        webServer.setPort(3000);
        webServer.start();
    }

    @Test
    public void serverCannotStartAgain() throws IOException {
        try {
            webServer.start();
        } catch (IllegalArgumentException e) {
            assertEquals(IllegalArgumentException.class, e);
        }

    }


    @Test
    public void sleep() throws IOException, InterruptedException {
        Thread.sleep(100000);

    }

    @Test
    public void serverCanHandleGet() throws IOException {

        Socket clientSocket = new Socket("127.0.0.1", 3000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        writer.write("GET /index.html HTTP/1.1");
        writer.write("/n");
        writer.write("Host: localhost");
        writer.write("/n");
        writer.flush();

        assertEquals(reader.readLine(),"HTTP/1.0 200 OK");
        assertEquals(reader.readLine(),"/n");
        assertEquals(reader.readLine(),"/n");
        assertEquals(reader.readLine(),"<html>");
        assertEquals(reader.readLine(),"<body>");
        assertEquals(reader.readLine(),"<h2>Hello World!</h2>");
        assertEquals(reader.readLine(),"</body>");
        assertEquals(reader.readLine(),"</html>");

    }

}
