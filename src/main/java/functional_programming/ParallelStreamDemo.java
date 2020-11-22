package functional_programming;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamDemo {

    public static void main(String[] args) {
        List<String> words = List.of("hello", "apple", "functional", "programming", "cool");
        List<String> processedWords = words.parallelStream()
                .map(word -> {
                    System.out.println(String.format("Converting to uppercase %s", word));
                    return word.toUpperCase();
                })
                .map(word -> {
                    System.out.println(String.format("Adding exclamation point to %s", word));
                    return word + "!";
                })
                .collect(Collectors.toList());
        System.out.println(processedWords);
    }

}
