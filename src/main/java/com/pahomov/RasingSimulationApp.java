//package com.pahomov;
//
//import com.pahomov.greet.*;
//
//import java.time.LocalDate;
////import java.util.GregorianCalendar;
//import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.apache.log4j.Logger;
//
///**
// * @author dpahomov
// *
// */
//
//public class RasingSimulationApp {
//
//    private static final int AGE_FOR_PROGRAMM = 18;
//    public static final Logger LOG = Logger.getLogger(RasingSimulationApp.class);
//    private Scanner scan = new Scanner(System.in);
////    private Greeter greeter = new GoodDayGreeter(new SimpleGreeter());
//    private Greeter kidGreeter = new KidGreeter();
//    private User user = new User();
//
//    public static void main(String[] args) {
//        RasingSimulationApp myTest = new RasingSimulationApp();
//        myTest.run();
//    }
//
//    private void getInfo() {
//        System.out.println("Program rasing-simulation\n");
//    }
//
//    private void readName() {
//        do {
//            System.out.println("Please enter your name:");
//            user.setName(scan.nextLine());
//            if (user.getName() == null) {
//                throw new NullPointerException();
//            }
//        } while (!(checkName(user.getName())));
//    }
//
//    private void closeProgram() {
//        do {
//            System.out.print("\nPress <Enter> to exit...");
//            scan.nextLine();
//        } while (("\n").equals(scan.nextLine()));
//    }
//
//    private static boolean checkName(String aName) {
//        Pattern p = Pattern.compile("[\\p{IsAlphabetic}]{2,15}");
//        Matcher m = p.matcher(aName);
//        return m.matches();
//    }
//
//    public LocalDate readBirthDay() {
//        int day, month, year;
//        System.out.print("Enter you birthday: \nDay ");
//        day = scan.nextInt();
//        System.out.print("Month ");
//        month = scan.nextInt() - 1;
//        System.out.print("Year ");
//        year = scan.nextInt();
//        LocalDate birthday = LocalDate.of(year, month, day);
//        return birthday;
//    }
//
//    private void run() {
//        LOG.info("Start");
//        try {
//            getInfo();
//            readName();
//            user.setBirthday2(readBirthDay());
////            if (user.getAge() > AGE_FOR_PROGRAMM) {
////                greeter.greetUser(user.getName());
////            } else {
////                kidGreeter.greetUser(user.getName());
////            }
//        } catch (NullPointerException e) {
//            System.out.println("Null name, close program");
//            LOG.error("NullPointerException");
//        } catch (RuntimeException e) {
//            System.out.println("You are not yet born");
//            LOG.error("RuntemeExcetion, age < 0");
//        } finally {
//            closeProgram();
//            LOG.info("End");
//        }
//    }
//}
//// прочитать шаблоны стратегия, фабрика
