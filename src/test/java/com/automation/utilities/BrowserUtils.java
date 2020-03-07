package com.automation.utilities;

public class BrowserUtils {

    //for methods that have potential to throw exception;

    public static void wait(int seconds){
        try{
            Thread.sleep(1000*seconds);
        }catch(InterruptedException e){
            e.printStackTrace(); // it is a message saying where,why and what is the problem
        }

    }


}
