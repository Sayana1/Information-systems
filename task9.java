package task9;

import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;
import java.util.Spliterators;
import java.util.Spliterator;
import java.util.List;
public class task9 {

    public static void main(String[] args) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        first.add(2);
        first.add(4);
        first.add(6);
        first.add(8);

        second.add(3);
        second.add(5);
        second.add(7);
        second.add(9);
        second.add(11);
        Stream<Integer> stream = zip(first.stream(), second.stream());

        System.out.println(stream.map(f -> f.toString()).collect(Collectors.joining(", \t")));
    }


    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Spliterator<T> firstSpliterator = first.spliterator();
        Spliterator<T> secondSpliterator = second.spliterator();
        Spliterator<T> spliterator = null;

        Iterator<T> firstIterator = Spliterators.iterator(firstSpliterator);
        Iterator<T> secondIterator = Spliterators.iterator(secondSpliterator);
        Iterator<T> iterator = new Iterator<T>() {
            boolean nowfirst = true;

            @Override
            public boolean hasNext() {
                return this.nowfirst ? firstIterator.hasNext() : secondIterator.hasNext();
            }

            @Override
            public T next() {
                if (this.nowfirst) {
                    this.nowfirst = false;
                    return firstIterator.next();
                }
                this.nowfirst = true;
                return secondIterator.next();
            }
        };

        int characteristics = firstSpliterator.characteristics() & secondSpliterator.characteristics()
                &  ~(Spliterator.DISTINCT | Spliterator.SORTED | Spliterator.SIZED);

        spliterator = Spliterators.spliteratorUnknownSize(iterator, characteristics);

        boolean isParallel = first.isParallel() || second.isParallel();

        return StreamSupport.stream(spliterator, isParallel);
    }
}
