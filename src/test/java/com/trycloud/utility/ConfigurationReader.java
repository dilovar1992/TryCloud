package com.trycloud.utility;

import java.io.*;
import java.security.InvalidParameterException;
import java.text.MessageFormat;
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
    //should update so that it sends error when the keyword is mistyped or not present

    public static String getProperty(String keyword) {
        if(properties.getProperty(keyword) == null) {
            throw new InvalidParameterException(MessageFormat.format("Missing value for key {0}! OR key does not exist", keyword));
        }
        //properties object have getProperty method
        return properties.getProperty(keyword);
    }

}
