
/**
 * Projekt: Sensor-Daten-Monitoring (Simulation)
 * Beschreibung: Überwachung von Schwellenwerten für Temperatursensoren.
 */
public class SimpleSensorMonitor {
    public static void main(String[] args) {
        // Simulierte Daten eines Endrich-Temperatursensors
        double[] temperatures = {21.5, 23.8, 52.4, 48.9, 61.2, 19.5};
        double limit = 50.0; // Schwellenwert in °C

        System.out.println("--- Endrich Sensor Monitoring System aktiv ---");
        
        for (int i = 0; i < temperatures.length; i++) {
            double currentTemp = temperatures[i];
            
            if (currentTemp > limit) {
                // Hier könnte ein Pop-up oder eine Warnung ausgelöst werden
                System.out.printf("WARNUNG [Index %d]: Kritische Temperatur erreicht: %.1f°C!%n", i, currentTemp);
            } else {
                System.out.printf("Status OK [Index %d]: %.1f°C%n", i, currentTemp);
            }
        }
    }
}
