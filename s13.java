/*// Volt class
class Volt {
    int volts;
    Volt(int v) { volts = v; }
    int getVolts() { return volts; }
}

// Socket (produces 120V)
class Socket {
    Volt getVolt() { return new Volt(120); }
}

// Class Adapter
class SocketAdapter extends Socket {
    Volt get120Volt() { return getVolt(); }
    Volt get12Volt() { return new Volt(getVolt().getVolts() / 10); }
    Volt get3Volt()  { return new Volt(getVolt().getVolts() / 40); }
}

// Client
public class MobileCharger {
    public static void main(String[] args) {
        SocketAdapter adapter = new SocketAdapter();

        System.out.println("Mobile needs 3V: " + adapter.get3Volt().getVolts() + "V");
        System.out.println("Laptop needs 12V: " + adapter.get12Volt().getVolts() + "V");
        System.out.println("Home Appliance needs 120V: " + adapter.get120Volt().getVolts() + "V");
    }
}
*/
// Volt class
class Volt {
    private int volts;

    public Volt(int volts) {
        this.volts = volts;
    }

    public int getVolts() {
        return volts;
    }
}

// Socket class (gives 120V)
class Socket {
    public Volt getVolt() {
        return new Volt(120);
    }
}

// Adapter interface
interface SocketAdapter {
    Volt get120Volt();
    Volt get12Volt();
    Volt get3Volt();
}

// Class Adapter (using inheritance)
class SocketClassAdapterImpl extends Socket implements SocketAdapter {

    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        return convertVolt(getVolt(), 10);
    }

    @Override
    public Volt get3Volt() {
        return convertVolt(getVolt(), 40);
    }

    private Volt convertVolt(Volt v, int divider) {
        return new Volt(v.getVolts() / divider);
    }
}

// Client code
public class s13 {
    public static void main(String[] args) {
        SocketAdapter adapter = new SocketClassAdapterImpl();

        Volt v3 = adapter.get3Volt();
        Volt v12 = adapter.get12Volt();
        Volt v120 = adapter.get120Volt();

        System.out.println("Mobile needs 3V: " + v3.getVolts() + "V");
        System.out.println("Laptop needs 12V: " + v12.getVolts() + "V");
        System.out.println("Home appliance needs 120V: " + v120.getVolts() + "V");
    }
}

