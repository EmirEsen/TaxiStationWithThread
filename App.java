package com.bilgeAdam.Week9.TaksiDurak;

public class App {


    public static void main(String[] args) {

        Station station = new Station(10);

        //Customers lined up in Durak
        for (int i = 0; i < 100; i++) {
            station.newCustomer(new Customer());
        }

        Thread thread = new Thread(station);
        Thread thread1 = new Thread(station);
        Thread thread2 = new Thread(station);

        thread.start();
        thread1.start();
        thread2.start();

        try {
            thread.join();
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--------Total Customers Served--------");
        for (Taxi taxi : station.getTaxis()) {
            System.out.println("Taxi #" + taxi.getNumber() +": " + taxi.getCutomerCount());
        }

        station.getTaxis().forEach(System.out::println);
        station.getCustomers().forEach(System.out::println);


    }
}
