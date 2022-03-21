package Dinner;

import java.io.IOException;

import static Dinner.WhatsForDinnerActions.*;

public class WhatsForDinnerApp {
    public static void main(String[] args) throws IOException {
        dinnerMenuNavigation();
    }

    public static void dinnerMenuNavigation() throws IOException {
        Input input = new Input();
        int answer = mainMenuChoices();
        while (answer != 6) {
            if (answer == 1) {
                getRandomRestaurant();
                if (input.yesNo("\nWould you like to do anything else? Y/N\n> ")) {
                    answer = mainMenuChoices();
                } else {
                    answer = 6;
                }
            } else if (answer == 2) {
                genreMenuNavigation();
                if (input.yesNo("\nWould you like to do anything else? Y/N\n> ")) {
                    answer = mainMenuChoices();
                } else {
                    answer = 6;
                }
            }
            else if (answer == 3) {
                getRestaurantInfoFromUser();
                if (input.yesNo("\nWould you like to do anything else? Y/N\n> ")) {
                    answer = mainMenuChoices();
                } else {
                    answer = 6;
                }
            }
            else if (answer == 4) {
                displayAllRestaurants();
                if (input.yesNo("\nWould you like to do anything else? Y/N\n> ")) {
                    answer = mainMenuChoices();
                } else {
                    answer = 6;
                }
            }
            else if (answer == 5) {
                System.out.println("What do you absolutely not want to eat?");
                String notThis = input.getString();
                anythingBut(notThis);
                if (input.yesNo("\nWould you like to do anything else? Y/N\n> ")) {
                    answer = mainMenuChoices();
                } else {
                    answer = 6;
                }
            }
        }
    }



    public static int mainMenuChoices() {
        Input input = new Input();
        System.out.println("What's for Dinner?\n");
        System.out.print("1. Get random restaurant.\n" +
                "2. Choose a genre of food.\n" +
                "3. Add a restaurant.\n" +
                "4. View all restaurants.\n" +
                "5. Anything but this: \n" +
                "6. Exit.\n" +
                "Enter an option number (ex: 1, 2...):\n> ");
        return input.getInt(1, 6);
    }

    public static int genreMenuChoices() {
        Input input = new Input();
        System.out.println("What's for Dinner: I have a basic idea\n");
        System.out.print("\n1. View all food genres.\n" +
                "2. Get a random restaurants by genre.\n" +
                "3. Return to main menu.\n" +
                "Enter an option number (ex: 1, 2...):\n> ");
        return input.getInt(1, 3);
    }

    public static void genreMenuNavigation() throws IOException {
        Input input = new Input();
        int newAnswer = genreMenuChoices();
        while (newAnswer != 3) {
            if (newAnswer == 1) {
                viewGenres();
                if (input.yesNo("\nWould you like to do anything else? Y/N\n> ")) {
                    newAnswer = mainMenuChoices();
                } else {
                    newAnswer = 3;
                }
            } else if (newAnswer == 2) {
                System.out.print("\nEnter your genre of choice:\n>");
                String genre = input.getString();
                getRandomRestaurantByGenre(genre);
                if (input.yesNo("\nWould you like to do anything else? Y/N\n> ")) {
                    newAnswer = mainMenuChoices();
                } else {
                    newAnswer = 3;
                }
            }
            }
        dinnerMenuNavigation();
        }
    }



