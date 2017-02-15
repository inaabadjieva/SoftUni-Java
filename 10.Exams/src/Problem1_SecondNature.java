import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1_SecondNature {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        List<Integer> flowers = new ArrayList<>();
        for (String s : input) {
            flowers.add(Integer.parseInt(s));
        }

        String[] input2 = reader.readLine().split(" ");
        List<Integer> buckets = new ArrayList<>();
        for (String s : input2) {
            buckets.add(Integer.parseInt(s));
        }
        List<Integer> secondFlowes = new ArrayList<>();

        for (int i = 0; i < flowers.size(); i++) {

            for (int j = buckets.size() - 1; j >= 0 ; j--) {
                int currentBucket = buckets.get(j);

                int remainder = currentBucket - flowers.get(i);

                if(remainder >= 0){
                    if(remainder == 0){
                        secondFlowes.add(flowers.get(i));
                    }
                    flowers.remove(i);
                    if(j > 0){
                        buckets.set(j-1, buckets.get(j-1) + remainder);
                        buckets.remove(j);
                    } else {
                        buckets.set(j,remainder);
                    }

                    j--;
                    i--;
                    break;
                } else {
                    buckets.remove(j);
                    flowers.set(i,Math.abs(remainder));

                }
            }

        }

        //printing result
        if (buckets.size() > 0) {
            for (int i = buckets.size() - 1; i >= 0; i--) {
                System.out.print(buckets.get(i) + " ");
            }
        } else {
            for (int i = 0; i < flowers.size(); i++) {
                System.out.print(flowers.get(i) + " ");
            }
        }

        System.out.println();
        if(secondFlowes.size() != 0){
            for (Integer secondFlowe : secondFlowes) {
                System.out.print(secondFlowe + " ");
            }
        } else {
            System.out.println("None");
        }
    }
}
