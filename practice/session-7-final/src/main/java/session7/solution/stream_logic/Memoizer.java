package session7.solution.stream_logic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Memoizer {

    private final List<Integer> priceValues = Arrays.asList(2, 1, 1, 2, 2, 2, 1, 8, 9, 15);

    private static <T, R> R callMemoized(final BiFunction<Function<T, R>, T, R> function, final T input) {
        Function<T, R> memoized = new Function<T, R>() {
            private final Map<T, R> store = new HashMap<>();

            public R apply(final T input) {
                return store.computeIfAbsent(input, key -> function.apply(this, key));
            }
        };
        return memoized.apply(input);
    }

    private int maxProfit(final int rodLenth) {
        return callMemoized(
                (final Function<Integer, Integer> func, final Integer length) -> {
                    int profit = (length <= priceValues.size()) ? priceValues.get(length - 1) : 0;
                    for (int i = 1; i < length; i++) {
                        int priceWhenCut = func.apply(i) + func.apply(length - i);
                        if (profit < priceWhenCut) profit = priceWhenCut;
                    }
                    return profit;
                }, rodLenth);
    }

    public static void main(String[] args) {
        Memoizer rodCutter = new Memoizer();
        System.out.println(rodCutter.maxProfit(5));
        System.out.println(rodCutter.maxProfit(22));
    }
}