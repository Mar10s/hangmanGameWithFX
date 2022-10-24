package gr.gamewithfx.hangmangamewithfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HangmanGUI extends Application {

    @Override
    public void start(Stage stage) {
        Gallows gallows = new Gallows();
        AlphabetGrid alphabetGrid = new AlphabetGrid();
        stage.setTitle("Hangman Game");
        stage.setResizable(false);


        alphabetGrid.game.playSound("hallowed.mp3");
        IntroAlertBox.display("Welcome to Hangman Game!", " You have to guess all the letters correctly and find the word, \n before you're hanged and burned :D  ");


        BorderPane backLevel = new BorderPane();
        backLevel.setPadding(new Insets(5));
        backLevel.setBackground(new Background(new BackgroundFill(Color.web("#62BDBD"), CornerRadii.EMPTY, Insets.EMPTY)));


        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setAlignment(Pos.BOTTOM_CENTER);


        backLevel.setBottom(layout);

        alphabetGrid.drawAlphabet(layout, backLevel, stage);

        alphabetGrid.game.showBlanks(layout);

        gallows.updateGallows(alphabetGrid.game.getLives(), backLevel);


        Scene scene = new Scene(backLevel, 800, 550);

        // System.out.println(alphabetGrid.game.getWord());  //TODO remove this

        stage.setScene(scene);
        stage.sizeToScene();

        stage.show();


    }
}
