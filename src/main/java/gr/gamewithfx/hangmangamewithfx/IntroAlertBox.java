package gr.gamewithfx.hangmangamewithfx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class IntroAlertBox {
    private static final String ABC_PATH = "src/main/resources/images/";
    private static final String ABC_EXT = ".png";

    public static void display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(360);
        window.setMinHeight(400);

        FileInputStream loadImage;
        try {
            loadImage = new FileInputStream(ABC_PATH + "hangman_logo" + ABC_EXT);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Image logo = new Image(loadImage, 150, 250, true, true);
        ImageView imageView = new ImageView(logo);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Let's play!");
        closeButton.setOnAction(e -> window.close());
        label.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
        //closeButton.setBackground(new Background(new BackgroundFill(Color.BEIGE,new CornerRadii(10),Insets.EMPTY)));


        VBox layout = new VBox(15);
        layout.getChildren().addAll(imageView, label, closeButton);
        layout.setAlignment((Pos.CENTER));
        layout.setBackground(new Background(new BackgroundFill(Color.web("#62BDBD"), CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
