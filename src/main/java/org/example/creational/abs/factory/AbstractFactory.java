package org.example.creational.abs.factory;

public class AbstractFactory {
    public static void main(String[] args) {
        // when you need to create a family of related object
        VehicleFactory indianFactory = new IndianVehicleFactory();
        VehicleFactory americanFactory = new AmericanVehicleFactory();


        var car = indianFactory.createCar();
        car.drive();

        var truck = americanFactory.createTruck();
        truck.drive();
    }
}

interface Vehicle {
    void drive();
}

interface Car extends Vehicle {

}

interface Truck extends Vehicle {

}

class IndianCar implements Car {

    @Override
    public void drive() {
        System.out.println("Driving Indian Car");
    }
}
class AmericanCar implements Car {

    @Override
    public void drive() {
        System.out.println("Driving American Car");
    }
}

class IndianTruck implements Truck {

    @Override
    public void drive() {
        System.out.println("Driving Indian Truck");
    }
}

class AmericanTruck implements Truck {

    @Override
    public void drive() {
        System.out.println("Driving American Truck");
    }
}



interface VehicleFactory {
    Vehicle createCar();
    Vehicle createTruck();
}

class IndianVehicleFactory implements VehicleFactory {

    @Override
    public Vehicle createCar() {
        return new IndianCar();
    }

    @Override
    public Vehicle createTruck() {
        return new IndianTruck();
    }
}

class AmericanVehicleFactory implements VehicleFactory {

    @Override
    public Vehicle createCar() {
        return new AmericanCar();
    }

    @Override
    public Vehicle createTruck() {
        return new AmericanTruck();
    }
}



