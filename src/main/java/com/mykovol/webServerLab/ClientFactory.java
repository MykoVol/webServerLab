package com.mykovol.webServerLab;

import java.io.*;
import java.net.Socket;

public class ClientFactory {

    public static void createClient(Socket socket, String webAppPath) {
        ThreadManager.execute(() -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
            ) {
                RequestHandler.handle(reader, writer, webAppPath);

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
