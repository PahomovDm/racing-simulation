package com.pahomov.UserBuilder;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pahomov.Exception.*;

public abstract class AbstractUserBuilder implements UserBuilder {

    protected String name;
    protected LocalDate birthday;

    public abstract UserBuilder name();

    public abstract UserBuilder birthday();

    protected boolean checkName(String aName) {
        Pattern p = Pattern.compile("[\\p{IsAlphabetic}]{2,15}");
        Matcher m = p.matcher(aName);
        return m.matches();
    }

    public User build() throws AgeException, NullNameException {
        return new User(name, birthday);
    }
}
