import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Long> junk = new TreeMap<>();
        TreeMap<String, Long> keyMaterials = new TreeMap<>();

        keyMaterials.put("shards", 0L);
        keyMaterials.put("motes", 0L);
        keyMaterials.put("fragments", 0L);

        boolean stop = false;

        while(!stop) {
            long quantity = Long.parseLong(scanner.next());
            String material = scanner.next().toLowerCase();

            if ("shards".equals(material) ||
                    "motes".equals(material) ||
                    "fragments".equals(material)) {
                keyMaterials.put(material, keyMaterials.get(material) + quantity);
            } else {
                if (!junk.containsKey(material)) {
                    junk.put(material, quantity);
                } else {
                    junk.put(material, junk.get(material) + quantity);
                }
            }
            for (String key : keyMaterials.keySet()) {
                if(keyMaterials.get(key) >= 250){
                    printResult(keyMaterials, junk, key);
                    stop = true;
                }
            }
        }
    }

    private static void printResult(TreeMap<String, Long> keyMaterials, TreeMap<String, Long> junk, String key) {
            String item = "";
            switch (key){
                case "fragments": item = "Valanyr";
                    break;
                case "motes": item = "Dragonwrath";
                    break;
                case "shards": item = "Shadowmourne";
                    break;
            }
            System.out.println(item + " obtained!");

            keyMaterials.put(key, keyMaterials.get(key) - 250);

            keyMaterials.entrySet().stream()
                    .sorted((a, b)-> b.getValue().compareTo(a.getValue()))
                    .forEach(p ->{
                        System.out.format("%s: %d\n", p.getKey(), p.getValue());
                    });
        for (String s : junk.keySet()) {
            System.out.println(s + ": " + junk.get(s));
        }
    }
}
