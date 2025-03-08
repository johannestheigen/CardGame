# CardGame Application

By **Johannes Nupen Theigen**

## Project Description
This project is a simple card game application made as a mandatory
assignment for the Programming 2 course at the Norwegian University of Science and Technology (NTNU).

## Project Structure

```aiignore
C:.
|   .gitignore
|   pom.xml
|   README.md
|
+---.idea
|   |   .gitignore
|   |   CardGame.iml
|   |   checkstyle-idea.xml
|   |   compiler.xml
|   |   encodings.xml
|   |   jarRepositories.xml
|   |   misc.xml
|   |   uiDesigner.xml
|   |   vcs.xml
|   |   workspace.xml
|   |
|   \---checkstyleidea-libs
|           readme.txt
|
+---src
|   +---main
|   |   +---java
|   |   |   |   Main.java
|   |   |   |
|   |   |   +---controller
|   |   |   |       CardGameController.java
|   |   |   |
|   |   |   +---model
|   |   |   |       CardFaceManager.java
|   |   |   |       CardManager.java
|   |   |   |       DeckHand.java
|   |   |   |       DeckOfCards.java
|   |   |   |       PlayingCard.java
|   |   |   |
|   |   |   \---view
|   |   |           CardGameView.java
|   |   |
|   |   \---resources
|   |       |   application-background.jpg
|   |       |
|   |       \---cards
|   |
|   \---test
|       \---java
|           \---model
|                   DeckHandTest.java
|                   DeckOfCardsTest.java
|                   PlayingCardTest.java
|
\---target
+---classes
|   |   application-background.jpg
|   |   Main.class
|   |
|   +---cards
|   |
|   +---controller
|   |       CardGameController.class
|   |
|   +---model
|   |       CardFaceManager.class
|   |       CardManager.class
|   |       DeckHand.class
|   |       DeckOfCards.class
|   |       PlayingCard.class
|   |
|   \---view
|           CardGameView.class
|
\---generated-sources
\---annotations
```

## How to run the project

## How to run the tests
The unit tests are managed with Apache Maven.
JUnit5 dependencies are specified in the pom.xml file.

To run the tests:

In IntelliJ, use the Maven plugin and select the test phase in the Build Lifecycle.
Alternatively, `run mvn` test in the terminal
