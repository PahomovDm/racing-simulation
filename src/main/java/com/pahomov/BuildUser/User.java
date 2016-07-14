package com.pahomov.BuildUser;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class User implements Comparable<User> {
    private String name;
    private LocalDate birthday;
    private int age;
    private boolean isBirthday;

    public User(ConsoleUserBuilder consoleUserBuilder) {
        name = consoleUserBuilder.name;
        birthday = consoleUserBuilder.birthday;
        calcAge();
    }

    public String getName() {
        return this.name;
    }

    private void calcAge() {
        LocalDate now = LocalDate.now();
        age = (int) ChronoUnit.YEARS.between(birthday, now);
        if ((int) ChronoUnit.YEARS.between(birthday, now) < 0) {
            throw new RuntimeException();
        } else {
            age = (int) ChronoUnit.YEARS.between(birthday, now);
        }
    }

    public int getAge() {
        return age;
    }

    private void congratulateBirthDay() {
        LocalDate now = LocalDate.now();
        if (birthday.getDayOfMonth() == now.getDayOfMonth() && birthday.getMonth() == now.getMonth()) {
            isBirthday = true;
        }
    }

    public boolean isTodayBirthday() {
        congratulateBirthDay();
        return isBirthday;
    }

    public int compareTo(User o) {
        if (this.age < o.age) {
            return 1;
        }
        if (this.age > o.age) {
            return -1;
        }
        return 0;
    }

}
// jdbc
