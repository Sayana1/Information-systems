package task_8;

public class Random {
    private long a;
    private long c;
    private long m;

    Random(long a, long c, long m) {

        this.a = a;
        this.c = c;
        this.m = m;
    }

    long getNext(long prev) {
        return (this.a * prev + this.c) % this.m;
    }
}
