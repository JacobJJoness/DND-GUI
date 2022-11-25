# "Dungeons & Dragons" Random Character Generator Project - Object Oriented Programming
This program is desgined for users to quickly generate
random D&D characters. The program uses a GUI interface
to allow the user to save characters to files for later reference. Additionally, the user can set conditions for the character to meet such as higher standards of stats for the character, name, etc.

## Folder Structure
The workspace contains the following folders, where:

- `src`: the folder to maintain code sources
- `lib`: the folder to maintain library dependencies
- `bin`: the folder to maintain generated compiled output files
- `gui`: the folder to maintain GUI elements
- `images`: the folder to maintain image elements
- `files`: the folder to maintain text file elements

## Class Structure
The workspace contains the following classes, where:

- `PlayerCharacter` class: main data structure and generator of random player character data
  - `Attribute` class: abstract class for `PlayerCharacter` stats
    - `Mental` class: child class of `Attribute` used for `PlayerCharacter` stats: intelligence, wisdom, and charisma
    - `Physical` class: child class of `Attribute` used for `PlayerCharacter` stats: strength, consitutuion, and dexterity 
  - `Number` class: interface class implemented in `Attribute` used for generating random numbers
- `FileHandler` class: handles loading and saving files for the character data
- `CharacterSheet` class: creates an ArrayList made up of `PlayerCharacter` objects and uses `FileHandler` to handle a list of `PlayerCharacters` as input and output files
- `GUI` class: serves as the GUI for the program
- `AlphaContainer` class: serves as the container class for `GUI`
