package advanced_java_programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCreationExample {

    public static void main(String[] args) {
        Path path = Paths.get("src/main/java/advanced_java_programming/example2.txt");
        try {
            if (Files.notExists(path)) Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
