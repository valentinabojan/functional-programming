import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class StreamFilterTest {

    @Test
    public void testFilterPerformance() throws IOException {
        Integer number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream()
                .filter(n -> {
                    System.out.println(n);
                    return n % 2 == 0;
                })
                .findFirst()
                .orElse(null);

        System.out.println("====> " + number);
    }
}
