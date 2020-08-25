package com.test.exercise;

import java.io.IOException;
import java.util.logging.*;

public class NumberGeneratorV2 {

    private final static Logger numLogger = Logger.getLogger("myLogger");

    static void StringGenerator (int a) {

        if ( a % 15 ==0)
            numLogger.info( "Fizz Buzz,");

        else if (a % 5 == 0 )
            numLogger.info("Buzz,");
        else if (a % 3 == 0 )
            numLogger.info("Fizz,");
        else
            numLogger.info( a + ",");
    }


    public static void main(String[] args) {
        Handler fileHandler;
        try {
            fileHandler = new FileHandler("./NumberGenerator.log");
            numLogger.addHandler(fileHandler);
            fileHandler.setFormatter(new CustomFormatter() );
        } catch (IOException exception) {
            numLogger.log(Level.SEVERE, "Error occur in FileHandler.", exception);
        }

        for (int i = 1; i <= 100 ; i++)
            StringGenerator(i);
    }
}
