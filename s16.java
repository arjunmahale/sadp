
import java.util.*;

public class s16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // List of observers (each observer is just a lambda function)
        List<java.util.function.IntConsumer> observers = new ArrayList<>();
        observers.add(n -> System.out.println("Binary: " + Integer.toBinaryString(n)));
        observers.add(n -> System.out.println("Octal: " + Integer.toOctalString(n)));
        observers.add(n -> System.out.println("Hexadecimal: " + Integer.toHexString(n).toUpperCase()));

        while (true) {
            System.out.print("\nEnter a decimal number (-1 to exit): ");
            int num = sc.nextInt();
            if (num == -1) {
                break;
            }

            // Notify all observers
            for (var obs : observers) {
                obs.accept(num);
            }
        }
        sc.close();
    }
}
