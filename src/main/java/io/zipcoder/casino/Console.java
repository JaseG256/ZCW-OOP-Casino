package io.zipcoder.casino;

import java.util.Scanner;

public class Console {
    public static int numberFromString(String str) {
        return Integer.parseInt(str);
    }

    public static String stringFromNumber(int num) {
        return Integer.toString(num);
    }

    public static String askForInput(String thingToAsk) {
        System.out.println(thingToAsk);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static String output(String output) {
        System.out.println(output);
        return output;
    }

    public static String output(int output) {
        System.out.println(stringFromNumber(output));
        return stringFromNumber(output);
    }
}
