import java.io.*;

public class SerializeObject {
    public static void main(String[] args) {
        final String path = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/output.txt";

        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3;
        cube.height = 12.5;
        cube.depth = 10;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            Cube loadedCube = (Cube) in.readObject();
            System.out.println(loadedCube.color);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
