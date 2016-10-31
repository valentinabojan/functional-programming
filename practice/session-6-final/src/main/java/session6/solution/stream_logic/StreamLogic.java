package session6.solution.stream_logic;

import session6.solution.api.Pair;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static session6.solution.api.Pair.pair;

public class StreamLogic {

    // TODO 1: Generate the even numbers stream
    // Example: generateEvenNumbers(10, 5) => (10, 12, 14, 16, 18)
    public List<Integer> generateEvenNumbers(Integer fromNumber, Integer limit) {
        return Stream
                .iterate(fromNumber % 2 == 0 ? fromNumber : fromNumber + 1, n -> n + 2)
                .limit(limit)
                .collect(Collectors.toList());
    }

    // TODO 2: Generate the Fibonacci stream
    // Example: generateFibonacciNumbers(15) => (1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610)
    public List<Integer> generateFibonacciNumbers(Integer limit) {
        Pair<Integer, Integer> seed = pair(1, 1);
        UnaryOperator<Pair<Integer, Integer>> unaryOperator = p -> pair(p.getSecond(), p.getFirst() + p.getSecond());

        return Stream
                .iterate(seed, unaryOperator)
                .map(Pair::getFirst)
                .limit(limit)
                .collect(Collectors.toList());
    }

    // TODO 3: Extract the elements from certain positions from a given list
    // Example: extractElementsFromPosition((10, 12, 14, 16, 18), 2) => (10, 14, 18)
    public List<Integer> extractElementsFromPosition(List<Integer> list, Integer step) {
        return IntStream
                .range(0, list.size())
                .filter(n -> n % step == 0)
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }
}
