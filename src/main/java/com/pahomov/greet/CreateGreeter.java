package com.pahomov.greet;

import com.pahomov.UserBuilder.User;

public class CreateGreeter {
    private static final int AGE_FOR_PROGRAMM = 18;

    public Greeter factoryGreeter(User u) {
        if (u.getAge() > AGE_FOR_PROGRAMM) {
            if (u.isTodayBirthday()) {
                return new GoodDayGreeter(new HappyBirthday(new SimpleGreeter()));
            }
            return new GoodDayGreeter(new SimpleGreeter());
        } else {
            return new KidGreeter();
        }
    }
}
