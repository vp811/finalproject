package com.example.codegreen;

public class CO2DataObject {
    private double food;
    private double transport;
    private double clothing;
    private double other;

    public CO2DataObject() {
        food = 0;
        transport = 0;
        clothing = 0;
        other = 0;
    }

    public void setClothing(double clothing) {
        this.clothing = clothing;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public void setOther(double other) {
        this.other = other;
    }

    public void setTransport(double transport) {
        this.transport = transport;
    }

    public double getClothing() {
        return clothing;
    }

    public double getFood() {
        return food;
    }

    public double getOther() {
        return other;
    }

    public double getTransport() {
        return transport;
    }
}
