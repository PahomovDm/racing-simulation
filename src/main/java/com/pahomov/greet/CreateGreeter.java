package com.pahomov.greet;

//import com.pahomov.User;
import com.pahomov.User2;

public class CreateGreeter {
    private static final int AGE_FOR_PROGRAMM = 18;

    public Greeter factoryGreeter(User2 user) {
        if (user.getAge() > AGE_FOR_PROGRAMM) {
            if (user.isTodayBirthday()) {
                return new GoodDayGreeter(new HappyBirthday(new SimpleGreeter()));
            }
            return new GoodDayGreeter(new SimpleGreeter());
        } else {
            return new KidGreeter();
        }
    }
}
