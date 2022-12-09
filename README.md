# Mariogatchi

Mariogatchi is a game that's a cross between Tamagotchi digital pets and Pokemon. As a player, you can find Mariogatchi creatures in the wild and catch them. Once you have a Mariogatchi, you are tasked with keeping them fed, clean, energetic, and happy. These objectives are completed by using items to take care of your Mariogatchi. Players must also be mindful that certain actions can only be taken when they are in certain environments (home, park, forest). Advanced players can go online to interact with other players and set up playdates between different Mariogatchi.


## Project structure

This project is written in Java and utilizes clean architecture. Source code can be found in the `src/main/java/mariogatchi` folder. 

## Running the demo

- When you launch the program you will be able to enter either the signup or login screen by clicking the respective buttons
- When in the signup screen you can enter in a username and a password, if you entered in a strong enough password you will get logged into the home screen which is for now a work in progress
- When in the login screen you can enter a username and password. If you entered a username and the correct password for that username you will be logged in, otherwise you will be given a message of what went wrong

## Design patterns

- Iterator:  GeneratatedMariogatchis
- Abstract Factory: RemoveMariogatchiFactory
- Factory Method: KillMariogatchiFactory, TransferMariogatchiFactory
- Dependency Injection: UseItemRequestModel


![image](https://cdn.discordapp.com/attachments/1023992808857669734/1032519005975613451/DALLE_2022-10-20_01.00.30_-_Mario_tamagotchi.png)
