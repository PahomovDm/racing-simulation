package com.pahomov;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesRead {
    public static final Logger LOG = Logger.getLogger(Test.class);
    private String folderPath;
    private String fileName;
    private int periodWork;
    private int timeHour;

    public String getFolderPath() {
        return folderPath;
    }

    public String getFileName() {
        return fileName;
    }

    public int getPeriodMinutes() {
        return periodWork;
    }

    public int getTimeHour() {
        return timeHour;
    }

    public void run() {
        LOG.info("Start PropertiesRead");
        inputProperty();
        LOG.info("Finish PropertiesRead");
    }

    private void inputProperty() {
        FileInputStream fis;
        Properties prop = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            prop.load(fis);
            folderPath = prop.getProperty("folderPath");
            fileName = prop.getProperty("fileName");
            periodWork = Integer.parseInt(prop.getProperty("period"));
            timeHour = Integer.parseInt(prop.getProperty("timeHour"));
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

}
