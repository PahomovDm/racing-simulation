package com.pahomov.database;

import java.time.LocalDate;

public class History {
    private int idMachine;
    private LocalDate dateRace;
    private int position;
    private int aveSpeed;
    private int errors;

    public int getIdMachine() {
        return idMachine;
    }

    public LocalDate getDateRace() {
        return dateRace;
    }

    public int getPosition() {
        return position;
    }

    public int getAveSpeed() {
        return aveSpeed;
    }

    public int getErrors() {
        return errors;
    }

    public void setIdMachine(int idMachine) {
        this.idMachine = idMachine;
    }

    public void setDateRace(LocalDate dateRace) {
        this.dateRace = dateRace;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setAveSpeed(int aveSpeed) {
        this.aveSpeed = aveSpeed;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

}
