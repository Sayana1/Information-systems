package com.company;

import  java.util.Scanner;

public class Main {


        public static void main(String[] args) {

            System.out.println("enter a string" );

            Scanner scan = new Scanner(System.in);
            String s = scan.next();

            String encode = rot13(s);
            String decode = rot13(encode);

            System.out.println("Enoded string:" );
            System.out.println(encode);

            System.out.println("Decoded string:" );
            System.out.println(decode);

        }

    public static String rot13(String s)
    {
        int s_length = s.length();
        char result [] = new char [s_length];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            result[i] = c;
        }
        String r = String.valueOf(result);
        return r;
    }
}
