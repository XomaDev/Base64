package com.xoma.base64;

import java.util.StringJoiner;

public class Base64Encoder {
    private byte[] inputData;

    public Base64Encoder(byte[] inputData) {
        this.inputData = inputData;
    }

    public String convert() {
        StringJoiner binaryForm = new StringJoiner(" ");
        for(Byte b : this.inputData) binaryForm.add(String.format("%08d",
                Integer.parseInt(Integer.toBinaryString(b))));

        StringBuilder paddedBinary = new StringBuilder(binaryForm.toString());
        int totalBits = binaryForm.length() - (binaryForm.length() - binaryForm.toString().
                replaceAll(" ","").length());

        if(totalBits % 6 != 0) {
            paddedBinary.append("00");
            totalBits += 2;
            if(totalBits % 6 != 0) paddedBinary.append("00");
        }

        String[] sixBitsEncoded = paddedBinary.toString().replaceAll(" ", "").split("(?<=\\G......)");

        char[] data = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                                  'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                                  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                                  'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                                  '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

        StringBuilder base64 = new StringBuilder();

        for(String binary : sixBitsEncoded) {
            int decimal = Integer.parseInt(binary, 2);
            if(decimal != 0)
                base64.append(data[decimal]);
        }

        if(base64.length() % 4 != 0) {
            base64.append("=");
            if(base64.length() % 4 != 0) base64.append("=");
        }

        return base64.toString();
    }
}
