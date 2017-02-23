import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticHTML {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> words = new ArrayList<>(Arrays.asList("main", "header", "nav", "article", "section", "aside", "footer"));

        Pattern pattern1 = Pattern.compile("<div(.*)(?:(id|class)\\s*=\\s*\"(\\w+)\")(.*?)>");
        Pattern pattern2 = Pattern.compile("<\\/div>\\s*<!--\\s*(\\w+)\\s*-->");

        String input = reader.readLine();
        while (!"END".equals(input)) {
            Matcher matcher1 = pattern1.matcher(input);
            Matcher matcher2 = pattern2.matcher(input);
            StringBuilder result1 = new StringBuilder();
            if (matcher1.find()) {
                String word = matcher1.group(3);
                if(words.contains(word)){
                    result1.append("<").append(word);
                    if(!"".equals(matcher1.group(1)) && !" ".equals(matcher1.group(1))){
                        result1.append(" ");
                        result1.append(matcher1.group(1).trim());
                    }
                    if(!"".equals(matcher1.group(4)) && !" ".equals(matcher1.group(4))){
                        result1.append(" ");
                        result1.append(matcher1.group(4).trim());
                    }
                    result1.append(">");
                }
                System.out.println(result1);
            } else if(matcher2.find()){
                String word = matcher2.group(1);
                if(words.contains(word)){
                    System.out.println("</" + word.trim() + ">");
                }
            } else {
                System.out.println(input);

            }
            input = reader.readLine();
        }
    }
}
//    String openTag = "(?<replace><div).+(?<remove>(id|class) *?= *?\"(?<newName>\\w+)\").+>?";
//    String closeTag = "<\\/div>[\\s]*(?<delete><!--[\\s]*?(?<word>\\w+)[\\s]*?-->)";
//    Pattern closeTagPattern = Pattern.compile(closeTag);
//    Pattern openTagPattern = Pattern.compile(openTag);
//    String[] validTags = {"main", "header", "nav", "article", "section", "aside", "footer"};
//
//        while (true) {
//        String input = scan.readLine();
//        if ("END".equals(input)) {
//            break;
//        }
//        Matcher openTagMatcher = openTagPattern.matcher(input);
//        Matcher closeTagMatcher = closeTagPattern.matcher(input);
//        if (openTagMatcher.find() && Arrays.asList(validTags).contains(openTagMatcher.group("newName"))) {
//            String result = openTagMatcher.group()
//                    .replace(openTagMatcher.group("replace"), "<" + openTagMatcher.group("newName"))
//                    .replace(openTagMatcher.group("remove"), "");
//            System.out.println(result.replaceAll(" +>",">").replaceAll(" +"," "));
//        } else if (closeTagMatcher.find() && Arrays.asList(validTags).contains(closeTagMatcher.group("word"))){
//            String result = closeTagMatcher.group()
//                    .replace("div", closeTagMatcher.group("word"))
//                    .replace(closeTagMatcher.group("delete"),"");
//            System.out.println(result.replaceAll(" +",""));
//        } else {
//            System.out.println(input);
//        }
//    }
