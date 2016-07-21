package com.pahomov.database;

public class Track {
    private String name;
    private int distance;
    private int id;

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return getId() + getName() + getDistance();
    }
}
