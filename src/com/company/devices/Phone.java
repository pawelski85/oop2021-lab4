package com.company.devices;

import java.util.ArrayList;
import java.util.List;

public class Phone implements Device {

    private BrandApplication.Brand brand;
    private String model;
    private OS operatingSystem;
    private List<Application> installedApplications;

    public BrandApplication.Brand getBrand() {
        return brand;
    }

    public void setBrand(BrandApplication.Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public OS getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OS operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Phone() {
        installedApplications = new ArrayList<>();
    }


    public boolean installApplication(Application application) {

        for (Application app: installedApplications ) {
            if (app.Name.equals(application.Name)){
                if (app.Version >= application.Version){
                    return false;
                }
                installedApplications.remove(app);
                break;
            }
        }

        if (operatingSystem != application.SupportedOS){
            return false;
        }

        installedApplications.add(application);;

        System.out.println("Installing app");
        return true;
    }

    public boolean installBrandApplication(BrandApplication application) {

        if (brand != application.SupportedBrand){
            return false;
        }
        return installApplication(application);
    }

}
