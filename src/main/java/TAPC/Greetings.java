package TAPC;

import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            String nextLine = input.nextLine();
            System.out.println(heyGen(nextLine));
        }

    }

    public static String heyGen(String s) {
         if (s.matches("he+y") && s.length() <= 1000) {
             int count = s.lastIndexOf("e") - s.indexOf("e") + 1;
             return "h" + "e".repeat(count*2) + "y";
         } else {
             return s;
         }
    }
}
