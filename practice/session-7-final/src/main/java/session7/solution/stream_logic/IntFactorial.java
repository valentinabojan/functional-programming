package session7.solution.stream_logic;

public class IntFactorial {

    private static TailCall<Integer> factorialTailRec(
            final Integer factorial, final Integer number) {
        if (number == 1)
            return TailCalls.done(factorial);
        else
            return TailCalls.call(() -> factorialTailRec(factorial * number, number - 1));
    }

    private static int factorial(final int number) {
        return factorialTailRec(1, number).invoke();
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));        // 120
        System.out.println(factorial(20000));    // 0

        System.out.println(Integer.MAX_VALUE +2);
    }
}

