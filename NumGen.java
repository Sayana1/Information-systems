package task_8;

import java.util.stream.Stream;

public class NumGen {
    public static void main(String [] args){
        final long l2pow48 = 281474976710656L;

        final Random random = new Random(25214903917L, 11L, l2pow48);

        Stream<Long> stream = Stream.iterate(234L, random::getNext).skip(1).limit(10);

        stream.forEach(System.out::println);
    }
}

