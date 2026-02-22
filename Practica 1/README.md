# Practice 1 – Bus Company Trip Management
# Práctica 1 – Gestión de viajes de una empresa de autobuses

This folder contains the implementation of **Practice 1** for the subject *Programming and Data Structures*.

This practice consists of designing and implementing a complete console-based application to manage the trips of a bus company using a **multilist data structure**.

---

# 📌 Overview

The objective of this practice is to design, implement and use Abstract Data Types (TADs) to build a structured application capable of managing:

- Buses
- Trips associated with each bus
- Different listings and statistical queries

The entire information must be stored in a **single multilist structure**.

---

# 🧠 Functional Description

The application manages:

## 🚌 Bus Information

Each bus includes:
- License plate (unique)
- Year of purchase
- Number of seats

Constraints:
- No two buses can share the same license plate.
- A bus cannot perform two different trips at the same time.

---

## 🧳 Trip Information

Each trip includes:
- Trip code (unique integer)
- Origin city
- Destination city
- Departure time

Allowed cities:
- Madrid
- Segovia
- Barcelona
- Sevilla

Constraints:
- Trip code must be unique.
- Origin and destination must be different.
- Each registered trip is assumed to run daily.

---

# 📋 Application Structure

## Main Menu

```
1. Maintenance
2. Listings
0. Exit
```

---

## 🔧 Maintenance Menu

- Add bus
- Remove bus
- Modify bus
- Add trip
- Remove trip
- Modify trip

All operations must include:
- Proper validations
- Error handling
- Confirmation messages when necessary

---

## 📊 Listings Menu

The system provides different queries such as:

- Buses ordered by number of seats (ascending and descending)
- Complete trip listing
- Trips departing from a specific city
- Trips arriving at a specific city
- Buses with capacity greater than or equal to a given value
- Bus(es) performing the highest number of trips
- Total number of trips
- Total passengers between two cities (assuming full capacity)

⚠ Important:
For certain listings, **sorting algorithms, recursion, and auxiliary data structures are not allowed**, as specified in the practice statement.

---

# 🏗 Data Structure Design

The application must use:

- A single **multilist** as the main data structure
- Internally built using custom-designed TADs

The multilist:
- Must NOT be implemented as a TAD itself
- Must be constructed using TADs for:
    - Main list
    - Secondary lists

An attribute `size` is allowed inside TAD implementations.

---

# 🧩 TAD Design Requirements

Each TAD must include:

## Logical Level
- Definition
- Diagram
- Type of elements
- Type of organization (linear, hierarchical, etc.)
- Domain of elements
- Basic operations:
    - Name
    - Description
    - Input
    - Output
    - Preconditions
    - Postconditions

## Physical Level
- Interface design
- Full Java implementation
- Implementation of all basic operations studied in theory

## Application Level
- Use of the designed TADs to build the multilist system

---

# 📄 Deliverables

In addition to the full Java project, the following documentation must be provided:

- Cover page (title, students, group, professor, date)
- Complete logical specification of the TADs
- Description of the processes implemented for each menu option
- Full source code listing
- Execution screenshots
- PDF memory document

---

# 🎯 Learning Objectives

- Design and implementation of Abstract Data Types (TADs)
- Multilist data structure design
- Structured program development
- Data validation and integrity constraints
- Modular programming in Java

---

# 🛠 Technologies Used

- Java
- Custom TAD implementations
- Console-based interaction

---

This practice reinforces fundamental concepts in data structures and abstraction techniques, focusing on clean design and proper separation between logical and physical levels of implementation.