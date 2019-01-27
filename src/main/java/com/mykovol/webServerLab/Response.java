package com.mykovol.webServerLab;

public class Response {

    private String version;
    private HttpStatus status;

    public Response(HttpStatus status) {
        this.version = "HTTP/1.0";
        this.status = status;
    }

    public Response(String version, HttpStatus status) {
        this.version = version;
        this.status = status;
    }

    @Override
    public String toString() {
        return "com.mykovol.webServerLab.Response{" +
                "version='" + version + '\'' +
                ", status=" + status +
                '}';
    }

    public String getVersion() {
        return version;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
