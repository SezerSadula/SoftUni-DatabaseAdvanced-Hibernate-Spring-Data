import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Pr02StudentsByFirstAndLastName {

    public static void main(String[] args) {

        streamOfInputData()
                .filter(student -> student[0].compareTo(student[1]) < 0)
                .forEach(student -> System.out.printf("%s %s%n", student[0], student[1]));
    }

    private static Stream<String[]> streamOfInputData() {
        List<String> input = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String line;

            while (!"END".equalsIgnoreCase(line = reader.readLine().trim())) {
                input.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return input.stream().map(str -> str.split("\\s+"));
    }
}
