package com.xoma;

import com.xoma.base64.Base64Encoder;

public class Main {

    public static void main(String[] args) {
        String text = "Hello, World!";

        Base64Encoder base64Encoder = new Base64Encoder(text.getBytes());
        String base64 = base64Encoder.convert(); // Output : "SGVsbG8sIFdvcmxkIQ=="

        System.out.println(base64);
    }
}
