// Command interface
interface Command {
    void execute();
    void undo();
}

// Receiver
class CeilingFan {
    void on() { System.out.println("Ceiling Fan ON"); }
    void off() { System.out.println("Ceiling Fan OFF"); }
}

// Client / Main
public class s7 {
    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();

        // Commands as simple anonymous classes
        Command fanOn = new Command() {
            public void execute() { fan.on(); }
            public void undo() { fan.off(); }
        };

        Command fanOff = new Command() {
            public void execute() { fan.off(); }
            public void undo() { fan.on(); }
        };

        // Use commands
        fanOn.execute();   // Turn fan ON
        fanOn.undo();      // Undo → Turn fan OFF

        fanOff.execute();  // Turn fan OFF
        fanOff.undo();     // Undo → Turn fan ON
    }
}

