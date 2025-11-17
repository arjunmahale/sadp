// Component interface
interface Car {
    void assemble();
}

// Concrete component
class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.print("Basic Car");
    }
}

// Concrete Decorator - Sports Car
class SportsCar implements Car {
    private Car car;

    public SportsCar(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        car.assemble();
        System.out.print(" + Sports Car features");
    }
}

// Concrete Decorator - Luxury Car
class LuxuryCar implements Car {
    private Car car;

    public LuxuryCar(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        car.assemble();
        System.out.print(" + Luxury Car features");
    }
}

// Client code
public class s12 {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        System.out.print("SportsCar: ");
        sportsCar.assemble();
        System.out.println();

        Car luxuryCar = new LuxuryCar(new BasicCar());
        System.out.print("LuxuryCar: ");
        luxuryCar.assemble();
        System.out.println();

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        System.out.print("SportsLuxuryCar: ");
        sportsLuxuryCar.assemble();
        System.out.println();
    }
}

