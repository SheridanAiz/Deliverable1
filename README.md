# Game Rules

### Game Name: War
### Number of Players: 2
### Deck: Standard 52 card deck
### Objective: To win all the cards by having the highest ranking card in each round


## Setup

### Use a standard 52 card deck
### Shuffle the deck
### Deal half the deck to each player


## Gameplay

### Each player holds their deck face down without looking at the cards
### At the same time, each player draws the top card from their deck and places it face up in the center
### The player with the highest ranking card wins the round and takes both cards
   - Aces are high and 2s are low
### If the cards are of equal rank, a war is declared
    - Each player draws 3 cards from their deck and places them face down in the center
    - Each player then draws a fourth card and places it face up in the center
    - The player with the highest ranking card wins all the cards
    - If there is another tie, the process is repeated until a winner is determined


## Winning

### The game continues until one player has won all the cards
### The player with all the cards is the winner
### If a player runs out of cards, they lose the game


# Plan for Implementation

## Update Card Representation
  - Define a data structure to represent a standard 52 card deck
  - Implement a function to shuffle and deal the deck to the players

## Implement Player Class
    - Create a player class to represent each player
    - Include attributes such as player's deck of cards and a method to draw a card

## Game Initialization
    - Initialize two Player objects, representing the two players
    - Create a deck of cards and shuffle it
    - Deal half the deck to each player

## Gameplay Loop
    - Implement a loop to handle the main gameplay
    - Within each iteration of the loop
     - Each player simultaneously draws a card from their deck
     - Compare the ranks of the drawn cards to determine the winner of the round
     - Handle ties by declaring a war and drawing additional cards
     - Award the cards to the winner of the round

## Implement War Mechanism
    - Define a function / method to handle "war" scenarios when two cards of equal rank are drawn
    - Implement a mechanism to draw additional cards and determine the winner of the war
    - Award all the cards to the winner of the war

## Winning the Game
  - Check the winning condition after each round to see if a player has won all the cards or if a player has run out of cards
  - Declare the winner of the game

## User Interface
  - Kinda working on this 2/16/2024 and working alone might work on this if I have time

## Testing
  - Write test cases to ensure the game is functioning as expected
  - Test the game with different scenarios to ensure the game is working as expected

## Documentation
  - Write a README file to explain the game rules and the plan for implementation
  - Document the code to explain the implementation details and the flow of the game
  - Add comments to the code to explain the logic and the purpose of each function

### Project made by Muhammad Aiz Baloch
