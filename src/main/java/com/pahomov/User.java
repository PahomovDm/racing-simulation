package com.pahomov;

import java.util.GregorianCalendar;

public class User {
    private static String name;
    private static GregorianCalendar birthday;
    private static int age;

    public static void setName(String aName) {
        name = aName;
    }

    public static String getName() {
        return name;
    }

    public boolean checkName() {
        return false;
    }

    public static void setbBirthday(int aDay, int aMonth, int aYear) {
        birthday = new GregorianCalendar(aYear, aMonth, aDay);
        setAge();
    }

    private static void setAge() {
        GregorianCalendar checkDay = new GregorianCalendar(2016, 6, 8);
        int year = checkDay.get(GregorianCalendar.YEAR) - birthday.get(GregorianCalendar.YEAR);
        int cheMonth = checkDay.get(GregorianCalendar.MONTH);
        int birMonth = birthday.get(GregorianCalendar.MONTH);
        if (cheMonth < birMonth) {
            year--;
        } else if ((cheMonth == birMonth)
                && checkDay.get(GregorianCalendar.DAY_OF_MONTH) < birthday.get(GregorianCalendar.DAY_OF_MONTH)) {
            year--;
        }
        age = year;
    }

    public static int getAge() {
        return age;
    }
}
