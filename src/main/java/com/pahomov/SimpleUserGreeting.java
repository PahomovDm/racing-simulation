/**
 *
 */
package com.pahomov;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @author dpahomov
 *
 */
interface SimpleUserGreeting {
    Logger LOG = Logger.getLogger(Test.class);

    Scanner SCAN = new Scanner(System.in);
    default void getInfo() {
        System.out.println("Program rasing-simulation\n");
    }
    default void equalsEnter() {
        do {
            System.out.print("Press <Enter> to exit...");
        } while (("\n").equals(SCAN.nextLine()));
    }
    default String readName() {
        String aName;
        do {
            System.out.println("Please enter your name:");
            aName = SCAN.nextLine();
            if (aName == null) {
                throw new NullPointerException("Name is null");
            }
            Pattern p = Pattern.compile("[\\p{IsAlphabetic}]{2,15}");
            Matcher m = p.matcher(aName);
            if (m.matches()) {
                LOG.info("Correct name " + aName);
                break;
            }
            LOG.warn("Incorrect name " + aName);
        } while (true);
        return aName;
    }
}
