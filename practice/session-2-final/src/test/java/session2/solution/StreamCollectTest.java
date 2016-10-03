package session2.solution;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class StreamCollectTest {

    @Test
    public void givenAListOfStrings_whenCollectingThemInParallel_thenTheCombinerBiConsumerIsUsed() {
        List<String> stringList = asList("a", "b", "c", "d", "e", "f");

        String result = stringList.stream()
                .parallel()
                .collect(StringBuilder::new,
                        (stringBuilder, str) -> stringBuilder.append(str).append(","),
                        (stringBuilder1, stringBuilder2) -> stringBuilder1.append("-").append(stringBuilder2)).toString();

        Assertions.assertThat(result).isEqualTo("a,-b,-c,-d,-e,-f,");
    }

    @Test
    public void givenAListOfStrings_whenCollectingThemSequentially_thenTheCombinerBiConsumerIsNotUsed() {
        List<String> stringList = asList("a", "b", "c", "d", "e", "f");

        String result = stringList.stream()
                .collect(StringBuilder::new,
                        (stringBuilder, str) -> stringBuilder.append(str).append(","),
                        (stringBuilder1, stringBuilder2) -> stringBuilder1.append("-").append(stringBuilder2)).toString();

        Assertions.assertThat(result).isEqualTo("a,b,c,d,e,f,");
    }
}
