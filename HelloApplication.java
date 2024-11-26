package com.example.main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.*;

public class HelloApplication extends Application {

    public boolean numOrderStatus = true;
    public boolean alphaOrderStatus = true;

    public boolean getNumOrderStatus() {
        return numOrderStatus;
    }
    public boolean getAlphaOrderStatus() {
        return alphaOrderStatus;
    }
    public void setNumOrderStatus(boolean numOrderStatus) {
        this.numOrderStatus = numOrderStatus;
    }
    public void setAlphaOrderStatus(boolean alphaOrderStatus) {
        this.alphaOrderStatus = alphaOrderStatus;
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Create a BorderPane as the root layout
        BorderPane root = new BorderPane();
        Label topLabel = new Label("Pokedex");
        topLabel.setFont(new Font(25));
        BorderPane.setAlignment(topLabel, Pos.CENTER);
        root.setTop(topLabel);

        final ArrayList<Pokemon>[] pokedexData = new ArrayList[]{new ArrayList<>()};
        Util.getPokedexData(pokedexData[0]);

        VBox vbox2 = new VBox();

        Util.displayList(vbox2, pokedexData[0]);

        ScrollPane scrollPane = new ScrollPane();
        vbox2.setSpacing(10);
        scrollPane.setContent(vbox2);
        root.setCenter(scrollPane);


        VBox vbox = new VBox();
        Button button1 = new Button("Pokedex Number Order");
        //lambda expression below, only works with functional expressions, instead of using eventhandler interface
        button1.setOnAction(event -> {
            // Handle button click event here
                if (getNumOrderStatus()) {
                    setNumOrderStatus(false);
                    pokedexData[0] = Util.regularNumOrder(pokedexData[0]);
                    Util.displayList(vbox2, pokedexData[0]);
                } else {
                    setNumOrderStatus(true);
                    pokedexData[0] = Util.reverseNumOrder(pokedexData[0]);
                    Util.displayList(vbox2, pokedexData[0]);
                }
        });
        Button button2 = new Button("Alphabetical Order");
        button2.setOnAction(event -> {
            // Handle button click event here
            if (getAlphaOrderStatus()) {
                setAlphaOrderStatus(false);
                pokedexData[0] = Util.alphabeticalNameOrder(pokedexData[0]);
                Util.displayList(vbox2, pokedexData[0]);
            } else {
                setAlphaOrderStatus(true);
                pokedexData[0] = Util.reverseAlphabeticalNameOrder(pokedexData[0]);
                Util.displayList(vbox2, pokedexData[0]);
            }
        });

        ComboBox<String> selectForm = new ComboBox<>();
        List<String> types = new ArrayList<>();
        selectForm.setValue("Select type");
        types.add("all");
        types.add("normal");
        types.add("fire");
        types.add("water");
        types.add("electric");
        types.add("grass");
        types.add("ice");
        types.add("fighting");
        types.add("poison");
        types.add("ground");
        types.add("flying");
        types.add("psychic");
        types.add("bug");
        types.add("rock");
        types.add("ghost");
        types.add("dragon");
        types.add("dark");
        types.add("steel");
        types.add("fairy");
        selectForm.getItems().addAll(types);
        vbox.getChildren().addAll(button1, button2, selectForm);
        vbox.setSpacing(10);

        selectForm.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                pokedexData[0] = Util.displayTypePokemon(newValue, pokedexData[0]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Util.displayList(vbox2, pokedexData[0]);
        });

        root.setLeft(vbox);


        // Create a scene with the BorderPane as its root node
        Scene scene = new Scene(root, 650, 450); // Set width and height

        // Set the scene on the stage
        stage.setScene(scene);

        // Set the title of the stage
        stage.setTitle("My JavaFX App with BorderPane");

        // Display the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}