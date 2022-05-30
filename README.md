# Project Call of Ship: Water Wars
Kelvin Likollari 29 May 2022 - Programming Fundamentals 2 - BattleShip Project

Call of Ships is a clone of the original battleship game.

It is a game where the players try to sink the opponents ships.

The first player to sink all the opponents ships wins.

The game has 3 modes:
## Player vs Player (PvP)
## Player vs Ai/Computer (PvA)
## Ai/Computer vs Ai/Computer (AivAi)

The Game has also some additional functionalities such as:
    **- Randomly generate the ships
    - Randomly generate the board
    - Restart, Quit buttons.
    - Toggle Cheat Button that reveals/hides the ships
    - Place Ships button that places the ships automatically.
    - Winner announcement.
    - Multiple game modes for the people who are good at the game and would like** to compete against a skilled Computer.

## Team Members

* **`[[Kelvin Likollari]]`** (kelvin.likollari@usi.ch), likolk


## Project Structure

This project is both a Maven project and a BlueJ project.
You can open, compile, test, and run the code within BlueJ
by opening `src/package.bluej`.

You can use Maven to compile, test, and check the code
by running `mvn` in this top-level directory (see below).

You can run the code compiled by Maven from the terminal (see below).

The code is structured into three packages:

* `model` - all the model classes and their tests
* `tui` - text user interface (works in a terminal)
* `gui` - Swing-based graphical user interface (opens a window)

Note that the classes in the `model` package MUST NOT refer to any
classes in the `tui` or `gui` packages.

The classes in the `tui` package must not refer to any classes in the `gui` package.

The classes in the `gui` package must not refer to any classes in the `tui` package.

The classes in the `tui` and `gui` packages SHOULD refer to classes in the `model` package.

The classes in the `model` package need to come with unit tests.
(The classes in the `tui` and `gui` packages do not need to be covered with tests.)

## How build using Maven

In this top-level directory:

```bash
mvn compile
```

## How to run the application

To run the application from outside BlueJ, first build it with Maven.
This generates the compiled classes in the directory `target/classes`.

### Running the TUI

To run this application, with the TUI, **run the run() method located in the Main class of the TUI package.**

DESCRIPTION OF COMMAND LINE ARGUMENTS

### Running the GUI

To run this application, with the GUI, **run the `main`() method located in the JWelcome class of the GUI package.**


### This project also comes with:
- A Set of Unit Tests for each of the Model classes
- Copy-Paste Detector (CPD)
- Code-Smells Detector
- PMD Error Detector
- Coverage for all the tests


### How run the JUnit tests with Maven

```bash
mvn test
```

### How to run Checkstyle with Maven

```bash
mvn compile
mvn checkstyle:check
```

### How to run PMD with Maven

```bash
mvn compile
mvn pmd:check
```

### How to run PMD's CPD with Maven

```bash
mvn compile
mvn pmd:cpd-check
```

### How to determine test coverage with Maven

```bash
mvn site
```

Then open `target/site/index.html` and find the JaCoCo report.

### What does the Textual User Interface (TUI) look like?

<img width="1336" alt="tui1" src="https://user-images.githubusercontent.com/55785978/170889844-24242d60-5106-4bad-816c-071653b78a4d.png">


<img width="1680" alt="tui2" src="https://user-images.githubusercontent.com/55785978/170889841-c9b14181-a810-4c1a-b38c-a05f954b23a7.png">


<img width="1680" alt="tui3" src="https://user-images.githubusercontent.com/55785978/170889835-3c06770e-9881-4db3-a419-615c7a57c10c.png">
## What does the Graphical User Interface (GUI) look like?

<img width="1680" alt="Screenshot 2022-05-29 at 21 40 30" src="https://user-images.githubusercontent.com/55785978/170889864-f3da45ac-bf6b-4b3e-8a16-2123b8ed8428.png">


<img width="1680" alt="Screenshot 2022-05-29 at 21 40 40" src="https://user-images.githubusercontent.com/55785978/170889874-23f956c9-fc2d-48e1-bc40-d519ac93fbf9.png">


<img width="1680" alt="Screenshot 2022-05-29 at 21 40 48" src="https://user-images.githubusercontent.com/55785978/170889883-e711e87c-1878-4bef-b76d-247b58c83ee7.png">


### What do the class diagrams look like?

#### For the Model:

<img width="1680" alt="Screenshot 2022-05-29 at 21 39 35" src="https://user-images.githubusercontent.com/55785978/170890013-fbc42d60-ef2d-414f-84c7-d20de1a43dad.png">
#### For the TUI

<img width="1680" alt="Screenshot 2022-05-29 at 21 39 53" src="https://user-images.githubusercontent.com/55785978/170890019-1ac3a9e2-9142-4c84-a5e4-584e1d03a268.png">

#### For the GUI


<img width="1680" alt="Screenshot 2022-05-29 at 21 40 09" src="https://user-images.githubusercontent.com/55785978/170890031-24fd3e0f-720b-4e02-94ca-b90e56b8b60d.png">

#### **Have Fun Playing Battleship ( ͡~ ͜ʖ ͡°)**

## Me after developing this Project:
![mern](https://user-images.githubusercontent.com/55785978/170890166-ef4794c4-9884-4b79-aac5-94ce458b23d7.png)
