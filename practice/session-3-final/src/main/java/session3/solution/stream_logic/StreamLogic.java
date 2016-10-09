package session3.solution.stream_logic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamLogic {

    // TODO 5: Zip two lists of strings; use ":" as delimiter
    // Hint: Use IntStream.range() and Stream.mapToObj()
    public List<String> zipLists(List<String> list1, List<String> list2) {
        return IntStream.range(0, Math.min(list1.size(), list2.size()))
                .mapToObj(i -> list1.get(i) + ":" + list2.get(i))
                .collect(Collectors.toList());
    }
}
