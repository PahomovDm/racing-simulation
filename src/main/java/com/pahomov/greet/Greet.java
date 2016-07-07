package com.pahomov.greet;

/**
 * @dpahomov
 * @version 1.0
 */
import org.apache.log4j.Logger;

import com.pahomov.Test;

class Greet implements Greeter {
    public static final Logger LOG = Logger.getLogger(Test.class);

    private void helloName(String name) {
        System.out.printf("Hello %s! This is Racing Simulator\n", name.trim());
    }

    public void run() {
        // TODO Auto-generated method stub
        try {
            LOG.info("Start");
            getInfo();
            helloName(readName());
            equalsEnter();
            LOG.info("End");
        } catch (NullPointerException e) {
            System.out.println("Null name, close program");
            LOG.error("NullPointerException");
            System.exit(1);
        }
    }
}
