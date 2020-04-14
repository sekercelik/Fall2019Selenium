package com.automation.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

  private static Properties configFile;

  //this static block will be executed only once whenever somebody calls this class.
    //static block has the highest priority in terms of execution order.
    //the order for execution:
    //1. static block   // 2. instance block  // 3. constructor

    static {
        try {
            //location of properties file// configuration.properties file path
            String path = System.getProperty("user.dir")+"/configuration.properties";
           //get that file as a stream
            FileInputStream input = new FileInputStream(path); //to get the file path above
            //create object of Properties class
            configFile = new Properties();
           //load properties file into Properties object
            configFile.load(input); // load configuration.properties file into Properties object
           //close the input stream at the end
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    /**
     * This method returns property value from configuration.properties file
     * @param keyName property name
     * @return property value
     */

    public static String getProperty(String keyName) {  // call this method and provide a key name to get a value
        return configFile.getProperty(keyName);         // forExample: ConfigurationReader.getProperty("browser")
    }
}