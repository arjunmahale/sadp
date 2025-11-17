// Observable class

class WeatherData {

    private float temperature, humidity, pressure;
    private CurrentConditionsDisplay observer; // single observer

    public void addObserver(CurrentConditionsDisplay o) {
        observer = o;
    }

    public void setMeasurements(float t, float h, float p) {
        this.temperature = t;
        this.humidity = h;
        this.pressure = p;
        notifyObserver();
    }

    private void notifyObserver() {
        if (observer != null) {
            observer.update(temperature, humidity, pressure);
        }
    }
}

// Observer class
class CurrentConditionsDisplay {

    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Temp: " + temperature + "°C, Humidity: " + humidity + "%, Pressure: " + pressure + " hPa");
    }
}

// Client
public class s3 {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay display = new CurrentConditionsDisplay();

        weatherData.addObserver(display);

        // Simulate measurements
        weatherData.setMeasurements(25.5f, 65f, 1013f);
        weatherData.setMeasurements(26.2f, 70f, 1012f);
        weatherData.setMeasurements(24.8f, 90f, 1009f);
    }
}
