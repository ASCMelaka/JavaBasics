package com.company;

public class Main {

    public static void main(String[] args) {
        HTTPRequest http = new HTTPRequest();
        http.sendGet();
        http.sendPost();
    }
}
