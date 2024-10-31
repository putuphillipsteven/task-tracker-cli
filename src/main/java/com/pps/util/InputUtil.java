package com.pps.util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static String input(String label) {
        System.out.print(label + " : ");
        String data = scanner.nextLine();
        return data;
    }
}
