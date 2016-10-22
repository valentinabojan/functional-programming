package session5.solution.stream_logic;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamLogic {

    // TODO 1: Zip two lists of strings; use ":" as delimiter
    // Hint: Use IntStream.range() and Stream.mapToObj()
    // Hint: Zipping means that from two lists (1, 2, 3) and (a, b, c) => (1:a, 2:b, 3:c)
    public List<String> zipLists(List<String> list1, List<String> list2) {
        return IntStream.range(0, Math.min(list1.size(), list2.size()))
                .mapToObj(i -> list1.get(i) + ":" + list2.get(i))
                .collect(Collectors.toList());
    }

    // TODO 2: Create a function String -> Integer that from a given string returns an integer incremented with the additionValue
    public Function<String, Integer> getStringToIntegerAdditiveFunction(int additionValue) {
        Function<String, Integer> after = s -> Integer.valueOf(s);
        Function<Integer, Integer> before = i -> i + additionValue;

        return after.andThen(before);
    }

    // TODO 3: Create a function String -> Integer that from a given string, concatenates the additionValue to it and returns an integer
    public Function<String, Integer> getStringToStringAdditiveFunction(int additionValue) {
        Function<String, Integer> before = s -> Integer.valueOf(s);
        Function<String, String> after = i -> i + additionValue;

        return before.compose(after);
    }
}
