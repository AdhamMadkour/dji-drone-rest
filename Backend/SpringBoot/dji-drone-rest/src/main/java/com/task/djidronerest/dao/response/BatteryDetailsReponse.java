package com.task.djidronerest.dao.response;

public class BatteryDetailsReponse {
    private String serialNumber;
    private int batteryPercentage;

    public BatteryDetailsReponse() {
    }
    public BatteryDetailsReponse(String serialNumber, int batteryPercentage) {
        this.serialNumber = serialNumber;
        this.batteryPercentage = batteryPercentage;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getBatteryPercentage() {
        return batteryPercentage;
    }
}
