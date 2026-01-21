import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Vehicle car1 = new Car("Toyota", "Camry", 2020, 4, "Automatic");
        Vehicle bike1 = new Motorcycle("Yamaha", "R1", 2019, "Sport", false);

        Garage garage = new Garage("Main Garage");

        garage.addVehicle(car1);
        garage.addVehicle(bike1);

        garage.listVehicles();

        car1.startEngine();
        bike1.startEngine();
    }
}


class Vehicle {
    protected String brand;
    protected String model;
    protected int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void startEngine() {
        System.out.println(brand + " " + model + ": engine started");
    }

    public void stopEngine() {
        System.out.println(brand + " " + model + ": engine stopped");
    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + year + ")";
    }
}


class Car extends Vehicle {
    private int doors;
    private String transmission;

    public Car(String brand, String model, int year, int doors, String transmission) {
        super(brand, model, year);
        this.doors = doors;
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Car: " + super.toString() +
                ", doors=" + doors +
                ", transmission=" + transmission;
    }
}


class Motorcycle extends Vehicle {
    private String bodyType;
    private boolean hasBox;

    public Motorcycle(String brand, String model, int year, String bodyType, boolean hasBox) {
        super(brand, model, year);
        this.bodyType = bodyType;
        this.hasBox = hasBox;
    }

    @Override
    public String toString() {
        return "Motorcycle: " + super.toString() +
                ", bodyType=" + bodyType +
                ", box=" + (hasBox ? "yes" : "no");
    }
}


class Garage {
    private String name;
    private List<Vehicle> vehicles = new ArrayList<>();

    public Garage(String name) {
        this.name = name;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println(vehicle + " added to " + name);
    }

    public void listVehicles() {
        System.out.println("\nVehicles in " + name + ":");
        for (Vehicle v : vehicles) {
            System.out.println(" - " + v);
        }
    }
}
