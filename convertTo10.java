package com.company;

import java.util.Scanner;



public class convertTo10 {

    public static void main(String[] args) {

        System.out.println("Enter a hexadecimal string ");

        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        s = s.toUpperCase();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c > 'F')
            {
                System.out.println("error");
                return;
            }
        }
        int a = _16to10(s);

        System.out.println(a);

    }




    public static int _16to10(String s)
    {
        String hex = "0123456789ABCDEF";

        int s_len = s.length();
        int result = 0;


        for(int i = 0; i < s_len; i++)
        {
            char c = s.charAt(i);
            int a = hex.indexOf(c);

            result = result + (a * (int)Math.pow(16, (s_len-i-1)));
        }

        return result;

    }
}
