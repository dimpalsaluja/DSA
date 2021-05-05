package com.tiyoda.InputUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int readInteger() throws IOException {
        return Integer.parseInt(readInput());
    }

    public static String readInput() throws IOException{
        return br.readLine();
    }
}
