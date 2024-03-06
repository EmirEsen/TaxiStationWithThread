package com.bilgeAdam.Week9.TaksiDurak;

import java.util.ArrayDeque;
import java.util.Queue;
public class Durak implements Runnable {
    private final Queue<Taksi> taksiler;
    private Queue<Customer> customers;

    public Durak(int taxiCount) {
        this.taksiler = new ArrayDeque<>();
        this.customers = new ArrayDeque<>();
        for (int i = 0; i < taxiCount; i++) {
            taksiler.add(new Taksi());
        }
    }

    public void newCustomer(Customer customer) {
        customers.add(customer);
    }

    public Queue<Taksi> getTaksiler() {
        return taksiler;
    }

    public Queue<Customer> getCustomers() {
        return customers;
    }

    @Override
    public void run() {
        while (!customers.isEmpty()) {
            Taksi taksi = taksiler.poll();
            Customer customer = customers.poll();
            taksi.tookCustomer(customer);
            System.out.println(taksi.getNumber() + ". taxi took customer no." + customer.getNumber() + " -> total customers served: " + taksi.getCutomerCount());
            try {
                Thread.sleep(customer.getDistance()/taksi.getSpeed());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            taksiler.add(taksi);
        }
//        System.out.println("-".repeat(45));
//        for (Taksi taksi: taksiler) {
//            System.out.println(taksi.getNumber() +". taksi toplam alinan musteri: " + taksi.getCutomerCount());
//        }

    }
}
