package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainCountSymbol {

    public static void main(String[] args) throws IOException{
	File f = new File("lalala.txt");

	int f_len = (int)f.length();
	FileInputStream input = new FileInputStream(f);
	byte [] data = new byte[f_len];
	input.read(data);

	String text = new String(data);

	System.out.println("enter symbol");
	Scanner s = new Scanner(System.in);
	String str = s.next();
	if(str.length() > 1)
    {
        System.out.println("error");
        return;
    }

    char symbol = str.charAt(0);

	int count = 0;

	for(int i = 0; i < f_len; i++)
    {
        if(text.charAt(i) == symbol)
            count++;
    }

    System.out.println(count);

    }
}
