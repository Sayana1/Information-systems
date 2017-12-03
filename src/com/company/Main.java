package com.company;

public class Main {

    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("enter n m");
        int n = scan.nextInt();
        int m = scan.nextInt();
        if(n < 0 && m > 0) {
            System.out.println("gcd %");
            System.out.println(gcd1(-n, m));
            System.out.println("gcdFloorMod");
            System.out.println(gcdFloorMod(-n, m));
            System.out.println("rem");
            System.out.println(gcdRem(-n, m));
        }
        else if(n > 0 && m < 0)
        {
            System.out.println("gcd %");
            System.out.println(gcd1(n, -m));
            System.out.println("gcdFloorMod");
            System.out.println(gcdFloorMod(n, -m));
            System.out.println("rem");
            System.out.println(gcdRem(n, -m));
        }
        else if (n < 0 && m < 0)
        {

        }
        else{
            System.out.println("gcd %");
            System.out.println(gcd1(-n, -m));
            System.out.println("gcdFloorMod");
            System.out.println(gcdFloorMod(-n, -m));
            System.out.println("rem");
            System.out.println(gcdRem(-n, -m));
        }
    }

    public static int gcd1(int n, int m) {
        while (n != 0 && m != 0) {
            if (Math.abs(n) > Math.abs(m)) {
                n = n % m;
            }
            else {
                m = m % n;
            }
        }
        return n | m;
    }
    
     static int gcdFloorMod(int n, int m) {

        while (n != 0 && m != 0) {
            if (Math.abs(n) > Math.abs(m)) {
                n = Math.floorMod(n, m);
            } else {
                m = Math.floorMod(m, n);
            }
        }
        return n | m;
    }
    
     public static int rem(int n, int m) {
        if (m < 0) {
            return rem(n, -m);
        }
        if (n < 0) {
            return rem(-n, m);
        }
        while (n >= m) {
            n = n - m;
        }
        return n;
    }
    
     static int gcdRem(int n, int m) {
        while (n != 0 && m != 0) {
            if (Math.abs(n) > Math.abs(m)) {
                n = rem(n, m);
            } else {
                m = rem(m, n);
            }
        }
        return n | m;
    }
}
