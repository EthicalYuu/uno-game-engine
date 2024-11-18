# UNO Game Engine

> ⚠️ **Important:** This README provides a high-level overview of the project. For comprehensive details, including architecture, design decisions, and implementation, please refer to the [Project Documentation (PDF)](./UNO%20Game%20Engine.pdf).

## Overview
This project implements a flexible and extensible UNO game engine using Java and Object-Oriented Programming (OOP) principles. The engine allows developers to create their own variations of the popular card game, supporting customizable rules, card types, and game mechanics. The solution adheres to modern design practices, including SOLID principles, design patterns, and clean code guidelines.

## Table of Contents
1. [Introduction](#introduction)
2. [Object-Oriented Design](#object-oriented-design)
3. [Game Structure & Flow](#game-structure--flow)
4. [Key Classes](#key-classes)
5. [Design Patterns](#design-patterns)
6. [Clean Code Principles](#clean-code-principles)
7. [How to Run the Game](#how-to-run-the-game)
8. [License](#license)

## Introduction
The UNO game is a shedding card game where players aim to be the first to discard all of their cards. The engine created in this project provides an abstract base for creating customizable game variations. Developers can extend the `Game` class to add new rules, cards, and mechanics while leveraging the pre-existing system for dealing cards, validating actions, and managing gameplay.

## Object-Oriented Design
The UNO game engine follows Object-Oriented Programming principles to create a modular, extensible, and maintainable structure:

- **Encapsulation**: Each class is responsible for a specific task (e.g., `Player`, `Hand`, `Card`).
- **Abstraction**: Complex logic is abstracted through well-defined interfaces and methods, making it easier for developers to focus on game mechanics.
- **Reusability**: Classes are designed to be reused across different game variations.
- **Inheritance & Polymorphism**: Game rules, actions, and card behaviors can be easily extended and customized by inheriting from base classes.

## Game Structure & Flow
1. **Game Setup**: The game is instantiated using the `GameDriver` class, which calls the `play` method to initialize the game.
2. **Game Variations**: Developers can customize the game by overriding methods like `addCards()`, `assignCardToAction()`, and `addValidationRules()` to adjust the gameplay.
3. **Player Turns**: Players take turns drawing and playing cards. Each action is validated by pre- and post-check rules.
4. **End Condition**: The game continues until a post-rule triggers the end of the game.

### Game Flowchart
The game begins by creating a new game instance and calling the `play()` method. The main flow consists of setting up the deck, assigning actions to cards, validating actions, and managing player turns. The game loop iterates until the end condition is met.

## Key Classes
Here’s an overview of the key classes that form the backbone of the UNO game engine:

### `Game`
- Central class that manages the game’s overall flow and logic.
- Developers extend this class to create custom game variations.

### `Player`
- Represents each player in the game.
- Holds a player's name, score, and hand of cards.

### `Hand`
- Manages the collection of cards a player holds.
- Provides methods for drawing and playing cards.

### `DiscardPile`
- Tracks the cards that have been played by all players.
- The most recent card is always at the top of the pile.

## Design Patterns
The following design patterns were employed to ensure flexibility and extensibility:

- **Strategy Pattern**: Used to encapsulate different game rules and actions.
- **Chain of Responsibility**: Applied to manage the sequential execution of game rules during play.
- **Factory Pattern**: Used for creating cards and handling different card types dynamically.

## Clean Code Principles
The following principles were adhered to in the development of the UNO game engine:

- **Naming Conventions**: Clear and meaningful names for classes, variables, and methods.
- **Modular Functions**: Methods are small and focused on single tasks.
- **Comments**: The code includes comments explaining complex logic and design decisions.
- **Error Handling**: Proper error handling mechanisms are in place to ensure a smooth gameplay experience.

Documentation
-------------

For detailed documentation on the system's architecture, design, and implementation, please refer to the [Project Documentation (PDF)](./UNO%20Game%20Engine.pdf).
