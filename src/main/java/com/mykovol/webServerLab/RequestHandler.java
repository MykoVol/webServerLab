package com.mykovol.webServerLab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class RequestHandler {
    public static void handle(BufferedReader bufferedRequestReader, BufferedWriter bufferedResponseWriter, String webAppPath) {
        Response response = new Response(HttpStatus.OK);
        List<String> content = null;
        try {
            Request request = RequestParser.parseRequest(bufferedRequestReader);

            content = ResourceReader.readContent(request.getUri(), webAppPath);

        } catch (IllegalArgumentException e) {
            response = new Response(HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            response = new Response(HttpStatus.NOT_FOUND);
            e.printStackTrace();
        } catch (Exception e) {
            response = new Response(HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }

        try {
            ResponseWriter.write(bufferedResponseWriter, response, content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
