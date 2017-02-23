package homework;

import java.io.*;
import java.util.*;

public class WordCount {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/homework/resources/";
    private static final String WORDS_FILE_PATH = PROJECT_PATH + "/words.txt";
    private static final String TEXT_FILE_PATH = PROJECT_PATH + "/text.txt";
    private static final String OUTPUT_PATH = PROJECT_PATH + "/output.txt";

    public static void main(String[] args) throws FileNotFoundException {
        FileReader wordsFile = new FileReader(WORDS_FILE_PATH);
        FileReader textFile = new FileReader(TEXT_FILE_PATH);

        HashMap<String, Integer> wordsCount = new HashMap<>();
        HashMap<String, String> wordsOriginal = new HashMap<>();

        try(BufferedReader wordsReader = new BufferedReader(wordsFile);
            BufferedReader textReader = new BufferedReader(textFile);
            PrintWriter out = new PrintWriter(OUTPUT_PATH)){

            String line = "";
            while((line = wordsReader.readLine()) != null){
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String wordToLower = word.toLowerCase();
                    if(!wordsCount.containsKey(wordToLower)){
                        wordsCount.put(wordToLower, 0);
                        wordsOriginal.put(wordToLower, word);
                    }
                }
            }

            while((line = textReader.readLine()) != null){
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String wordToLower = word.toLowerCase();
                    if(wordsCount.containsKey(wordToLower)){
                        wordsCount.put(wordToLower, wordsCount.get(wordToLower) + 1);
                    }
                }
            }

            wordsCount.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(pair -> {
                        out.write(String.format("%s - %d\n", wordsOriginal.get(pair.getKey()), pair.getValue()));
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
