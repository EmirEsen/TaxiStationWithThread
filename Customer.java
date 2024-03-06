package com.bilgeAdam.Week9.TaksiDurak;

import java.util.Random;

public class Customer {

    Random random = new Random();
    private static int no;
    private final int number;
    private int distance;

    public Customer() {
        no++;
        number = no;
        this.distance = random.nextInt(1000, 60000);
    }

    public int getNumber() {
        return number;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "number=" + number +
                ", distance=" + distance +
                '}';
    }
}
