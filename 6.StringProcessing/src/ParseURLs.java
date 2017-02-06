import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseURLs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("://");
        if(line.length != 2){
            System.out.println("Invalid URL");
        } else {
            String protocol = line[0];
            int index = line[1].indexOf("/");
            String server = line[1].substring(0, index);
            String resourses = line[1].substring(index + 1);

            System.out.println("Protocol = " + protocol);
            System.out.println("Server = " + server);
            System.out.println("Resources = " + resourses);
        }
    }
}
