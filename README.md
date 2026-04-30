# Sprint 3.2: Design Patterns I - Java

This repository contains the implementation of three different levels of software challenges focused on applying classic **GoF (Gang of Four) Design Patterns** in Java.

### 1️⃣ Level One: Undo Management System
**Patterns: Singleton & Command**

A system designed to track user actions and provide "Undo" functionality.

*   **Singleton Pattern:** The `Undo` class ensures that only one instance of the command history exists throughout the application's lifecycle.
*   **Command Pattern:** Actions are encapsulated as `Command` objects, containing a unique ID and a description.
*   **Key Features:**
    *   Add commands to a history list.
    *   Remove the last action (Undo).
    *   Display the full history with auto-incrementing indices.
    *   Reset history and counters.

---

### 2️⃣ Level Two: International Address & Phone Directory
**Pattern: Abstract Factory**

A system that handles international contact information (Addresses and Phone Numbers) for multiple countries. It ensures that each object created is self-validating and knows how to format itself according to local standards.

*   **Abstract Factory Pattern:** Implements the `ContactFactory` interface to instantiate families of related objects (`Address` and `Phone`) without specifying their concrete classes. Each country has its own factory (e.g., `FranceContactFactory`) that orchestrates the creation of localized products.
*   **Supported Countries:** Spain, France, UK, and USA.
*   **Core Components:**
    *   **Abstract Products:** The `Address` and `Phone` abstract classes define the template for all contact data, including mandatory fields and common validation logic.
    *   **Encapsulated Logic:** Instead of external services, the concrete products (like `FranceAddress`) handle their own **Validation** (`ensureIsValid`) and **Formatting** (`formatAddress`) logic internally.
    *   **Data Models:** Uses auxiliary classes like `HousingDetails` to manage optional address information (floor, door, etc.) in a clean, reusable way.
    *   **Robust Error Handling:** Uses custom exceptions (`InvalidAddressException`, `InvalidPhoneException`) to ensure that no object can be instantiated with invalid data.

---


### 3️⃣ Level Three: Universal Report Generator
**Pattern: Strategy**

A flexible engine to generate reports in multiple file formats using interchangeable algorithms.

*   **Strategy Pattern:** The `ReportStrategy` interface defines the contract for report generation. Different strategies are implemented using **Java Lambdas** and static factory methods for a clean, modern approach.
*   **Available Formats:**
    *   **Web/Data:** `HTML`, `JSON`, `XML`, `CSV`.
    *   **Office/Documents:** `PDF`, `MS Word (.docx)`, `MS Excel (.xlsx)`.
*   **ReportService:** Acts as the context that executes the selected strategy dynamically at runtime.

---

## 🚀 Technologies Used

*   **Java 21**
*   **Stream API:** For efficient data processing and string collection.
*   **Functional Programming:** Extensive use of Lambdas and Functional Interfaces.
*   **OOP Principles:** Strong emphasis on Encapsulation and Polymorphism.

---

## 🛠️ How to Use

### Level 1: Undo Example
```java
Undo history = Undo.getUndo();
history.addCommand("git add .");
history.addCommand("git commit -m 'Add patterns'");
System.out.println(history.showHistory());
history.undoCommand(); // Removes the last commit
```
### Level 2: Factory Example
```java
FormatFactory factory = new FranceFormatFactory();
AddressFormatter addrFormatter = factory.createAddressFormatter();
String result = addrFormatter.formatAddress(myFrenchAddressObject);
```
### Level 3: Strategy Example
```java
Report myData = new Report("Annual Results", "Report_2023");
ReportService service = new ReportService(ReportStrategy.jsonReport());
Report output = service.generateReport(myData);
// Output will have .json extension and JSON-structured content
```
