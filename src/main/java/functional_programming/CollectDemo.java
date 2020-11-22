package functional_programming;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectDemo {

    public static void main(String[] args) {
        List<String> words = List.of("hello", "apple", "functional", "programming", "is", "cool");
        List<String> longWordList = words.stream()
                .filter(word -> word.length() > 5)
                .collect(Collectors.toList());
        System.out.println(longWordList);
        Set<String> longWordSet = words.stream()
                .filter(word -> word.length() > 5)
                .collect(Collectors.toSet());
        System.out.println(longWordSet);
        String joinLongWords = words.stream()
                .filter(word -> word.length() > 5)
                .collect(Collectors.joining(", "));
        System.out.println(joinLongWords);
        Long longWordsCount = words.stream()
                .filter(word -> word.length() > 5)
                .collect(Collectors.counting());
        System.out.println(longWordsCount);
        Map<Integer, List<String>> grouping = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word.length()
                ));
        System.out.println(grouping);
        Map<Boolean, List<String>> partitions = words.stream()
                .collect(Collectors.partitioningBy(
                        word -> word.length() > 5
                ));
        System.out.println(partitions);
    }

}
