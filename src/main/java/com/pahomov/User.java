package com.pahomov;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;

final class User {
    private String name;
    private GregorianCalendar birthday;
    private int age;

    public void setName(String aName) {
        this.name = aName;
    }

    public String getName() {
        return this.name;
    }

    public void setBirthday(GregorianCalendar aBirthday) {
        birthday = aBirthday;
        calkAge();
    }

    private void calkAge() {
        GregorianCalendar checkDay = new GregorianCalendar();
        int year = checkDay.get(GregorianCalendar.YEAR) - birthday.get(GregorianCalendar.YEAR);
        int cheMonth = checkDay.get(GregorianCalendar.MONTH);
        int birMonth = birthday.get(GregorianCalendar.MONTH);
        if (cheMonth < birMonth) {
            year--;
        } else if ((cheMonth == birMonth)
                && checkDay.get(GregorianCalendar.DAY_OF_MONTH) < birthday.get(GregorianCalendar.DAY_OF_MONTH)) {
            year--;
        }
        if (year < 0) {
            throw new RuntimeException();
        } else {
            age = year;
        }

    }

    private void calkAge2() {
        LocalDate birt = LocalDate.of(1994, 3, 20);
        LocalDate now = LocalDate.now();
        long yearss = ChronoUnit.YEARS.between(birt, now);
        System.out.println(yearss);
    }

    public int getAge() {
        return age;
    }
}
