package com.tmb.Wrappers;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class PropertyReader {
    private static Properties properties;
    private static Map<String,String> propertyMap=new HashMap<>();

    static{
        try {
            FileInputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/Config.properties"));
            properties=new Properties();
            properties.load(fis);
            for(Map.Entry<Object,Object>entries:properties.entrySet()){
                propertyMap.put(String.valueOf(entries.getKey()),String.valueOf(entries.getValue()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong while loading the property files");

        } catch (IOException e) {
            System.out.println("Something went wrong while loading the property files");
        }
    }
    public static String get(PropertyKeys key){
        if(Objects.isNull(key.toString().toLowerCase())||Objects.isNull(propertyMap.get(key.name().toLowerCase()))){
         throw  new InputMismatchException("There is something wrong with the key passed.Please check the key or property file");
        }
        return propertyMap.get(key.name().toLowerCase());
    }


}
