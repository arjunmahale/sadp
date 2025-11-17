// Behavior interfaces

interface FlyBehavior {

    void fly();
}

interface QuackBehavior {

    void quack();
}

// Duck class
class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    Duck(FlyBehavior fly, QuackBehavior quack) {
        this.flyBehavior = fly;
        this.quackBehavior = quack;
    }

    void performFly() {
        flyBehavior.fly();
    }

    void performQuack() {
        quackBehavior.quack();
    }

    void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }

    void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }
}

// Main class
public class s10 {

    public static void main(String[] args) {
        // Mallard Duck
        Duck mallard = new Duck(
                () -> System.out.println("Flying with wings!"),
                () -> System.out.println("Quack!")
        );
        System.out.println("Mallard Duck:");
        mallard.performFly();
        mallard.performQuack();

        // Rubber Duck
        Duck rubberDuck = new Duck(
                () -> System.out.println("I cannot fly!"),
                () -> System.out.println("Squeak!")
        );
        System.out.println("\nRubber Duck:");
        rubberDuck.performFly();
        rubberDuck.performQuack();

        // Change behavior at runtime
        System.out.println("\nRubber Duck learns to fly!");
        rubberDuck.setFlyBehavior(() -> System.out.println("Flying with wings now!"));
        rubberDuck.performFly();
    }
}
