package com.pahomov;
/**
 * @dpahomov
 */
import org.apache.log4j.Logger;

class Greeter implements SimpleUserGreeting {
    /** Переменная логирования*/
    public static final Logger LOG = Logger.getLogger(Test.class);
    /** Приветствует пользователя*/
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
