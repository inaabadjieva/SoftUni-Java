package homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountCharsType {
    private static final String path = "/src/homework/resources/";

    public static void main(String[] args) throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path + "/countCharsInput.txt";
        String output = projectPath + path + "/output.txt";
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);

        List<Character> vowelsList = new ArrayList<>();
        Collections.addAll(vowelsList, 'a', 'e', 'u', 'o', 'i');

        List<Character> punctuation = new ArrayList<>();
        Collections.addAll(punctuation, '.', ',', '?', '!');

        try(BufferedReader in = new BufferedReader(fileReader);
            PrintWriter out = new PrintWriter(output)){
            String line;
            int vowels = 0;
            int consonants = 0;
            int punct = 0;
            while((line = in.readLine()) != null){
                for (char c : line.toCharArray()) {
                    if(punctuation.contains(c)){
                        punct++;
                    } else if(vowelsList.contains(c)){
                        vowels++;
                    } else if(c == ' ' || c == '\n'){
                        continue;
                    } else {
                        consonants++;
                    }
                }
            }
            out.println("Vowels: " + vowels);
            out.println("Consonants: " + consonants);
            out.println("Punctuation: " + punct);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
