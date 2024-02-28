package org.multithread;

public class TicketWindow extends Thread{

    private final String name;

    private static final int MAX = 50;

    private static int index =1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX){
            System.out.println("Current: " + name+ ": " + (index++));
        }
    }



    public static void main(String[] args) {

        TicketWindow ticketWindow1 = new TicketWindow("Counter one");

        ticketWindow1.start();

        TicketWindow ticketWindow2 = new TicketWindow("Counter two");

        ticketWindow2.start();

        TicketWindow ticketWindow3 = new TicketWindow("Counter three");

        ticketWindow3.start();

        TicketWindow ticketWindow4 = new TicketWindow("Counter four");

        ticketWindow4.start();
    }
}
