package gr.gamewithfx.hangmangamewithfx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class RandomWord {
    private String word;
    // dictionary may contain 1000 words
    private static final int MAX_DICT_SIZE = 1000
    private static final String[] words = new String[MAX_DICT_SIZE];

    // path and file name of dictionary file
    // dictionary file must be a simple text file with list of words, one in each line
    private static final String DICT_PATH = "src/main/java/gr/gamewithfx/hangmangamewithfx/";
    private static final String DICT_FILE = "hangman_en.dict";

    // the constructor loads the dictionary from the dict file and chooses one by random
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
            while (i < MAX_DICT_SIZE && (line = reader.readLine()) != null) {
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
