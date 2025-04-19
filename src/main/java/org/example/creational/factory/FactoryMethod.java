package org.example.creational.factory;

public class FactoryMethod {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory truckFactory = new TruckFactory();


        var car = carFactory.createVehicle();
        car.drive();

        var truck = truckFactory.createVehicle();
        truck.drive();
    }
}

interface Vehicle {
    void drive();
}

class Car implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving Car");
    }
}

class Truck implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving Truck");
    }
}

interface VehicleFactory {
    Vehicle createVehicle();
}

class CarFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

class TruckFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }
}