package com.pahomov;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.pahomov.dao.DaoGeneric;
import com.pahomov.dao.PersistException;
import com.pahomov.machine.AbstractMachine;
import com.pahomov.mysql.MySqlMachineDao;

public class ThreadSave {
    public static final Logger LOG = Logger.getLogger(ThreadSave.class);
    private PropertiesRead pf = new PropertiesRead();
    private DaoGeneric dao;
    private WriterToFile writer = new WriterToFile();
    private ScheduledExecutorService service;
    private ConnectDB connectDB = new ConnectDB();

    public ThreadSave() {
    }

    private void saveToFile() {
        List<AbstractMachine> machine = new ArrayList<>();
        try {
            machine = ((MySqlMachineDao) dao).sortMachineTime(pf.getTimeHour());
        } catch (PersistException e) {
            LOG.error("Array getMassa400 unavailable");
        }
        writer.saveMachineToFile(machine, pf.getFolderPath() + pf.getFileName());
    }

    protected void startThread() {
        pf.run();
        writer.createBufferedWriter(writer.createFile(pf.getFolderPath(), pf.getFileName()));
        service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                dao = connectDB.connect();
                saveToFile();
                connectDB.close();
            }
        }, 0, pf.getPeriodMinutes(), TimeUnit.SECONDS);
    }

    protected void stopThread() {
        service.shutdownNow();
    }

}
