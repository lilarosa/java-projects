# Governance Analyzer (Java Project)

## 🇩🇪 Beschreibung

Dieses Projekt ist ein einfaches Analyse-Tool für Benutzerdaten.

Die Daten werden aus einer JSON-Datei gelesen und anschließend analysiert.
Ziel ist es, mögliche Sicherheitsrisiken zu erkennen.

### Funktionen

- Einlesen von JSON-Daten mit Jackson
- Umwandlung in Java-Objekte
- Analyse von Benutzerdaten
- Erkennung von Risikobenutzern (ohne MFA)
- Erkennung inaktiver Benutzer (mehr als 90 Tage)
- Statistische Auswertung nach Rollen

### Technologien

- Java
- Jackson (ObjectMapper)
- Maven

---

## 🇬🇧 Description

This project is a simple governance analysis tool.

It reads user data from a JSON file and analyzes potential security risks.

### Features

- Read JSON data using Jackson
- Convert JSON into Java objects
- Analyze user data
- Detect users without MFA (security risk)
- Detect inactive users (more than 90 days)
- Generate role statistics

### Technologies

- Java
- Jackson (ObjectMapper)
- Maven

---

## ▶️ How to run

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.lilarosa.App"

## 📂 Project Structure
=== All Users ===
Max Mustermann - MFA: false
Lila Rosa - MFA: true

=== Risk Users (MFA disabled) ===
⚠️ Risk User: 001 | Max Mustermann | ADMIN


