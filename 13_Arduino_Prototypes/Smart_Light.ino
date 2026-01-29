/**
 * Projekt: Intelligente Lichtsteuerung
 * Beschreibung: Einlesen eines Lichtsensors (LDR) zur Steuerung einer LED via PWM.
 */
int sensorPin = A0; // Lichtsensor
int ledPin = 9;     // LED an PWM-Pin

void setup() {
  pinMode(ledPin, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  int sensorValue = analogRead(sensorPin);
  // Mapping: Sensor-Wert (0-1023) auf PWM-Helligkeit (0-255) umrechnen
  int brightness = map(sensorValue, 0, 1023, 0, 255);
  
  analogWrite(ledPin, brightness);
  
  Serial.print("Sensorwert: ");
  Serial.println(sensorValue);
  delay(100);
}
