package gr.gamewithfx.hangmangamewithfx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class RandomWord {
    private String word;
    private static final String[] words = new String[1000];

    private static final String DICT_PATH = "src/main/java/gr/gamewithfx/hangmangamewithfx/";
    private static final String DICT_FILE = "hangman_en.dict";

    public RandomWord() {
        int numOfWords = loadDictionary();
        if (numOfWords > 0) {
            int randomIndex = (int) (Math.random() * numOfWords);
            word = words[randomIndex];
        } else {
            System.err.println("Could not load the dictionary from " + DICT_PATH + DICT_FILE);
            System.exit(1);
        }
    }

    public String getWord() {
        return word;
    }

    public int getWordLength() {
        return word.length();
    }

    private int loadDictionary() {
        File dictFile = null;
        int i = 0;
        try {
            dictFile = new File(DICT_PATH + DICT_FILE);
            FileReader fileReader = new FileReader(dictFile);

            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            while (i < 1000 && (line = reader.readLine()) != null) {
                words[i] = line;
                i++;
            }
            reader.close();
        } catch (Exception ex) {
//            ex.printStackTrace();
            System.err.println("Could not open the file " + DICT_PATH + DICT_FILE);
            System.exit(1);
        }
        return i;
    }
}
