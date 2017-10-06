package com.company;

public class Main {

    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("enter n m");
        int n = scan.nextInt();
        int m = scan.nextInt();
        System.out.println(gcd(n, m));
    }

    public static int gcd(int n, int m) {
        while (m != 0) {
            int tmp = n % m;
            n = m;
            m = tmp;
        }
        return n;
    }
}
