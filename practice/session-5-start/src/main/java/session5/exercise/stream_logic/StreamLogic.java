package session5.exercise.stream_logic;

import java.util.List;
import java.util.function.Function;

public class StreamLogic {

    // TODO 1: Zip two lists of strings; use ":" as delimiter
    // Hint: Use IntStream.range() and Stream.mapToObj()
    // Hint: Zipping means that from two lists (1, 2, 3) and (a, b, c) => (1:a, 2:b, 3:c)
    public List<String> zipLists(List<String> list1, List<String> list2) {
        return null;
    }

    // TODO 2: Create a function String -> Integer that from a given string returns an integer incremented with the additionValue
    public Function<String, Integer> getStringToIntegerAdditiveFunction(int additionValue) {
        return null;
    }

    // TODO 3: Create a function String -> Integer that from a given string, concatenates the additionValue to it and returns an integer
    public Function<String, Integer> getStringToStringAdditiveFunction(int additionValue) {
        return null;
    }
}
