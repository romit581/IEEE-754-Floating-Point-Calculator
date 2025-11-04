# 🧮 IEEE 754 Floating Point Calculator

### 🔍 Overview

This project is an **IEEE 754 Floating Point Calculator** that demonstrates the **representation and conversion** of floating-point numbers according to the **IEEE 754 standard** for both **single precision (32-bit)** and **double precision (64-bit)** formats.

The project combines a **Java backend** for accurate computation and validation with a **HTML/JavaScript frontend** for a visually interactive experience.

---

### ⚙️ Tech Stack

* **Frontend:** HTML, CSS, JavaScript
* **Backend:** Java (Spring Boot / Core Java)
* **Tools Used:**

  * DataView API for binary conversion in JS
  * Java bit manipulation using `Float.floatToIntBits()` and `Double.doubleToLongBits()`
  * HTML5 and CSS3 for responsive design

---

### 💡 Features

✅ Convert decimal numbers into **IEEE 754 binary representation** (32-bit & 64-bit)
✅ Display **Sign bit**, **Exponent**, and **Mantissa** clearly
✅ View **hexadecimal representation** of the binary value
✅ Smooth and modern animated user interface
✅ Java backend for accurate floating-point computation
✅ Web-based frontend that visualizes bit-level structure

---

### 🧠 Learning Objectives

* Understand **floating-point representation** in computers
* Explore **bitwise operations** in Java
* Learn how **frontend and backend** can communicate for numeric computation
* Reinforce understanding of **precision, bias, and exponent normalization**

---

### 📂 Project Structure

```
IEEE754Calculator/
│
├── src/
│   ├── IEEE754Application.java       # Entry point of the application
│   ├── IEEE754Controller.java        # Handles input/output between frontend and backend
│   ├── IEEE754Calculator.java        # Core logic for IEEE 754 conversions
│
├── index.html                        # Frontend interface (HTML/CSS/JS)
├── Main.class                        # Compiled output file
└── README.md                         # Project description (this file)
```

---

### 🚀 How to Run

#### 🧩 Option 1: Using Java

1. Compile and run the backend:

   ```bash
   javac IEEE754Application.java
   java IEEE754Application
   ```
2. Open `index.html` in your browser.

#### 🌐 Option 2: Using an IDE

* Import the project into **VS Code**, **IntelliJ**, or **Eclipse**.
* Run `IEEE754Application.java` (main class).
* Then open `index.html` and interact with the calculator.

---

### 📸 Preview

```
<img width="1919" height="977" alt="Screenshot 2025-11-04 225902" src="https://github.com/user-attachments/assets/9ecdfad4-37ec-4494-9a53-581c537e9414" />

```

---

### 👨‍💻 Contributors

* **Romit Sardar (RA2411003010091)**
* **Divyansh Thakur (RA2411003010074)**
* **Saad Ahmad (RA2411003010112)**

---

### 🧾 References

* IEEE Standard for Floating-Point Arithmetic (IEEE 754-2008)
* [Floating Point Converter Tool](https://www.h-schmidt.net/FloatConverter/IEEE754.html)
* Java API Docs for [`Float.floatToIntBits`](https://docs.oracle.com/javase/8/docs/api/java/lang/Float.html#floatToIntBits-f-)

---
