package org.example.event;

import java.util.LinkedList;

public class EventQueue {

    private final static int DEDAULT_MAX_EVENT = 10;
    private final int max;

    public EventQueue(int max) {
        this.max = max;
    }

    public EventQueue(){
        this(DEDAULT_MAX_EVENT);
    }

    static class Event{

    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    public void offer(Event event){
        synchronized (eventQueue){
            if(eventQueue.size()>= max){
                console("Oops...the queue is full");
                try {
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            console("The new event is submitted!");
            eventQueue.addLast(event);
            eventQueue.notify();
        }
    }

    public Event take(){
        synchronized (eventQueue){
            if(eventQueue.isEmpty()){
                console("Oops... the queue is empty");
                try {
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Event event = eventQueue.removeFirst();
            eventQueue.notify();
            console("The event "+ event+"is handled");
            return event;
        }
    }

    public void offer2(Event event) throws InterruptedException {
        synchronized (eventQueue){
            if(eventQueue.size()>=max){
                console("Oops... the queue is full");
                eventQueue.wait();
            }
            console("The new event is submitted!");
            eventQueue.addLast(event);
            eventQueue.notifyAll();
        }
    }

    public Event take2(){
        synchronized (eventQueue){
            if(eventQueue.isEmpty()){
                console("Oops... the queue is empty");
                try {
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Event event = eventQueue.removeFirst();
            this.eventQueue.notifyAll();
            console("The event "+ event+"is handled");
            return event;
        }
    }

    private void console(String message) {
        System.out.printf("%s:%s\n", Thread.currentThread().getName(),message);
    }

}
