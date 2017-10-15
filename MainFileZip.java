package com.company;

import java.io.IOException;

import java.nio.file.*;
import java.util.stream.Stream;

public class MainFileZip {

    public static void main(String[] args) throws IOException {

        Path _path = Paths.get("C:/Program Files/Java/jdk-0/lib/src.zip");

        Files.walk(_path).filter(path -> !Files.isDirectory(path)).filter(path->MainFileZip.isRight(path))
                .forEachOrdered(System.out::println);

    }

    public static boolean isRight(Path path)
    {
        if(path.getFileName().toString().contains(".java"))
        {
            try(Stream<String> lin = Files.lines(path))
            {
                boolean a = lin.anyMatch(str ->(str.contains("transient")));
                boolean b = lin.anyMatch(str ->(str.contains("volatile")));
                return a&&b;
            }
            catch (IOException e) {
                return false;
            }
        }

        else{
            return false;
        }
    }
}
