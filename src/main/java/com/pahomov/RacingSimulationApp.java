package com.pahomov;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pahomov.dao.*;
import com.pahomov.machine.*;
import com.pahomov.machine.builder.*;

// один поток просчитывает координаты каждую секунду
// второй выводит каждые пять секунд
public class RacingSimulationApp {
    int i;
    private Car car;
    private Bus bus;
    private Truck truck;
    private Trailer trailer;
    private DaoGeneric dao;
    private List machine;
    private ConnectDB connectDB = new ConnectDB();
    private Scanner scan = new Scanner(System.in);
    private ThreadSave ts = new ThreadSave();

    public static final Logger LOG = Logger.getLogger(RacingSimulationApp.class);

    public static void main(String[] args) {
        new RacingSimulationApp().run();
    }

    private void run() {
        LOG.info("Start app");
        ts.startThread();
        selectAction();
        ts.stopThread();
        LOG.info("Finish");
    }

    private void selectAction() {
        WriterToFile writer = new WriterToFile();
        do {
            System.out.println("Выбирете действие:");
            System.out.println(
                    "1) Добавить машину \n2) Удалить машину \n3) Редактировать данные машины \n4) Посмотреть все машины "
                            + "\n5) Сохранить объекты в файл \n51 Импортировать \n6) Cохранить машинки в файл \n0) Выйти");
            i = scan.nextInt();
            if (i == 1) {
                try {
                    createMachine();
                } catch (PersistException e) {
                    LOG.info(e.getMessage());
                }
            }
            if (i == 2) {
                deleteMachine();
            }
            if (i == 3) {
                try {
                    updateMachine();
                } catch (PersistException e) {
                    LOG.info(e.getMessage());

                }
            }
            if (i == 4) {
                getAllMachine();
            }
            if (i == 5) {
                try {
                    writer.outputFile();
                } catch (PersistException e) {
                    LOG.info(e.getMessage());

                }
            }
            if (i == 6) {
                writer.saveMachineToFile(getAllList(), writer.createConsoleFile());
            }
            if (i == 51) {
                try {
                    writer.inputFile();
                } catch (ClassNotFoundException | IOException e) {
                    LOG.info(e.getMessage());
                }

            }
            if (i == 7) {
                simulation();
            }
        } while (i != 0);
    }

    private void getAllMachine() {
        try {
            dao = connectDB.connect();
            machine = dao.getAll();
            connectDB.close();
        } catch (PersistException e) {
            LOG.info(e.getMessage());

        }
        machine.stream().forEachOrdered(m -> System.out.println(m));
    }

    private void updateMachine() throws PersistException {
        AbstractMachine machine = selectMachine();
        dao = connectDB.connect();
        System.out.println("Редактируется " + dao.read(machine.getId()).toString());
        scan.nextLine();
        System.out.println("Новое имя");
        machine.setName(scan.nextLine());
        System.out.println("Новая масса");
        machine.setMassa(scan.nextInt());
        System.out.println("Новая максимальная скорость");
        machine.setMaxSpeed(scan.nextDouble());
        System.out.println("Новое ускорение");
        machine.setAcceleration(scan.nextDouble());
        dao.update(machine);
        connectDB.close();
    }

    private void deleteMachine() {
        dao = connectDB.connect();
        getAllMachine();
        System.out.println("Введите id удаляемой машины");
        int aId = scan.nextInt();
        try {
            dao.delete(aId);
        } catch (PersistException e) {
            LOG.error(e);
        }
        connectDB.close();
    }

    private void createMachine() throws PersistException {
        dao = connectDB.connect();
        System.out.println("Введите тип машины");
        System.out.println("1) Car \n2) Bus \n3) Truck");
        int e = scan.nextInt();
        if (e == 1) {
            car = new BuilderCar().name().massa().maxSpeed().acceleration().build();
            dao.create(car);
        }
        if (e == 2) {
            bus = new BuilderBus().name().massa().maxSpeed().acceleration().build();
            dao.create(bus);

        }
        if (e == 3) {
            truck = new BuilderTruck().name().massa().maxSpeed().acceleration().massaCargo().build();
            dao.create(truck);

        }
        if (e == 4) {
            trailer = new BuilderTrailer().name().massa().maxSpeed().build();
            dao.create(trailer);

        }
        connectDB.close();
        System.out.println("Машина создана и добавлена в базу данных");
    }

    private List getAllList() {
        dao = connectDB.connect();
        try {
            machine = dao.getAll();
        } catch (PersistException e) {
            LOG.info(e.getMessage());

        }
        connectDB.close();
        return machine;

    }

    private AbstractMachine selectMachine() {
        getAllMachine();
        System.out.println("Введите id машины");
        int aId = scan.nextInt();
        AbstractMachine machine = null;
        try {
            dao = connectDB.connect();
            machine = (AbstractMachine) dao.read(aId);
            connectDB.close();
        } catch (PersistException e) {
            LOG.info(e.getMessage());
        }
        return machine;
    }

    private void simulation() {
        AbstractMachine machine = selectMachine();
        MotionSimulation motionMachine = new MotionSimulation(machine);
        motionMachine.calculateDistance();
        motionMachine.printToConsole();
        // int t = 0;
        // while (true) {
        // try {
        // Thread.sleep(1000);
        // } catch (InterruptedException e) {
        // LOG.info("Error Sleep");
        // }
        // t++;
        // motionMachine.calculateDistance(t);
        // System.out.println("Расстояние " + motionMachine.getDistance() + "
        // скорость " + motionMachine.getSpeed());
        // }
    }
}
