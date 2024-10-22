package com.TryCloud.utility;

import java.net.*;

public class Driver {
    //private constructor to avoid reach from other class
    private Driver(){

    }

    // private  and static instance
    private static InheritableThreadLocal<WebDriver> driverpool=new InheritableThreadLocal<>();

    //method to return instances of the webdriver
    public static WebDriver getDriver(){

        //String for web browser to read it from system and configuration file
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : ConfigurationReader.getProperty("browser");

        if (driverpool.get() == null) {
            switch (browser) {
                case "chrome":
                    driverpool.set(new ChromeDriver());

                    break;
                case "edge":
                    driverpool.set(new EdgeDriver());
                    break;
                case "firefox":
                    driverpool.set(new FirefoxDriver());
                    break;

                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "100.27.0.96";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        //driverPool.set(new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        return driverpool.get();
    }

    //closing method

    public static void closeDriver(){
        if (driverpool.get() != null){
            //terminates everythings out of existance
            driverpool.get().quit();
            //reassign driverpool back to null so that singleton drive worked
            driverpool.remove();
        }
    }

}
