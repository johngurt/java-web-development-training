package visitor;

/**
 * @author Hurt Yevhenii
 */
public class VisitorApp {
    public static void main(String[] args) {
//        Element body = new BodyElement();
//        Element engine = new EngineElement();
//        Visitor mechanic = new HooliganVisitor();
//
//        body.accept(mechanic);
//        engine.accept(mechanic);

        Element car = new CarElement();
        car.accept(new HooliganVisitor());
        System.out.println();
        car.accept(new MechanicVisitor());
    }
}

//Visitor
interface Visitor {
    void visit(EngineElement engine);
    void visit(BodyElement body);
    void visit(CarElement car);
    void visit(WheelElement wheel);
}

interface Element {
    void accept(Visitor visitor);
}

class BodyElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class EngineElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class CarElement implements Element {

    Element[] elements;

    public CarElement() {
        this.elements = new Element[]{new WheelElement("Front right"), new  WheelElement("Front left"),
            new WheelElement("Rear right"), new WheelElement("Rear left"), new BodyElement(), new EngineElement()};
    }

    @Override
    public void accept(Visitor visitor) {
        for (Element elem : elements) {
            elem.accept(visitor);
        }
        visitor.visit(this);
    }
}

class WheelElement implements Element {

    private String name;

    public WheelElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor {

    @Override
    public void visit(CarElement car) {
        System.out.println("Smoked inside car");
    }

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Started the engine");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Knocked on the body");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Kicked " + wheel.getName() + " wheel");
    }
}

class MechanicVisitor implements Visitor {

    @Override
    public void visit(CarElement car) {
        System.out.println("Checked the appearance of the car");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Pump up " + wheel.getName() + " wheel");
    }

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Checked engine");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Polished body");
    }
}