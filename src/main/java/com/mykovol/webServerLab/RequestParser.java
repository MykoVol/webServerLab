package com.mykovol.webServerLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

public class RequestParser {
    private static Logger logger = Logger.getLogger(RequestParser.class.getName());

    public static Request parseRequest(BufferedReader bufferedReader) throws IOException {
        Request request = new Request();
        String line = bufferedReader.readLine();
        logger.info(line);
        injectUriAndMethod(request, line);
        injectHeaders(request, bufferedReader);
        return request;
    }

    static void injectUriAndMethod(Request request, String requestLine) {
        String[] strings = requestLine.split(" ");
        request.setHttpMethod(HttpMethod.valueOf(strings[0]));
        request.setUri((strings[1]));
        request.setVersion((strings[2]));
    }

    static void injectHeaders(Request request, BufferedReader bufferedReader) throws IOException {
        String line;

        while (!(line = bufferedReader.readLine()).isEmpty()) {
            logger.info(line);
            int indexOfNameSeparator = line.indexOf(": ");
            String parameterName = line.substring(0, indexOfNameSeparator);
            String parameterValue = line.substring(indexOfNameSeparator + 2);
            request.getHeaders().put(parameterName, parameterValue);
        }

    }
}
