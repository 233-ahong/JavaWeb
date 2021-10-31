package com.example.w3.information.department;

public class Department {
    private String id;
    private String name;
    private String Dmanager;
    private int Pnumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDmanager() {
        return Dmanager;
    }

    public void setDmanager(String dmanager) {
        Dmanager = dmanager;
    }

    public int getPnumber() {
        return Pnumber;
    }

    public void setPnumber(int pnumber) {
        Pnumber = pnumber;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", Dmanager='" + Dmanager + '\'' +
                ", Pnumber=" + Pnumber +
                '}';
    }
}
