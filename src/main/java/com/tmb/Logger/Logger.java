package com.tmb.Logger;

import org.apache.logging.log4j.*;

public class Logger {
       public  static  org.apache.logging.log4j.Logger logger=LogManager.getLogger(Logger.class);
    public static org.apache.logging.log4j.Logger logger2=LogManager.getLogger(Logger.class);

    public static void main(String[] args) {
        logger.info("I am starting to use logger.....");
        logger.error("Error occured in loggingg...");
        logger.debug("Why the error occured....");
        logger.warn("Kya use karti tum....");
        logger2.log(Level.INFO,"Info from ogger 2...");

    }
}
