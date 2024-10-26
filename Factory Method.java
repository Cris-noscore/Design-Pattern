// Interface do produto
interface Vehicle {
    void drive();
}

// Produtos concretos
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Dirigindo um carro...");
    }
}

class Motorcycle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Pilotando uma moto...");
    }
}

class Truck implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Conduzindo um caminhão...");
    }
}

// Criador abstrato (Factory)
abstract class VehicleFactory {
    // Factory Method
    public abstract Vehicle createVehicle();
    
    // Método que usa o Factory Method
    public void deliverVehicle() {
        Vehicle vehicle = createVehicle();
        System.out.println("Preparando o veículo para entrega...");
        vehicle.drive();
    }
}

// Criadores concretos
class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

class MotorcycleFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Motorcycle();
    }
}

class TruckFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }
}

// Classe principal para demonstração
public class Main {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        VehicleFactory truckFactory = new TruckFactory();
        
        System.out.println("Usando CarFactory:");
        carFactory.deliverVehicle();
        
        System.out.println("\nUsando MotorcycleFactory:");
        motorcycleFactory.deliverVehicle();
        
        System.out.println("\nUsando TruckFactory:");
        truckFactory.deliverVehicle();
    }
}

