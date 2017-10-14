package com.company;

import java.util.function.IntSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.Scanner;
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




          //  Stream c = streamWords(s);
            //c.limit(10).forEach(System.out::println);


            Stream d = streamLine(s);
            d.limit(10).forEach(System.out::println);

    }

    //for int
    public static IntStream streamInt(Scanner s)
    {
        IntSupplier int_supplier = new IntSupplier() {
            @Override
            public int getAsInt() {
                return s.nextInt();
            }
        };
        IntStream result = IntStream.generate(int_supplier);
        return result;
    }

    //for double
    public static DoubleStream streamD(Scanner s)
    {
        DoubleSupplier d_supplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return s.nextDouble();
            }
        };

        DoubleStream result = DoubleStream.generate(d_supplier);
        return result;
    }

    //for line
    public static Stream streamLine(Scanner s)
    {
        Supplier line_supplier = new Supplier() {
            @Override
            public Object get() {
                return s.nextLine();
            }
        };

        Stream result = Stream.generate(line_supplier);
        return result;
    }

    //for words
    public static Stream streamWords(Scanner s)
    {
        Supplier word_supplier = new Supplier() {
            @Override
            public Object get() {
                return s.next();
            }
        };

        Stream result = Stream.generate(word_supplier);
        return result;
    }
}

