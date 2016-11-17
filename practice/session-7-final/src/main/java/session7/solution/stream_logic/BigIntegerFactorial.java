package session7.solution.stream_logic;

import java.math.BigInteger;
import java.util.Objects;

import static session7.solution.stream_logic.TailCalls.call;
import static session7.solution.stream_logic.TailCalls.done;

public class BigIntegerFactorial {

    private static TailCall<BigInteger> factorialTailRec(
            final BigInteger factorial, final BigInteger number) {
        if (Objects.equals(number, BigInteger.ONE))
            return done(factorial);
        else
            return call(() -> factorialTailRec(factorial.multiply(number), number.subtract(BigInteger.ONE)));
    }

    private static BigInteger factorial(final BigInteger number) {
        return factorialTailRec(BigInteger.ONE, number).invoke();
    }

    public static void main(String[] args) {
        BigInteger n = BigInteger.valueOf(20000);
        BigInteger result = factorial(n);

        System.out.println(n + "! = " + result);
    }
}

