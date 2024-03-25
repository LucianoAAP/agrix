# The project

This is a slightly modified version of a back-end project I had to develop during a java course of the "Trybe" web development school. It is an API that allows the management and monitoring of farms and their crops.

# Features

- [x] login with spring security
- [x] user login endpoint: "/auth/login"
- [x] route for user control: "/persons"
- [x] route for farm control: "/farms"
- [x] route for crop control: "/crops"
- [x] route for fertilizer control: "/fertilizers"
- [x] unit tests
- [x] dockerfile

# Getting started

## Prerequisites

This application requires "Java", "Maven" and "MySQL" installed

## Database

Just create a database named "agrix" in mysql and the tables will be created when the application starts.

Table diagram:

![Table model](tables.png)

## Installation

1. First, clone the repository:
- `git clone git@github.com:LucianoAAP/agrix.git`
2. Then, enter the repository:
- `cd agrix`
3. Finally, install dependencies using the following code or your preferred IDE:
- `mvn install -DskipTests`

## Starting the application

Just run the main class AggrixApplication.java using your preferred IDE

# Testing the application

The application has unit tests. Just use an IDE to run the files in the package "com.betrybe.agrix.solution" as JUnit tests.

# Next steps

- Unit tests that cover all endpoints

# Contact

## Luciano Almeida

- Linkedin: https://www.linkedin.com/in/lucianoaap/
- Github: https://www.linkedin.com/in/lucianoaap/
- Email: lucianoalmeidaap@gmail.com