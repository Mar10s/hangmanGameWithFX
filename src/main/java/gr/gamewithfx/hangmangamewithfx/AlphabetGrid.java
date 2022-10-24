package gr.gamewithfx.hangmangamewithfx;

import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;

import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;

public class AlphabetGrid {
    Game game = new Game();
    private static final String ABC_PATH = "src/main/resources/images/";
    private static final String ABC_EXT = ".png";
    private static final int GRID_SIZE_COL = 13;
    //private static final int GRID_SIZE_ROW = 2;

    public void drawAlphabet(GridPane layout, BorderPane backLevel, Stage stage) {

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                EventTarget target = e.getTarget();
                int idPos = target.toString().indexOf("id=");
                String imageId = target.toString().substring(idPos + 3, idPos + 4);
                char letter = imageId.charAt(0);
                hideLetter(layout, letter);
                game.findLettersPositions(letter, backLevel, layout, stage);
            }
        };

        int gridRow = 2;
        int gridCol = 0;
        for (int i = 0; i < 26; i++) {
            char letter = (char) ('a' + i);
            try {
                FileInputStream loadImage = new FileInputStream(ABC_PATH + letter + ABC_EXT);
                Image image = new Image(loadImage, 50, 50, true, true);
                ImageView imageView = new ImageView(image);
                imageView.setId(String.valueOf(letter));
                imageView.addEventFilter(MOUSE_CLICKED, eventHandler);
                layout.add(imageView, gridCol, gridRow);
                gridCol++;
                if (gridCol >= GRID_SIZE_COL) {
                    gridRow++;
                    gridCol = 0;
                }
            } catch (Exception ex) {
                System.err.println("Could not load alphabet image for letter " + letter + " from " + ABC_PATH + letter + ABC_EXT);
                System.exit(1);
            }
        }
    }

    public void hideLetter(GridPane layout, char letter) {
        try {
            FileInputStream loadImage = new FileInputStream(ABC_PATH + letter + "_guessed" + ABC_EXT);
            Image image = new Image(loadImage, 50, 50, true, true);
            ImageView imageView = new ImageView(image);
            int letterPosRow = (letter - 'a') / GRID_SIZE_COL;
            int letterPosCol = (letter - 'a') % GRID_SIZE_COL;
            layout.add(imageView, letterPosCol, letterPosRow + 2);

        } catch (Exception ex) {
            System.err.println("Could not load alphabet image for letter " + letter + " from " + ABC_PATH + letter + ABC_EXT);
            System.exit(1);
        }

    }

}
