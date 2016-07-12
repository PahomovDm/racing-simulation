package com.pahomov;

import java.time.*;
import java.time.temporal.ChronoUnit;
//import java.util.GregorianCalendar;

public final class User {
    private String name;
    private LocalDate birthday;
    private int age;
    private boolean todayBirthday;

    public void setName(String aName) {
        this.name = aName;
    }

    public String getName() {
        return this.name;
    }

    // public void setBirthday(GregorianCalendar aBirthday) {
    // birthday = aBirthday;
    // calkAge();
    // }
    //
    // private void calkAge() {
    // GregorianCalendar checkDay = new GregorianCalendar();
    // int year = checkDay.get(GregorianCalendar.YEAR) -
    // birthday.get(GregorianCalendar.YEAR);
    // int cheMonth = checkDay.get(GregorianCalendar.MONTH);
    // int birMonth = birthday.get(GregorianCalendar.MONTH);
    // if (cheMonth < birMonth) {
    // year--;
    // } else if ((cheMonth == birMonth)
    // && checkDay.get(GregorianCalendar.DAY_OF_MONTH) <
    // birthday.get(GregorianCalendar.DAY_OF_MONTH)) {
    // year--;
    // }
    // if (year < 0) {
    // throw new RuntimeException();
    // } else {
    // age = year;
    // }
    //
    // }

    public void setBirthday2(LocalDate aBirthday) {
        birthday = aBirthday;
        congratulateBirthDay();
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        age = (int) ChronoUnit.YEARS.between(birthday, now);
        if ((int) ChronoUnit.YEARS.between(birthday, now) < 0) {
            throw new RuntimeException();
        } else {
            age = (int) ChronoUnit.YEARS.between(birthday, now);
        }
        return age;
    }

    private void congratulateBirthDay() {
        LocalDate now = LocalDate.now();
        if (birthday.getDayOfMonth() == now.getDayOfMonth() && birthday.getMonth() == now.getMonth()) {
            todayBirthday = true;
        }
    }

    public boolean getTodayBirthday() {
        return todayBirthday;
    }
}
// несколько пользователей, приветствие по возрасту.
// приветствие в функциональном стиле.
