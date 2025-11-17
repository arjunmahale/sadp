// Simple thread-safe Singleton

class Singleton {

    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton instance created!");
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage(String threadName) {
        System.out.println("Hello from Singleton! Called by " + threadName);
    }
}

// Main class
public class s2 {

    public static void main(String[] args) {
        Runnable task = () -> {
            Singleton obj = Singleton.getInstance();
            obj.showMessage(Thread.currentThread().getName());
        };

        new Thread(task, "Thread-1").start();
        new Thread(task, "Thread-2").start();
        new Thread(task, "Thread-3").start();
    }
}
