package com.company;

import java.util.*;
import java.util.Scanner;
import java.util.stream.StreamSupport;
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Streams4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


      //      IntStream a = streamInt(s);
        //    a.limit(10).forEach(System.out::println);



          //  DoubleStream b = streamD(s);
           // b.limit(10).forEach(System.out::println);




            Stream c = streamW(s);
            c.limit(10).forEach(System.out::println);

    }

    //for int
    public static IntStream streamInt(Scanner s)
    {
        Spliterator.OfInt spliterator_ = Spliterators.spliterator(new PrimitiveIterator.OfInt() {

            @Override
            public boolean hasNext() {
                return s.hasNextInt();
            }

            @Override
            public int nextInt() {
                return s.nextInt();
            }
        }, Long.MAX_VALUE, Spliterator.NONNULL | Spliterator.ORDERED);
        return StreamSupport.intStream(spliterator_, false);
    }

    //for double
    public static DoubleStream streamD(Scanner s)
    {
          Spliterator.OfDouble spliterator_ = Spliterators.spliterator(new PrimitiveIterator.OfDouble() {

            @Override
            public boolean hasNext() {
                return s.hasNextDouble();
            }

            @Override
            public double nextDouble() {
                return s.nextDouble();
            }
        }, Long.MAX_VALUE, Spliterator.NONNULL | Spliterator.ORDERED);
        return StreamSupport.doubleStream(spliterator_, false);
    }

    public static Stream streamW(Scanner s) {
        Spliterator<String> spliterator_ = Spliterators.spliterator(s, Long.MAX_VALUE, Spliterator.NONNULL | Spliterator.ORDERED);
        return StreamSupport.stream(spliterator_, false);
    }
}

