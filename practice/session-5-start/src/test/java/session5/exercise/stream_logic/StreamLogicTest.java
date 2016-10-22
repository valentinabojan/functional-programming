package session5.exercise.stream_logic;

import org.junit.Test;
import session5.exercise.stream_logic.StreamLogic;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamLogicTest {

    @Test
    public void givenTwoListsOfStrings_whenZippingThem_thenTheCorrectResultListIsReturned() throws IOException {
        List<String> list1 = asList("1", "2", "3", "4", "5", "6");
        List<String> list2 = asList("John", "Mary", "Bob", "Danny", "Anne");
        List<String> expectedResult = asList("1:John", "2:Mary", "3:Bob", "4:Danny", "5:Anne");

        List<String> actualResult = new StreamLogic().zipLists(list1, list2);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void givenAnAdditionValue_whenGettingTheStringToIntegerAdditiveFunction_thenTheCorrectResultValueIsReturned1() {
        Integer actualValue = new StreamLogic().getStringToIntegerAdditiveFunction(5).apply("1");

        assertThat(actualValue).isEqualTo(6);
    }

    @Test
    public void givenAnAdditionValue_whenGettingTheStringToStringAdditiveFunction_thenTheCorrectResultValueIsReturned1() {
        Integer actualValue = new StreamLogic().getStringToStringAdditiveFunction(5).apply("1");

        assertThat(actualValue).isEqualTo(15);
    }
}