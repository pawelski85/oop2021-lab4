package com.company.devices;

public class Human {
    private double cash;
    private Device device;




    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }


    public boolean installApplication(Application application) {

        if (application.Paid == true){
            if (cash < application.Price){
                return false;
            }
        }

        return device.installApplication(application);
    }

}
