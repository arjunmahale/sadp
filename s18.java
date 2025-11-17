import java.util.Observable;
import java.util.Observer;

// Observable class
class WeatherData extends Observable {
    private float temperature, humidity, pressure;

    public void setMeasurements(float t, float h, float p) {
        this.temperature = t;
        this.humidity = h;
        this.pressure = p;
        setChanged();
        notifyObservers();
    }

    public float getTemperature() { return temperature; }
    public float getHumidity() { return humidity; }
    public float getPressure() { return pressure; }
}

// Observer class
class CurrentConditionsDisplay implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData wd = (WeatherData) o;
            System.out.println("Temp: " + wd.getTemperature() + "°C, Humidity: " + wd.getHumidity() + "%, Pressure: " + wd.getPressure() + " hPa");
        }
    }
}

// Client
public class s18 {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        weatherData.addObserver(new CurrentConditionsDisplay());

        // simulate measurements
        weatherData.setMeasurements(25.5f, 65f, 1013f);
        weatherData.setMeasurements(26.2f, 70f, 1012f);
        weatherData.setMeasurements(24.8f, 90f, 1009f);
    }
}


/*import java.util.Observable;
import java.util.Observer;

// Observable class
class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementsChanged() {
        setChanged(); // mark that state has changed
        notifyObservers(); // notify all observers
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() { return temperature; }
    public float getHumidity() { return humidity; }
    public float getPressure() { return pressure; }
}

// Observer class
class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;
    private Observable observable;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "°C and " + humidity + "% humidity");
    }
}

// Client code
public class WeatherStationDemo {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

        // Simulate new weather measurements
        weatherData.setMeasurements(25.5f, 65f, 1013f);
        weatherData.setMeasurements(26.2f, 70f, 1012f);
        weatherData.setMeasurements(24.8f, 90f, 1009f);
    }
}
*/
