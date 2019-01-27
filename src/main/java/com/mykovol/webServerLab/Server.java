package com.mykovol.webServerLab;

import java.net.Socket;
import java.util.logging.Logger;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    private static Logger logger = Logger.getLogger(Server.class.getName());

    private boolean isRunning;

    private String webAppPath;

    private int port;

    public Server() {
    }

    public void start() throws IOException {
        if (this.isRunning) {
            throw new IllegalStateException("WebServer is already running on port " + this.port);
        } else {
            this.isRunning = true;
        }
        logger.info("WebServer is starting on a port " + this.port);

        ServerSocket serverSocket = new ServerSocket(this.port);
        ThreadManager.execute(() -> {
            while (this.isRunning) {
                try {
                    Socket socket = serverSocket.accept();
                    ClientFactory.createClient(socket, webAppPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public void stop() throws IOException {
        if (!this.isRunning) {
            throw new IllegalStateException("WebServer is not running");
        } else {
            this.isRunning = false;
        }
        logger.info("WebServer is stopping on a port " + this.port);
        ThreadManager.shutdown();
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public int getPort() {
        return port;
    }

    public String getWebAppPath() {
        return webAppPath;
    }

    public void setWebAppPath(String webAppPath) {
        this.webAppPath = webAppPath;
    }
}
