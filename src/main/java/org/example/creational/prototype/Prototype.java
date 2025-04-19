package org.example.creational.prototype;

public class Prototype {
    public static void main(String[] args) {
        Counter counter = new SimpleCounter();

        counter.increment();
        counter.increment();

        Counter counterClone = counter.clone();
        System.out.println(counter.getCount() + " " + counterClone.getCount());
    }
}

interface Counter {
    int getCount();
    void increment();
    Counter clone();
}

class SimpleCounter implements Counter {
    private int count;

    SimpleCounter() {
        this.count = 0;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void increment() {
        count++;
    }

    @Override
    public Counter clone() {
        var counterClone =  new SimpleCounter();
        counterClone.count = count;
        return counterClone;
    }
}