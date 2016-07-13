package com.pahomov;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User2 implements Comparable<User2> {
    private String name;
    private LocalDate birthday;
    private int age;
    private boolean isBirthday;

    public static class Builder {
        private String name;
        private LocalDate birthday;
        private Scanner scan = new Scanner(System.in);

        public Builder name() {

            do {
                System.out.println("Please enter your name:");
                name = (scan.nextLine());
                if (name == null) {
                    throw new NullPointerException();
                }
            } while (!(checkName(name)));
            return this;
        }

        public Builder birthday() {

            int day, month, year;
            System.out.print("Enter you birthday: \nDay ");
            day = scan.nextInt();
            System.out.print("Month ");
            month = scan.nextInt();
            System.out.print("Year ");
            year = scan.nextInt();
            birthday = LocalDate.of(year, month, day);
            return this;
        }

        private boolean checkName(String aName) {
            Pattern p = Pattern.compile("[\\p{IsAlphabetic}]{2,15}");
            Matcher m = p.matcher(aName);
            return m.matches();
        }

        public User2 build() {
            return new User2(this);
        }
    }

    User2(Builder builder) {
        name = builder.name;
        birthday = builder.birthday;
        age = getAge();
    }

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
        congratulateBirthDay();
        return isBirthday;
    }

    @Override
    public int compareTo(User2 o) {
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
