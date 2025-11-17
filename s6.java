// Command Interface

interface Command {

    void execute();
}

// Receiver class
class Light {

    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}

// Concrete Commands
class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}

// Invoker class
class RemoteControl {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Client
public class s6 {

    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        Light livingRoomLight = new Light();

        // Turn ON the light
        remote.setCommand(new LightOnCommand(livingRoomLight));
        remote.pressButton();

        // Turn OFF the light
        remote.setCommand(new LightOffCommand(livingRoomLight));
        remote.pressButton();
    }
}
