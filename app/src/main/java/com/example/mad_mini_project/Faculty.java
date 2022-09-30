package com.example.mad_mini_project;

public class Faculty {
    String fac_name;
    String fac_id;


    public Faculty(String fac_name, String fac_id) {
        this.fac_name = fac_name;
        this.fac_id = fac_id;

    }

    public String getFacultyName() {
        return fac_name;
    }

    public String getFacultyID() {
        return fac_id;
    }


}
