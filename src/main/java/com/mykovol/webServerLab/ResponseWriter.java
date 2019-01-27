package com.mykovol.webServerLab;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class ResponseWriter {

    public static void write(BufferedWriter writer, Response response, List<String> content) throws IOException {
        writer.write(response.getVersion() + " " + response.getStatus().getValue() + " " + response.getStatus().getReasonPhrase());
        writer.write("/n");
        writer.write("/n");
        if (content != null && !content.isEmpty()) {
            writer.write(content.toString());
        }
    }


}
