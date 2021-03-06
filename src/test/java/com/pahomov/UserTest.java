//package com.pahomov;
//
//import static org.junit.Assert.*;
//
//import java.time.LocalDate;
//
////import java.util.GregorianCalendar;
//
//import org.apache.log4j.Logger;
//import org.junit.Test;
//
//import com.pahomov.userBuilder.User;
//
//public class UserTest {
//    private User user = new User();
//    public static final Logger LOG = Logger.getLogger(RasingSimulationApp.class);
//    LocalDate aBitrhDay;
//
//    @RacingSimulationApp
//    public void testSetAndGetName() {
//        String aName = "Dmitry";
//        user.setName(aName);
//        assertEquals(user.getName(), "Dmitry");
//    }
//
//    /**
//     * @RacingSimulationApp public void testSetAge() {
//     *
//     *       int y = 1996; int m = 4; int d = 21; GregorianCalendar bd = new
//     *       GregorianCalendar(y, m, d); user.setBirthday(bd);
//     *       assertEquals(user.getAge(), 20); }
//     *
//     * @RacingSimulationApp public void testSetAgeWithbdToday() {
//     *
//     *       int y = 2016; int m = 06; int d = 11; GregorianCalendar bd = new
//     *       GregorianCalendar(y, m, d); user.setBirthday(bd);
//     *       assertEquals(user.getAge(), 0);
//     *
//     *       }
//     *
//     * @RacingSimulationApp public void testSetAgeWithbdTomorrow() {
//     *
//     *       try { int y = 2016; int m = 06; int d = 12; GregorianCalendar bd =
//     *       new GregorianCalendar(y, m, d); user.setBirthday(bd);
//     *       assertEquals(user.getAge(), -1); } catch (RuntimeException e) {
//     *       LOG.error("RuntimeException"); } }
//     */
//    @RacingSimulationApp
//    public void testNegativeAge() {
//        try {
//            aBitrhDay = LocalDate.of(2017, 06, 1);
//        } catch (RuntimeException e) {
//            LOG.error("RuntimeException, negative Age");
//        }
//    }
//}
