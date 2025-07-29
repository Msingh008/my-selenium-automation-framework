package com.tmb.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logge2 {
   static Logger logger= LogManager.getLogger(Logge2.class);

    public static void main(String[] args) {
        logger.trace("trace");
        logger.debug("debug");
    }
}
