package org.example.creational.builder;

public class Builder {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilderImpl();
        var car = carBuilder
                .withColor("red")
                .withEngineType("Petrol")
                .withSeatCapacity(6)
                .withSunroof(true)
                .build();

        System.out.println(car);
    }
}

class Car  {
    private String color;
    private String engineType;
    private int seatCapacity;
    private boolean hasSunroof;

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", engineType='" + engineType + '\'' +
                ", seatCapacity=" + seatCapacity +
                ", hasSunroof=" + hasSunroof +
                '}';
    }
}

interface CarBuilder {
    CarBuilder withColor(String color);
    CarBuilder withEngineType(String engineType);
    CarBuilder withSeatCapacity(int seatCapacity);
    CarBuilder withSunroof(boolean sunroof);
    Car build();
}

class CarBuilderImpl implements CarBuilder {
    private final Car car;

    CarBuilderImpl() {
        this.car = new Car();
    }

    @Override
    public CarBuilder withColor(String color) {
        car.setColor(color);
        return this;
    }

    @Override
    public CarBuilder withEngineType(String engineType) {
        car.setEngineType(engineType);
        return this;
    }

    @Override
    public CarBuilder withSeatCapacity(int seatCapacity) {
        car.setSeatCapacity(seatCapacity);
        return this;
    }

    @Override
    public CarBuilder withSunroof(boolean sunroof) {
        car.setHasSunroof(sunroof);
        return this;
    }

    @Override
    public Car build() {
        return car;
    }
}
