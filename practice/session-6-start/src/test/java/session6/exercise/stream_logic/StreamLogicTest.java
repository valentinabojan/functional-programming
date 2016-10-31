package session6.exercise.stream_logic;

import org.junit.Test;
import session6.exercise.stream_logic.StreamLogic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamLogicTest {

    @Test
    public void givenAStartingNumberOf0AndALimit_whenGenerateEvenNumbers_thenTheCorrectResultListIsReturned() {
        List<Integer> expectedResult = asList(0, 2, 4, 6, 8, 10);

        List<Integer> actualResult = new StreamLogic().generateEvenNumbers(0, 6);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void givenAStartingNumberOf5AndALimit_whenGenerateEvenNumbers_thenTheCorrectResultListIsReturned() {
        List<Integer> expectedResult = asList(6, 8, 10, 12, 14, 16, 18, 20);

        List<Integer> actualResult = new StreamLogic().generateEvenNumbers(5, 8);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void givenALimit_whenGenerateFibonacciNumbers_thenTheCorrectResultListIsReturned() {
        List<Integer> expectedResult = asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610);

        List<Integer> actualResult = new StreamLogic().generateFibonacciNumbers(15);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void givenALimit_whenGenerateFibonacciNumbers_thenTheCorrectResultListIsReturned1() {
        List<Integer> expectedResult = asList(1, 4, 7, 10);
        List<Integer> inputList = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

        List<Integer> actualResult = new StreamLogic().extractElementsFromPosition(inputList, 3);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}