package gr.gamewithfx.hangmangamewithfx;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;


public class Game extends Gallows {
    private static final String ABC_PATH = "src/main/resources/images/";
    private static final String ABC_EXT = ".png";
    private static final int GRID_SIZE_COL = 1;

    public Game() {
        Arrays.fill(letters, '_');
    }

    RandomWord randomWord = new RandomWord();


    private final int length = randomWord.getWordLength();

    private final char[] letters = new char[randomWord.getWordLength()];
    private int lives = 6;
    private final String word = randomWord.getWord();

    public String getWord() {
        return word;
    }

    public int getLength() {
        return length;
    }

    public int getLives() {
        return lives;
    }

    public boolean isWordFound() {
        String wordFound = new String(letters);
        return word.equalsIgnoreCase(wordFound);
    }

    public boolean includesLetter(char guessChar, int checkingPosition) {
        for (int i = checkingPosition; i < length; i++) {
            if (word.charAt(i) == guessChar)
                return true;
        }
        return false;
    }

    public void findLettersPositions(char guessChar, BorderPane backlevel, GridPane guessedLetters, Stage stage) {
        int checkingPosition = 0;
        int position;
        boolean result = includesLetter(guessChar, checkingPosition);
        if (result) {
            if (!isWordFound()) {
                playSound("letterExists.mp3");
            }
            for (checkingPosition = 0; checkingPosition < length; checkingPosition++) {
                if (word.charAt(checkingPosition) == guessChar) {
                    position = checkingPosition;
                    letters[position] = guessChar;

                    try {
                        FileInputStream loadImage = new FileInputStream(ABC_PATH + guessChar + ABC_EXT);
                        Image image = new Image(loadImage, 50, 50, true, true);
                        ImageView imageView = new ImageView(image);
                        int letterPosRow = GRID_SIZE_COL;
                        int letterPosCol = position + (13 - length) / 2;
                        guessedLetters.add(imageView, letterPosCol, letterPosRow);

                    } catch (Exception ex) {
                        System.exit(1);
                    }
                }
            }
        } else {
            if (lives != 0 || lives != 1) {
                playSound("letterDoesntexist.mp3");
            }
            lives--;
            updateGallows(lives, backlevel);
            if (lives == 1) {
                playSound("bellsTolling.mp3");
            }
        }

        if (isWordFound() && getLives() != 0) {
            playSound("weAreChamps.mp3");
            OutroAlertBoxWin.display("Found it!", "The word was: " + getWord() + "\n       You're spared!");

            if (OutroAlertBoxWin.isAnswer()) {
                stage.close();
                Platform.runLater(() -> {
                    try {
                        new HangmanGUI().start(new Stage());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            } else {
                System.exit(0);
            }
        } else if (getLives() == 0) {
            playSound("anotherOne.mp3");
            OutroAlertBoxLose.display("You're both hanged and burned!", "  The word was: " + getWord() + "  ");

            if (OutroAlertBoxLose.isAnswer()) {
                stage.close();
                Platform.runLater(() -> {
                    try {
                        new HangmanGUI().start(new Stage());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            } else {
                System.exit(0);
            }
        }
    }

    public void showBlanks(GridPane layout) {
        int length = getLength();

        for (int i = 0; i < length; i++) {
            try {
                FileInputStream loadImage = new FileInputStream(ABC_PATH + "blank" + ABC_EXT);
                Image image = new Image(loadImage, 50, 50, true, true);
                ImageView imageView = new ImageView(image);
                int letterPosRow = GRID_SIZE_COL;
                int letterPosCol = i + (13 - length) / 2;
                layout.add(imageView, letterPosCol, letterPosRow);

            } catch (Exception ex) {
                System.exit(1);
            }
        }
    }

    public void playSound(String soundFile) {

        String path = getClass().getResource(soundFile).getPath();
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();


    }
}
