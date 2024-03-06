package com.bilgeAdam.Week9.TaksiDurak;

import java.util.Random;

public class Taxi {
    Random random = new Random();
    private static int no;
    private final int number;
    private int cutomerCount;
    private Customer customer;
    private int speed;

    public Taxi() {
        no++;
        this.number = no;
        this.speed = random.nextInt(100, 5000);
    }

    public int getNumber() {
        return number;
    }

    public int getCutomerCount() {
        return cutomerCount;
    }

    public void tookCustomer(Customer customer) {
        this.customer = customer;
        this.cutomerCount++;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "number=" + number +
                ", speed=" + speed +
                '}';
    }
}
