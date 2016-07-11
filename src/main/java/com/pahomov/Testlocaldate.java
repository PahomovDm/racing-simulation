package com.pahomov;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

final class Testlocaldate {
    private Testlocaldate() {

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        LocalDate birt = LocalDate.of(1994, 3, 20);
        LocalDate now = LocalDate.now();
        long yearss = ChronoUnit.YEARS.between(birt, now);
        System.out.println(yearss);
    }
}
