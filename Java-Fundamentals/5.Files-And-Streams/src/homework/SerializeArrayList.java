package homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeArrayList {
    private static final String output = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/src/homework/resources/list.ser";

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        Collections.addAll(list, 12.5, 2.4, 1.1, 23.5);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(output))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(output))) {
            List<Double> loadedList = (ArrayList<Double>) in.readObject();
            System.out.println(loadedList.size());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
