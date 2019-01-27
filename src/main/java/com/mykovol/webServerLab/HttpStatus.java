package com.mykovol.webServerLab;

public enum HttpStatus {
    OK(200, "OK"),

    BAD_REQUEST(400, "Bad com.mykovol.webServerLab.Request"),

    NOT_FOUND(404, "Not Found"),

    INTERNAL_SERVER_ERROR(500, "Internal com.mykovol.webServerLab.Server Error");

    private final int value;

    private final String reasonPhrase;

    HttpStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    @Override
    public String toString() {
        return "com.mykovol.webServerLab.HttpStatus{" +
                "value=" + value +
                ", reasonPhrase='" + reasonPhrase + '\'' +
                '}';
    }

    public int getValue() {
        return value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }
}
