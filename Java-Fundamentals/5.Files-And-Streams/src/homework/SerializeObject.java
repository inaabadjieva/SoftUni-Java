package homework;

import java.io.*;

public class SerializeObject {
    private static final String output = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/src/homework/resources/course.ser";

    public static void main(String[] args) {
        Course course = new Course();
        course.name = "Java Fundamentals";
        course.studentsCount = 299;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(output))) {
            oos.writeObject(course);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(output))) {
            Course loadedCourse = (Course) in.readObject();
            System.out.println(course.name);
            System.out.println(course.studentsCount);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
