package com.pahomov;

import java.time.*;
import java.time.temporal.ChronoUnit;

public final class User implements Comparable {
    private String name;
    private LocalDate birthday;
    private int age;
    private boolean isBirthday;

    public void setName(String aName) {
        this.name = aName;
    }

    public String getName() {
        return this.name;
    }

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
            isBirthday = true;
        }
    }

    public boolean isTodayBirthday() {
        return isBirthday;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
