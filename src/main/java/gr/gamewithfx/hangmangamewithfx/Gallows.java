package gr.gamewithfx.hangmangamewithfx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;

public class Gallows {
    public void updateGallows(int lives, BorderPane backLevel) {

        try {
            String ABC_PATH = "src/main/resources/images/";
            String ABC_EXT = ".png";
            if (lives == 6) {
                FileInputStream loadImage = new FileInputStream(ABC_PATH + "hangman_0" + ABC_EXT);
                Image image = new Image(loadImage, 250, 300, true, true);
                ImageView imageView = new ImageView(image);
                backLevel.setLeft(imageView);

                FileInputStream loadImage2 = new FileInputStream(ABC_PATH + "6_lives" + ABC_EXT);
                Image livesImg = new Image(loadImage2, 150, 250, true, true);
                ImageView imageView2 = new ImageView(livesImg);
                backLevel.setRight(imageView2);

            } else if (lives == 5) {
                FileInputStream loadImage = new FileInputStream(ABC_PATH + "hangman_1" + ABC_EXT);
                Image image = new Image(loadImage, 250, 300, true, true);
                ImageView imageView = new ImageView(image);
                backLevel.setLeft(imageView);

                FileInputStream loadImage2 = new FileInputStream(ABC_PATH + "5_lives" + ABC_EXT);
                Image livesImg = new Image(loadImage2, 150, 250, true, true);
                ImageView imageView2 = new ImageView(livesImg);
                backLevel.setRight(imageView2);
            } else if (lives == 4) {
                FileInputStream loadImage = new FileInputStream(ABC_PATH + "hangman_2" + ABC_EXT);
                Image image = new Image(loadImage, 250, 300, true, true);
                ImageView imageView = new ImageView(image);
                backLevel.setLeft(imageView);

                FileInputStream loadImage2 = new FileInputStream(ABC_PATH + "4_lives" + ABC_EXT);
                Image livesImg = new Image(loadImage2, 150, 250, true, true);
                ImageView imageView2 = new ImageView(livesImg);
                backLevel.setRight(imageView2);

            } else if (lives == 3) {
                FileInputStream loadImage = new FileInputStream(ABC_PATH + "hangman_3" + ABC_EXT);
                Image image = new Image(loadImage, 250, 300, true, true);
                ImageView imageView = new ImageView(image);
                backLevel.setLeft(imageView);

                FileInputStream loadImage2 = new FileInputStream(ABC_PATH + "3_lives" + ABC_EXT);
                Image livesImg = new Image(loadImage2, 150, 250, true, true);
                ImageView imageView2 = new ImageView(livesImg);
                backLevel.setRight(imageView2);

            } else if (lives == 2) {
                FileInputStream loadImage = new FileInputStream(ABC_PATH + "hangman_4" + ABC_EXT);
                Image image = new Image(loadImage, 250, 300, true, true);
                ImageView imageView = new ImageView(image);
                backLevel.setLeft(imageView);

                FileInputStream loadImage2 = new FileInputStream(ABC_PATH + "2_lives" + ABC_EXT);
                Image livesImg = new Image(loadImage2, 150, 250, true, true);
                ImageView imageView2 = new ImageView(livesImg);
                backLevel.setRight(imageView2);

            } else if (lives == 1) {
                FileInputStream loadImage = new FileInputStream(ABC_PATH + "hangman_5" + ABC_EXT);
                Image image = new Image(loadImage, 250, 300, true, true);
                ImageView imageView = new ImageView(image);
                backLevel.setLeft(imageView);

                FileInputStream loadImage2 = new FileInputStream(ABC_PATH + "1_life" + ABC_EXT);
                Image livesImg = new Image(loadImage2, 150, 250, true, true);
                ImageView imageView2 = new ImageView(livesImg);
                backLevel.setRight(imageView2);

            } else if (lives == 0) {
                FileInputStream loadImage = new FileInputStream(ABC_PATH + "hangman_lose" + ABC_EXT);
                Image image = new Image(loadImage, 250, 300, true, true);
                ImageView imageView = new ImageView(image);
                backLevel.setLeft(imageView);

                FileInputStream loadImage2 = new FileInputStream(ABC_PATH + "0_lives" + ABC_EXT);
                Image livesImg = new Image(loadImage2, 150, 250, true, true);
                ImageView imageView2 = new ImageView(livesImg);
                backLevel.setRight(imageView2);

            }
        } catch (Exception ex) {
            System.exit(1);
        }
    }
}
