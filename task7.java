package com.lala;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.System;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class task7 {
    public static void main(String[] args) throws IOException {
        String f = args[0];
        int num = Integer.parseInt(args[1]);
        File file = new File(f);
        if(!file.exists())
            return;
        RandomAccessFile raf = new RandomAccessFile(file, "r");

        List<String> strList = new ArrayList<String>(num);

        for (int i = 0; i < num; i++) {

            long l = (long) (Math.random()*file.length());
            raf.seek(l);
            while (l != 0 && raf.read() != '\n'){
                l--;
                raf.seek(l);
            }
            strList.add(raf.readLine());
        }
        strList.forEach(System.out::println);
    }

}
