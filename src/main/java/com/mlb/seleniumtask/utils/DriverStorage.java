package com.mlb.seleniumtask.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DriverStorage {

    private static final Logger LOG = Logger.getLogger(DriverStorage.class);

    private volatile Map<Long, WebDriver> driverMap;
    private volatile static DriverStorage storage;

    private DriverStorage() {
        this.driverMap = new ConcurrentHashMap();
    }

    public void put(Long idThread, WebDriver driver) {
        driverMap.put(idThread, driver);
    }

    public WebDriver get() {
        return driverMap.get(getThreadId());
    }

    private Long getThreadId() {
        return Thread.currentThread().getId();
    }

    public static void pause(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            LOG.error(e);
        }
    }

    public static DriverStorage getInstance() {
        if(storage == null) {
            synchronized (DriverStorage.class) {
                if(storage == null) {
                    storage = new DriverStorage();
                }
            }
        }
        return storage;
    }
}
