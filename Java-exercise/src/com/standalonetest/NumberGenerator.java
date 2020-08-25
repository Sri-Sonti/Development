package com.standalonetest;

public class NumberGenerator {

    static void StringGenerator (int a) {

        if ( a % 15 ==0)
            System.out.println("Fizz Buzz,");

        else if (a % 5 == 0 )
            System.out.println("Buzz,");

        else if (a % 3 == 0 )
            System.out.println("Fizz,");

        else
            System.out.println( a + ",");
}

    public static void main(String[] args) {

        for (int i = 1; i <= 100 ; i++)
            StringGenerator(i);

    }

}
