package com.pahomov.database;

import java.sql.SQLException;
import java.util.Scanner;

public class Track extends ConnectDatabase {
    private String name;
    private int distance;
    private int id;
    private Scanner scan = new Scanner(System.in);

    public void selectTrack() { // вывод информации
        query = ("select id, name, distance from track");
        runQuery1(query);
    }

    public void insertTrack() {
        // scan.nextLine();
        System.out.println("Введите название трассы:");
        name = scan.nextLine();
        System.out.println("Введите длину трассы:");
        distance = scan.nextInt();
        query = ("INSERT INTO racingsimulation.track (name, distance) VALUES ('" + name + "', '" + distance + "');");
        runQuery(query);
        System.out.println("Трасса добавлена!");
    }

    public void deleteTrack() {
        selectTrack();
        System.out.println("Введите id удаляемой трассы:");
        id = scan.nextInt();
        query = "delete from racingsimulation.track where id = " + id + ";";
        runQuery(query);
        System.out.println("Трасса удалена!");
    }

    public void updateTrack() {

        selectTrack();
        System.out.print("Введите обновляемой трассы id ");
        id = scan.nextInt();
        System.out.print("Введите обновленную длину трассы ");
        int aDistance = scan.nextInt();
        scan.nextLine();
        System.out.print("Введите обновленное название трассы ");
        String aName = scan.nextLine();
        query = ("UPDATE racingsimulation.track SET name = '" + aName + "', distance = '" + aDistance
                + "' WHERE id in (" + id + ");");
        runQuery(query);
        System.out.println("Трасса обновлена!");
    }

    protected void insert() throws SQLException {
        while (rs.next()) {
            id = rs.getInt(1);
            name = rs.getString(2);
            distance = rs.getInt(3);
            System.out.printf("Id трассы: %d, название: %s, дистанция: %d \n", id, name, distance);
        }

    }

}
