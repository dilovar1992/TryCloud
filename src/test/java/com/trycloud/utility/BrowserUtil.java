package com.trycloud.utility;

import java.io.*;

public class BrowserUtil {
    public static void sleep(int time){
        try{
            Thread.sleep(time);

        }catch (InterruptedException e){
            e.getStackTrace();
        }
    }
}
