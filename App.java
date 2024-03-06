package com.bilgeAdam.Week9.TaksiDurak;

public class App {


    public static void main(String[] args) {

        Durak durak = new Durak(10);

        //Customers lined up in Durak
        for (int i = 0; i < 100; i++) {
            durak.newCustomer(new Customer());
        }

        Thread thread = new Thread(durak);
        Thread thread1 = new Thread(durak);
        Thread thread2 = new Thread(durak);

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
        for (Taksi taksi: durak.getTaksiler()) {
            System.out.println("Taxi #" + taksi.getNumber() +": " + taksi.getCutomerCount());
        }

//        durak.getTaksiler().forEach(System.out::println);
//        durak.getCustomers().forEach(System.out::println);


    }
}
