// Shape interface
interface Shape {
    void draw();
}

// Concrete shapes
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Abstract Factory
abstract class AbstractFactory {
    abstract Shape getShape(String shapeType);
}

// ShapeFactory
class ShapeFactory extends AbstractFactory {
    Shape getShape(String shapeType) {
        if (shapeType == null) return null;
        if (shapeType.equalsIgnoreCase("CIRCLE")) return new Circle();
        if (shapeType.equalsIgnoreCase("RECTANGLE")) return new Rectangle();
        return null;
    }
}

// Factory producer
class FactoryProducer {
    static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) return new ShapeFactory();
        return null;
    }
}

// Client code
public class s17 {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        // Get a Circle and draw
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        // Get a Rectangle and draw
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
    }
}


/*
// Shape interface
interface Shape {
    void draw();
}

// Concrete shapes
class Circle implements Shape {
    public void draw() { System.out.println("Drawing a Circle"); }
}

class Rectangle implements Shape {
    public void draw() { System.out.println("Drawing a Rectangle"); }
}

// Shape Factory
class ShapeFactory {
    Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) return new Circle();
        if (shapeType.equalsIgnoreCase("RECTANGLE")) return new Rectangle();
        return null;
    }
}

// Client code
public class AbstractFactorySimpleDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
    }
}
*/
