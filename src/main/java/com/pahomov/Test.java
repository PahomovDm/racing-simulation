package com.pahomov;

import java.util.Scanner;

import com.pahomov.database.Track;

final class Test {
    static Scanner scan = new Scanner(System.in);
    private static int v;
    private Test() {

    }

    public static void main(String[] args) {
        Track track = new Track();
        do {
            System.out.println(
                    "\nКакое действо выполнить? \n 1) Добавить трассу \n 2) Удалить трассу\n 3) Посмотреть все трассы \n 4) "
                    + "Обновить трассу \n 0) Завершить программу");
            v = scan.nextInt();
            if (1 == v) {
                track.insertTrack();
            }
            if (2 == v) {
                track.deleteTrack();
            }
            if (3 == v) {
                track.selectTrack();
            }
            if (4 == v) {
                track.updateTrack();
            }
        } while (0 != v);
    }

}
