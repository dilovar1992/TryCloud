package com.trycloud.utility;

import java.io.*;
import java.util.*;

public class ConfigurationReader {

    // create an object from properties class
    private static Properties properties=new Properties();

    static {
        try{
            //create a file
            FileInputStream file=new FileInputStream("configuration.properties");
            //load properties with file
            properties.load(file);
        } catch (IOException e){
            throw new RuntimeException();
        }

    }

    //methods that read from config file
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
