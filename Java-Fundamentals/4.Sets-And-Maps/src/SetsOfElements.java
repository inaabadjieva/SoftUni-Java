import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimen = scanner.nextLine().split(" ");
        int length1 = Integer.parseInt(dimen[0]);
        int length2 = Integer.parseInt(dimen[1]);

        Set<String> nums1 = new LinkedHashSet<>();
        Set<String> nums2 = new HashSet<>();

        for (int i = 0; i < length1; i++) {
            nums1.add(scanner.nextLine());
        }
        for (int i = 0; i < length2; i++) {
            nums2.add(scanner.nextLine());
        }

        nums1.retainAll(nums2);
        System.out.println(String.join(" ", nums1));
    }
}
