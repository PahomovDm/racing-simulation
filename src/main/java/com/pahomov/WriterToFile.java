package com.pahomov;

import java.io.*;
import java.nio.file.*;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import org.apache.log4j.Logger;
import com.pahomov.dao.*;
import com.pahomov.machine.AbstractMachine;

public class WriterToFile {
    private Scanner scan = new Scanner(System.in);
    public static final Logger LOG = Logger.getLogger(WriterToFile.class);
    private List machine;
    private DaoFactory factory;
    private Connection connection;
    private DaoGeneric dao;
    ConnectDB cDB = new ConnectDB();


    WriterToFile() {
    }

    protected void outputFile() throws PersistException {
        try {
            LOG.info("1");
            machine = dao.getAll();
            LOG.info("2");
            FileOutputStream file = new FileOutputStream(createConsoleFile());
            ObjectOutputStream oos = new ObjectOutputStream(file);
            LOG.info("3");
            oos.writeObject(machine);
            oos.flush();
            LOG.info("4");
            oos.close();
            System.out.println("Save");
        } catch (IOException ex) {
            LOG.info(ex.getMessage());
        }
    }

    protected void inputFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(createConsoleFile());
        ObjectInputStream oin = new ObjectInputStream(fis);
        List<AbstractMachine> machine1 = (List<AbstractMachine>) oin.readObject();
        machine1.stream().forEachOrdered(u -> System.out.println(u.toString()));
    }

    protected void saveMachineToFile(List machine, String adress) {
        try (BufferedWriter bw = createBufferedWriter(adress)) {
            writerList(bw, machine, abstractMachineToString);
        } catch (IOException e) {
            LOG.info(e.getMessage());
        }
    }

    protected String createConsoleFile() {
        System.out.println("Введите дерикторию файла: ");
        String adress = scan.nextLine();

        System.out.println("Введите имя файла: ");
        String nameFile = scan.nextLine();
        return createFile(adress, nameFile);
    };

    protected String createFile(String dir, String nameFile) {
        dir += "/";
        File file = new File(dir);
        Path path = Paths.get(dir);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }
        dir += nameFile;
        new File(dir);
        LOG.info("return " + dir);

        return dir;
    }

    protected BufferedWriter createBufferedWriter(String adress) {
        Writer writer = null;
        try {
            writer = new FileWriter(adress);
        } catch (IOException e) {
            LOG.info(e.getMessage());

        }
        BufferedWriter bw = new BufferedWriter(writer);
        return bw;
    }

    protected void writerList(BufferedWriter bw, List<AbstractMachine> machine,
            Function<AbstractMachine, String> machineString) {

        machine.stream().map(machineString).forEach(m -> {
            try {
                bw.write(m);
            } catch (IOException e) {
                LOG.info(e.getMessage());

            }
        });
        LOG.info("Save");

    }

    Function<AbstractMachine, String> abstractMachineToString = new Function<AbstractMachine, String>() {

        public String apply(AbstractMachine t) {
            LOG.info("machineString");

            String str;
            str = String.format("%s, %s, %d, %f, %f \n", t.getType(), t.getName(), t.getMassa(), t.getMaxSpeed(),
                    t.getAcceleration());
            return str;
        }

    };
}
