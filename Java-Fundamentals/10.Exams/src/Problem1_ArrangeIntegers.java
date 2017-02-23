import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Problem1_ArrangeIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split(", ");

        TreeMap<String, String> sortedNums = new TreeMap<>();

        for(String num : numbers){
            String currentNum = "";

            for (int i = 0; i < num.length(); i++) {
                if(i != 0){
                    currentNum += "-";
                }

                switch(num.charAt(i)){
                    case '0':
                        currentNum += "zero";
                        break;
                    case '1':
                        currentNum += "one";
                        break;
                    case '2':
                        currentNum += "two";
                        break;
                    case '3':
                        currentNum += "three";
                        break;
                    case '4':
                        currentNum += "four";
                        break;
                    case '5':
                        currentNum += "five";
                        break;
                    case '6':
                        currentNum += "six";
                        break;
                    case '7':
                        currentNum += "seven";
                        break;
                    case '8':
                        currentNum += "eight";
                        break;
                    case '9':
                        currentNum += "nine";
                        break;
                }
            }

            if(sortedNums.containsKey(currentNum)){
                String newValue = sortedNums.get(currentNum) + ", " + num;
                sortedNums.replace(currentNum, newValue);
            } else{
                sortedNums.put(currentNum, num);
            }
        }

        System.out.println(String.join(", ", sortedNums.values()));
    }
}
