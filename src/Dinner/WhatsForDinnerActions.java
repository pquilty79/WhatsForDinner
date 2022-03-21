package Dinner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

import static Dinner.WhatsForDinnerApp.genreMenuNavigation;

public class WhatsForDinnerActions {
    public static void getRandomRestaurant() throws IOException {
        String directory = "src/";
        String filename = "restaurants.txt";
        Path filepath = Paths.get(directory, filename);
        List<String> restaurantList = Files.readAllLines(filepath);
        List<String> restaurantNameList = new ArrayList<>();
        for (String restaurant : restaurantList) {
            String[] splitStr = restaurant.split(",");
            String restaurantNames = splitStr[0];
            restaurantNameList.add(restaurantNames);
        }
        int random = (int) (restaurantNameList.toArray().length * Math.random());
        System.out.println(restaurantNameList.get(random));
    }
    public static void getRandomRestaurantByGenre(String genre) throws IOException {
        String directory = "src/";
        String filename = "restaurants.txt";
        Path filepath = Paths.get(directory, filename);
        List<String> restaurantList = Files.readAllLines(filepath);
        List<String> restaurantNameList = new ArrayList<>();
        for (String s : restaurantList) {
            if (s.contains(genre)) {
                String[] splitStr = s.split(",");
                String restaurantNames = splitStr[0];
                restaurantNameList.add(restaurantNames);
            }
        }
        int random = (int) (restaurantNameList.toArray().length * Math.random());
        System.out.println(restaurantNameList.get(random));
    }




    public static void addRestaurant(String restaurant) {
        try {
            String directory = "src/";
            String filename = "restaurants.txt";
            Path filepath = Paths.get(directory, filename);
            List<String> restaurantList = List.of(restaurant);
            Files.write(filepath, restaurantList, StandardOpenOption.APPEND);
            System.out.println("Restaurant added");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error adding restaurant");
        }
    }
    public static void displayAllRestaurants() {
        try {
            String directory = "src/";
            String filename = "restaurants.txt";
            Path filepath = Paths.get(directory, filename);
            List<String> restaurantList = Files.readAllLines(filepath);
            Collections.sort(restaurantList);
            for (int i = 0; i < restaurantList.size(); i += 1) {
                System.out.println(String.format("%-3s", i + 1) + restaurantList.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void viewGenres() throws IOException {
        System.out.println("Here are the genres available:\n");
        String directory = "src/";
        String filename = "restaurants.txt";
        Path filepath = Paths.get(directory, filename);
        List<String> restaurantList = Files.readAllLines(filepath);
        List<String> restaurantGenreList = new ArrayList<>();
        for (String restaurant : restaurantList) {
            String[] splitStr = restaurant.split(",");
            String genres = splitStr[1];
            restaurantGenreList.add(genres);
        }
        List<String> genreList = restaurantGenreList.stream()
                .distinct()
                .collect(Collectors.toList());
        for(String genre : genreList) {
            System.out.println(genre);
        }
        genreMenuNavigation();
    }



    public static void getRestaurantInfoFromUser() {
        Input input = new Input();
        System.out.print("\nEnter the name of the restaurant\n> ");
        try {
            String restaurantName = input.getString();
            restaurantName = capitalize(restaurantName);
            System.out.print("\nEnter the genres of the contact\n> ");
            String genre = input.getString();
            String restaurant = restaurantName + ", " + genre;
            addRestaurant(restaurant);
        } catch (IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

        public static String capitalize (String str) throws IOException, InterruptedException, URISyntaxException {
            if (str == null || str.isEmpty()) {
                System.out.println("Restaurant name required");
                getRestaurantInfoFromUser();
            }
            assert str != null;
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }

        public static void anythingBut (String notThis) throws IOException {
            String directory = "src/";
            String filename = "restaurants.txt";
            Path filepath = Paths.get(directory, filename);
            List<String> restaurantList = Files.readAllLines(filepath);
            List<String> restaurantNameList = new ArrayList<>();
            for (String s : restaurantList) {
                if (!s.contains(notThis)) {
                    String[] splitStr = s.split(",");
                    String restaurantNames = splitStr[0];
                    restaurantNameList.add(restaurantNames);
                }
            }
            int random = (int) (restaurantNameList.toArray().length * Math.random());
            System.out.println(restaurantNameList.get(random));
        }



}
