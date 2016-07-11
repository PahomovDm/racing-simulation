package com.pahomov;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

    @Test
    public void testSetName() {
        String aName = "Dmitry";
        User.setName(aName);
        assertEquals(User.getName(), "Dmitry");
    }

}
