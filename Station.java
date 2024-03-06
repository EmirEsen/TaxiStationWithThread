package com.bilgeAdam.Week9.TaksiDurak;

import java.util.ArrayDeque;
import java.util.Queue;
public class Station implements Runnable {
    private final Queue<Taxi> taxis;
    private Queue<Customer> customers;

    public Station(int taxiCount) {
        this.taxis = new ArrayDeque<>();
        this.customers = new ArrayDeque<>();
        for (int i = 0; i < taxiCount; i++) {
            taxis.add(new Taxi());
        }
    }

    public void newCustomer(Customer customer) {
        customers.add(customer);
    }

    public Queue<Taxi> getTaxis() {
        return taxis;
    }

    public Queue<Customer> getCustomers() {
        return customers;
    }

    @Override
    public void run() {
        while (!customers.isEmpty()) {
            Taxi taxi = taxis.poll();
            Customer customer = customers.poll();
            taxi.tookCustomer(customer);
            System.out.println(taxi.getNumber() + ". taxi took customer no." + customer.getNumber() + " -> total customers served: " + taxi.getCutomerCount());
            try {
                Thread.sleep(customer.getDistance()/taxi.getSpeed());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            taxis.add(taxi);
        }
//        System.out.println("-".repeat(45));
//        for (Taksi taksi: taksiler) {
//            System.out.println(taksi.getNumber() +". taksi toplam alinan musteri: " + taksi.getCutomerCount());
//        }

    }
}
