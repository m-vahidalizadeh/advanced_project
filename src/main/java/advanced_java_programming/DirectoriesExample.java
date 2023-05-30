package advanced_java_programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DirectoriesExample {

    public static void main(String[] args) {
        try {
            Files.list(Paths.get("."))
                    .filter(file -> !Files.isDirectory(file))
                    .forEach(System.out::println);
            if (Files.notExists(Paths.get("src/main/java/advanced_java_programming/example")))
                Files.createDirectory(Paths.get("src/main/java/advanced_java_programming/example"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
