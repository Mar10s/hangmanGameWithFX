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

public class OutroAlertBoxLose {
    private static final String ABC_PATH = "src/main/resources/images/";
    private static final String ABC_EXT = ".png";
    private static boolean answer;

    public static void display(String title, String message) {
        Stage window = new Stage();


        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(450);
        window.setMinHeight(500);


        FileInputStream loadImage;
        try {
            loadImage = new FileInputStream(ABC_PATH + "lose" + ABC_EXT);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Image lost = new Image(loadImage, 270, 450, true, true);
        ImageView imageView = new ImageView(lost);

        Label label = new Label();
        label.setText(message);
        label.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));

        Button replay = new Button("NO! I'm not REALLY dead yet...");
        replay.setOnAction(e -> {
            answer = true;
            window.close();
        });
        Button closeButton = new Button("Quit and enjoy your ghost life!");
        closeButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(15);
        layout.getChildren().addAll(imageView, label, closeButton, replay);
        layout.setAlignment((Pos.CENTER));
        layout.setBackground(new Background(new BackgroundFill(Color.web("#62BDBD"), CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();


    }

    public static boolean isAnswer() {
        return answer;
    }
}
