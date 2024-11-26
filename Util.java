package com.example.main;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Util {

    private static ArrayList<Pokemon> sortedPokedexData;

    public static ArrayList<Pokemon> alphabeticalNameOrder(ArrayList<Pokemon> arr) {
        sortedPokedexData = new ArrayList<>(arr.size());
        arr.sort(new AlphabeticalNameSort());
        sortedPokedexData.addAll(arr);
        return sortedPokedexData;
    }
    private static class AlphabeticalNameSort implements Comparator<Pokemon> {

        @Override
        public int compare(Pokemon p1, Pokemon p2) {
            try {
                return p1.getName().compareTo(p2.getName());
            } catch (NumberFormatException e) {
                System.out.println("Warning: Encountered invalid num property during sorting: " + e.getMessage());
                return 0;
            }

        }

    }
    public static ArrayList<Pokemon> reverseAlphabeticalNameOrder(ArrayList<Pokemon> arr) {
        sortedPokedexData = new ArrayList<>(arr.size());
        arr.sort(new ReverseAlphabeticalNameSort());
        sortedPokedexData.addAll(arr);
        return sortedPokedexData;
    }
    private static class ReverseAlphabeticalNameSort implements Comparator<Pokemon> {

        @Override
        public int compare(Pokemon p1, Pokemon p2) {
            try {
                return p2.getName().compareTo(p1.getName());
            } catch (NumberFormatException e) {
                System.out.println("Warning: Encountered invalid num property during sorting: " + e.getMessage());
                return 0;
            }

        }

    }
    public static ArrayList<Pokemon> regularNumOrder(ArrayList<Pokemon> arr) {
        sortedPokedexData = new ArrayList<>(arr.size());
        arr.sort(new RegularNumSort());
        sortedPokedexData.addAll(arr);
        return sortedPokedexData;
    }
    private static class RegularNumSort implements Comparator<Pokemon> {

        @Override
        public int compare(Pokemon p1, Pokemon p2) {
            String num1Str = p1.getNum();
            String num2Str = p2.getNum();
            try {
                long num1 = Long.parseLong(num1Str);
                long num2 = Long.parseLong(num2Str);
                return (int) (num1 - num2);
            } catch (NumberFormatException e) {
                System.out.println("Warning: Encountered invalid num property during sorting: " + e.getMessage());
                return 0;
            }

        }

    }
    public static ArrayList<Pokemon> reverseNumOrder(ArrayList<Pokemon> arr) {
        sortedPokedexData = new ArrayList<>(arr.size());
        arr.sort(new ReverseNumSort());
        sortedPokedexData.addAll(arr);
        return sortedPokedexData;
    }
    private static class ReverseNumSort implements Comparator<Pokemon> {

        @Override
        public int compare(Pokemon p1, Pokemon p2) {
            String num1Str = p1.getNum();
            String num2Str = p2.getNum();
            try {
                long num1 = Long.parseLong(num1Str);
                long num2 = Long.parseLong(num2Str);
                return (int) (num2 - num1);
            } catch (NumberFormatException e) {
                System.out.println("Warning: Encountered invalid num property during sorting: " + e.getMessage());
                return 0;
            }

        }

    }

    public static ArrayList<Pokemon> displayTypePokemon(String type, ArrayList<Pokemon> arr) throws FileNotFoundException {
        sortedPokedexData = new ArrayList<>(arr.size());
        getPokedexData(arr);
        if (Objects.equals(type, "all")) {
            return arr;
        } else {
            for (Pokemon p : arr) {
                if (Objects.equals(type, "normal") && (Objects.equals(p.getType1(), "Normal") || Objects.equals(p.getType2(), "Normal"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "fighting") && (Objects.equals(p.getType1(), "Fighting") || Objects.equals(p.getType2(), "Fighting"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "fairy") && (Objects.equals(p.getType1(), "Fairy") || Objects.equals(p.getType2(), "Fairy"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "dark") && (Objects.equals(p.getType1(), "Dark") || Objects.equals(p.getType2(), "Dark"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "dragon") && (Objects.equals(p.getType1(), "Dragon") || Objects.equals(p.getType2(), "Dragon"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "ice") && (Objects.equals(p.getType1(), "Ice") || Objects.equals(p.getType2(), "Ice"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "psychic") && (Objects.equals(p.getType1(), "Psychic") || Objects.equals(p.getType2(), "Psychic"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "electric") && (Objects.equals(p.getType1(), "Electric") || Objects.equals(p.getType2(), "Electric"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "grass") && (Objects.equals(p.getType1(), "Grass") || Objects.equals(p.getType2(), "Grass"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "water") && (Objects.equals(p.getType1(), "Water") || Objects.equals(p.getType2(), "Water"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "fire") && (Objects.equals(p.getType1(), "Fire") || Objects.equals(p.getType2(), "Fire"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "steel") && (Objects.equals(p.getType1(), "Steel") || Objects.equals(p.getType2(), "Steel"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "ghost") && (Objects.equals(p.getType1(), "Ghost") || Objects.equals(p.getType2(), "Ghost"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "bug") && (Objects.equals(p.getType1(), "Bug") || Objects.equals(p.getType2(), "Bug"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "rock") && (Objects.equals(p.getType1(), "Rock") || Objects.equals(p.getType2(), "Rock"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "ground") && (Objects.equals(p.getType1(), "Ground") || Objects.equals(p.getType2(), "Ground"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "poison") && (Objects.equals(p.getType1(), "Poison") || Objects.equals(p.getType2(), "Poison"))) {
                    sortedPokedexData.add(p);
                } else if (Objects.equals(type, "flying") && (Objects.equals(p.getType1(), "Flying") || Objects.equals(p.getType2(), "Flying"))) {
                    sortedPokedexData.add(p);
                }
            }
        }
        return sortedPokedexData;
    }

    public static VBox displayList(VBox vbox, ArrayList<Pokemon> arr) {
        vbox.getChildren().clear();
        for (Pokemon currPoke : arr) {
            Color type1Color = switch (currPoke.getType1().toLowerCase()) {
                case "grass" -> Color.LIGHTGREEN;
                case "fire" -> Color.ORANGE;
                case "water" -> Color.AQUAMARINE;
                case "bug" -> Color.YELLOWGREEN;
                case "normal" -> Color.BEIGE;
                case "flying" -> Color.LIGHTBLUE;
                case "poison" -> Color.MAGENTA;
                case "electric" -> Color.YELLOW;
                case "ground" -> Color.TAN;
                case "psychic" -> Color.HOTPINK;
                case "rock" -> Color.SANDYBROWN;
                case "ice" -> Color.WHITE;
                case "fighting" -> Color.RED;
                case "ghost" -> Color.MEDIUMPURPLE;
                case "dark" -> Color.SLATEGRAY;
                case "steel" -> Color.LIGHTGREY;
                case "fairy" -> Color.LIGHTPINK;
                case "dragon" -> Color.BLUEVIOLET;
                default -> Color.GRAY; // Default color for unknown types
            };
            Color type2Color = switch (currPoke.getType2().toLowerCase()) {
                case "grass" -> Color.LIGHTGREEN;
                case "fire" -> Color.ORANGE;
                case "water" -> Color.AQUAMARINE;
                case "bug" -> Color.YELLOWGREEN;
                case "normal" -> Color.BEIGE;
                case "flying" -> Color.LIGHTBLUE;
                case "poison" -> Color.MAGENTA;
                case "electric" -> Color.YELLOW;
                case "ground" -> Color.TAN;
                case "psychic" -> Color.HOTPINK;
                case "rock" -> Color.SANDYBROWN;
                case "ice" -> Color.WHITE;
                case "fighting" -> Color.RED;
                case "ghost" -> Color.MEDIUMPURPLE;
                case "dark" -> Color.SLATEGRAY;
                case "steel" -> Color.LIGHTGREY;
                case "fairy" -> Color.LIGHTPINK;
                case "dragon" -> Color.BLUEVIOLET;
                default -> Color.GRAY; // Default color for unknown types
            };
            String type1StrColor = currPoke.getType1();
            String type2StrColor = currPoke.getType2();
            HBox pokeContainer = new HBox();

            Label pokeNum = new Label("Num.:");
            Label num = new Label(currPoke.getNum());
            num.setFont(Font.font(null, FontWeight.BOLD, 12));

            Label pokeName = new Label("Name:");
            Label name = new Label(currPoke.getName());
            name.setFont(Font.font(null, FontWeight.BOLD, 12));

            Label colorType1 = new Label(type1StrColor);
            colorType1.setTextFill(type1Color);
            Background background1 = new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY));
            colorType1.setBackground(background1);
            colorType1.setPadding(new Insets(2.5, 5, 2.5, 5));
            Label pokeType1 = new Label("Primary Type:");

            Label colorType2 = new Label(type2StrColor);
            colorType2.setTextFill(type2Color);
            Background background2 = new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY));
            colorType2.setBackground(background2);
            colorType2.setPadding(new Insets(2.5, 5, 2.5, 5));
            Label pokeType2 = new Label("Secondary Type:");

            pokeContainer.getChildren().addAll(pokeNum, num, pokeName, name, pokeType1, colorType1, pokeType2, colorType2);
            pokeContainer.setSpacing(10);
            vbox.getChildren().add(pokeContainer);
        }

        return vbox;
    }

    public static void getPokedexData(ArrayList<Pokemon> arr) throws FileNotFoundException {
        arr.clear();
        File filename = new File("C:/Users/17602/Documents/Important documents/IVC/CS231/Final Project/main/src/main/java/com/example/main/pokedex.csv");
        Scanner scan = new Scanner(filename);
        scan.nextLine();
        int[] desiredColumns = {0, 1, 5, 6};
        String[] row;
        while(scan.hasNextLine()) {
            row = scan.nextLine().split(",");
            String[] currData = new String[desiredColumns.length];
            for (int i = 0; i < desiredColumns.length; ++i) {
                currData[i] = row[desiredColumns[i]];
            }
            Pokemon currPokemon = new Pokemon(currData);
            arr.add(currPokemon);
        }
        scan.close();
    }
}
