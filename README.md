# University Domain Model Java

This project is a console-based Java application created as a mini-project for object-oriented modeling practice.

## Project purpose

The goal of this project is to demonstrate the implementation of selected business concepts from a conceptual model, including:

- class extent
- extent persistence
- composite attribute
- optional attribute
- repeating attribute
- class attribute
- derived attribute
- class methods
- method overriding
- method overloading

The project can also serve as a foundation for a larger final project that may later be extended with additional features such as a graphical user interface.

## Business domain

The application models a simple university environment with the following main entities:

- `Person`
- `Student`
- `Lecturer`
- `Contact`
- `WorkExperience`
- `AcademicEducation`
- `AcademicDegree`

## Implemented concepts

### Student
The `Student` class includes:
- optional scholarship
- repeating list of individual course path subjects
- repeating map of grades
- derived average grade
- derived monthly and yearly tuition fee
- extent and extent persistence

### Lecturer
The `Lecturer` class includes:
- academic degree
- repeating work experience
- repeating academic education
- validation of teaching hours
- validation of hourly rate
- derived salary
- extent and extent persistence

### Person
The `Person` class includes:
- composite attribute `Contact`
- base method `printData()` overridden in subclasses

## Features demonstrated in `main()`

The `Main` class demonstrates:
- creating sample students and lecturers
- assigning grades and individual course subjects
- calculating average grades
- calculating monthly and yearly student fees
- calculating lecturer salary
- displaying extents
- saving extents to files
- clearing extents
- loading extents from files
- validation error handling

## Technologies
- Java
- Object serialization
- Console application

## File persistence
The project uses Java serialization to save and load class extents:
- `student_extent.ser`
- `lecturer_extent.ser`

## Notes
This project focuses on business modeling concepts rather than technical utility methods such as getters, setters, or object counting alone.

## Author
Student mini-project created for object-oriented programming/modeling coursework.