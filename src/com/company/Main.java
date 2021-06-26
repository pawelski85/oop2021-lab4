package com.company;

import com.company.devices.*;

public class Main {

    public static void main(String[] args) {

        Application[] apps = new Application[10];
        for (int i = 0; i < apps.length; i++) {
            apps[i] = new Application();
            if (Math.random() > 0.5) {
                apps[i].Paid = true;
            } else {
                apps[i].Paid = false;
            }
            if (Math.random() > 0.5) {
                apps[i].SupportedOS = OS.iOS;
            } else {
                apps[i].SupportedOS = OS.Android;
            }
        }

        var phone = new Phone();
        phone.setOperatingSystem(OS.Android);


        Application iosApp = new Application();
        iosApp.SupportedOS = OS.iOS;
        iosApp.Name = "Map";
        iosApp.Version = 1;
        System.out.println("Install ios app on android: "
                + phone.installApplication(iosApp));

        Application adrApp = new Application();
        adrApp.SupportedOS = OS.Android;
        adrApp.Name = "Mail";
        adrApp.Version = 6;
        adrApp.Paid = true;
        System.out.println("Install android app on android: "
                + phone.installApplication(adrApp));

        var human = new Human();
        human.setDevice(phone);



        Application adrApp2 = new Application();
        adrApp2.SupportedOS = OS.Android;
        adrApp2.Name = "News";
        adrApp2.Version = 7;
        adrApp2.Paid = true;

        human.setCash(60.0);
        adrApp2.Price = 80.0;

        System.out.println("can afford app which costs $80 with $60: "
                + human.installApplication(adrApp2));
        adrApp2.Price = 50.0;
        System.out.println("can afford app which costs $50 with $60: "
                + human.installApplication(adrApp2));


        BrandApplication hw = new BrandApplication();
        hw.SupportedBrand = BrandApplication.Brand.Huawei;
        hw.SupportedOS = OS.Android;

        phone.setBrand(BrandApplication.Brand.Google);

        System.out.println("install Huawei app on ㅎoogle supported phone: "
                + phone.installBrandApplication(hw));

        phone.setBrand(BrandApplication.Brand.Huawei);
        System.out.println("install Huawei app on Huawei supported phone: "
                + phone.installBrandApplication(hw));

    }
}
