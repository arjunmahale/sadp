public class s14 {
    // Command interface
    interface Command { void execute(); }

    public static void main(String[] args) {
        // Receivers
        class Light { void on() { System.out.println("Light ON"); } void off() { System.out.println("Light OFF"); } }
        class GarageDoor { void up() { System.out.println("Garage Door UP"); } }
        class Stereo { void on() { System.out.println("Stereo ON"); } void cd() { System.out.println("Stereo CD"); } void volume(int v) { System.out.println("Stereo Volume " + v); } }

        Light light = new Light();
        GarageDoor garage = new GarageDoor();
        Stereo stereo = new Stereo();

        // Commands executed directly
        Command lightOn = () -> light.on();
        Command lightOff = () -> light.off();
        Command garageUp = () -> garage.up();
        Command stereoOn = () -> { stereo.on(); stereo.cd(); stereo.volume(11); };

        // Run commands
        lightOn.execute();
        lightOff.execute();
        garageUp.execute();
        stereoOn.execute();
    }
}

