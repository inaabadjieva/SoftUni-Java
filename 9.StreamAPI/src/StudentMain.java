import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMain {
    public static void main(String[] args) {
        Path studentsDataPath = Paths.get("/home/axltop/Projects/SoftUni-Java/9.StreamAPI/src/resources/StudentData.txt");
        List<String> data = new ArrayList<>();

        try {
            data = Files.readAllLines(studentsDataPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Student> students = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] tokens = data.get(i).split("\\s+");
            String facultyNum = tokens[0];
            String firstName = tokens[1];
            String lastName = tokens[2];
            String email = tokens[3];
            Integer age = Integer.parseInt(tokens[4]);
            Integer group = Integer.parseInt(tokens[5]);
            String phone = tokens[10];

            Student student = new Student(facultyNum, firstName, lastName, email, age, group, phone);

            for (int j = 6; j <= 9; j++) {
                Integer grade = Integer.parseInt(tokens[j]);
                student.getGrades().add(grade);
            }

            students.add(student);
        }

        //Filter by group
//        students.stream()
//                .filter(s -> s.getGroup() == 2)
//                .sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName()))
//                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));

        //Filter by name
//        students.stream()
//                .filter(s -> s.getFirstName().compareTo(s.getLastName()) < 0)
//                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));

        //Filter by age
//        students.stream()
//                .filter(s -> 18 <= s.getAge() && s.getAge() <= 24)
//                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getAge()));

//        //Sort by 2 criteria
//        Comparator<Student> lastAscending = (s1, s2) -> s1.getLastName().compareTo(s2.getLastName());
//        Comparator<Student> comparator = lastAscending.thenComparing((s1, s2) -> s2.getFirstName().compareTo(s1.getFirstName()));
//        students.stream()
//                .sorted(comparator)
//                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));

//        //Filter by email domain
//        students.stream()
//                .filter(s -> s.getEmail().endsWith("@gmail.com"))
//                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getEmail()));

//        //Filter by phone
//        students.stream()
//                .filter(s -> s.getPhone().startsWith("02") || s.getPhone().startsWith("+3592"))
//                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getPhone()));
//

//        //Filter by grades - excellent students
//        students.stream()
//                .filter(s -> s.getGrades().contains(6))
//                .forEach(s -> {
//                    System.out.print(s.getFirstName() + " " + s.getLastName() + " ");
//                    s.getGrades().stream()
//                            .sorted((g1, g2) -> Integer.compare(g2, g1))
//                            .forEach(g -> System.out.print(g + " "));
//                        System.out.println();
//                    });


//        //Filter weak students
//        students.stream()
//                .filter(s -> s.getGrades().stream().filter(g -> g <= 3).count() >= 2)
//                .sorted((s1, s2) ->
//                        Integer.compare(
//                                s1.getGrades().stream().mapToInt(Integer::valueOf).sum(),
//                                s2.getGrades().stream().mapToInt(Integer::valueOf).sum()))
//                .forEach(s -> {
//                    System.out.print(s.getFirstName() + " " + s.getLastName() + " ");
//                    s.getGrades().stream()
//                            .sorted((g1, g2) ->
//                                    Integer.compare(g1, g2))
//                            .forEach(g -> System.out.print(g + " "));
//                        System.out.println();
//                    });

        //Sort by enrollmentYear
        Map<Integer, List<Student>> studentsByYear = students.stream()
                .collect(Collectors.groupingBy(
                        s -> Integer.parseInt(s.getFacultyNumber().substring(s.getFacultyNumber().length() - 2))));

        studentsByYear.entrySet().stream()
                .sorted((y1, y2) -> Integer.compare(y1.getKey(), y2.getKey()))
                .forEach(e -> {
                    System.out.println("20" + e.getKey() + ":");
                    e.getValue().stream()
                            .sorted((n1, n2) ->(n1.getFirstName() + n1.getLastName()).compareTo(n2.getFirstName() + n2.getLastName()))
                            .forEach(n -> System.out.println("-- " + n.getFirstName() + " " + n.getLastName()));
                });

    }
}
