package com.mykovol.webServerLab;

import java.util.logging.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceReader {
    private static Logger logger = Logger.getLogger(ResourceReader.class.getName());

    public static List<String> readContent(String uri, String path) throws IOException {
        List<String> result = new ArrayList<>();
        String FilePath = System.getProperty("user.dir") + "/" + path + uri;
        logger.info("Reading from file "+FilePath);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(FilePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.add(line);
        }

        return result;
    }
}
