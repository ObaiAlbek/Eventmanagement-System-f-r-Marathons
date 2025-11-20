# 🏃‍♂️ Marathon Eventmanagement System  
Ein vollständiges Spring-Boot–Eventmanagement-System für Marathons.  
Das System ermöglicht die Verwaltung von Events, Anmeldungen, Materialien,  
Benachrichtigungen und Personal.

---

## 🚀 Features

### 🎯 Eventverwaltung
- Events anlegen  
- Genehmigungsstatus verwalten  
- Veröffentlichung  
- Vorbereitung  
- Start und Abschluss  
- Archivierung  

### 👥 Nutzer & Personal
- Nutzer-Registrierung  
- Personal: Eventmanager, Offizielle, Techniker  
- Vererbung über `Person`  

### 📝 Anmeldungen
- Anmeldung zu Events  
- Prüfung der maximalen Teilnehmeranzahl  
- Abmeldungen  
- Benachrichtigung bei Eventabsage  

### 📦 Materialverwaltung
- Materialien je Event  
- Menge & Stückpreis  
- Kostenkalkulation möglich  

---

# 🗂 Projektstruktur

marathon-system/
├── src/main/java/com/marathon
│ ├── MarathonSystemApplication.java
│ ├── model/
│ ├── repository/
│
├── src/test/java/com/marathon
├── src/main/resources
├── pom.xml

arduino
Code kopieren

---

# 📐 UML Klassendiagramm

```mermaid
classDiagram

    class Event {
        +Long id
        +String name
        +LocalDate datum
        +String standort
        +double budget
        +int minTeilnehmer
        +int maxTeilnehmer
        +LocalDate anmeldeschluss
        +EventStatus status
    }

    class Nutzer {
        +Long id
        +String vorname
        +String nachname
    }

    class Anmeldung {
        +Long id
        +LocalDate anmeldedatum
    }

    class Material {
        +Long id
        +String name
        +int menge
        +double stueckpreis
    }

    class Benachrichtigung {
        +Long id
        +String text
    }

    class Person {
        +Long id
        +String personalnummer
        +String vorname
        +String nachname
    }

    class Eventmanager
    class Offizieller
    class Veranstaltungstechniker

    %% Vererbung
    Person <|-- Eventmanager
    Person <|-- Offizieller
    Person <|-- Veranstaltungstechniker

    %% Beziehungen
    Nutzer "1" --> "*" Anmeldung : nimmt_teil
    Event "1" --> "*" Anmeldung : hat

    Event "1" --> "*" Material : benötigt
    Nutzer "1" --> "*" Benachrichtigung : erhält
