package com.example.mad_mini_project;

public class BusDetails {
    String drv_busno;
    String drv_name;
    String drv_phone;
    String route;

    public BusDetails(String drv_busno, String drv_name, String drv_phone,String route) {
        this.drv_busno = drv_busno;
        this.drv_name = drv_name;
        this.drv_phone = drv_phone;
        this.route = route;
    }

    public String getTextno() {
        return drv_busno;
    }

    public String getTextdriver() {
        return drv_name;
    }

    public String getTextroute() {
        return drv_phone;
    }

    public String getTextphone() {
        return route;
    }
}
