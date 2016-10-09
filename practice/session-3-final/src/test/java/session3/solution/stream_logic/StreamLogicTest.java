package session3.solution.stream_logic;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;

public class StreamLogicTest {

    @Test
    public void givenTwoListsOfStrings_whenZippingThem_thenTheCorrectResultListIsReturned() throws IOException {
        List<String> list1 = asList("1", "2", "3", "4", "5", "6");
        List<String> list2 = asList("John", "Mary", "Bob", "Danny", "Anne");
        List<String> expectedResult = asList("1:John", "2:Mary", "3:Bob", "4:Danny", "5:Anne");

        List<String> actualResult = new StreamLogic().zipLists(list1, list2);

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }
}