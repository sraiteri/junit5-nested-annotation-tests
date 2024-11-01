package au.com.shaneraiteri.junit5nestedannotationtests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("Add tests")
    @Nested
    class AddTests {

        @Test
        @DisplayName("1 + 1")
        void onePlusOne() {
            assertEquals(BigDecimal.valueOf(2), calculator.add(BigDecimal.ONE, BigDecimal.ONE));
        }

        @DisplayName("Add")
        @ParameterizedTest(name = "{0} + {1} = {2}")
        @MethodSource("aPlusBProvider")
        void aPlusB(final BigDecimal a,
                    final BigDecimal b,
                    final BigDecimal expected) {
            assertEquals(expected, calculator.add(a, b));
        }

        private static Stream<Arguments> aPlusBProvider() {
            return Stream.of(
                    Arguments.of(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO),
                    Arguments.of(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.valueOf(2)),
                    Arguments.of(BigDecimal.ZERO, BigDecimal.ONE.negate(), BigDecimal.valueOf(-1))
            );
        }
    }

    @DisplayName("Subtract tests")
    @Nested
    class SubtractTests {

        @Test
        @DisplayName("1 - 1")
        void oneMinusOne() {
            assertEquals(BigDecimal.ZERO, calculator.subtract(BigDecimal.ONE, BigDecimal.ONE));
        }

        @DisplayName("Subtract")
        @ParameterizedTest(name = "{0} + {1} = {2}")
        @MethodSource("aSubtractBProvider")
        void aPlusB(final BigDecimal a,
                    final BigDecimal b,
                    final BigDecimal expected) {
            assertEquals(expected, calculator.subtract(a, b));
        }

        private static Stream<Arguments> aSubtractBProvider() {
            return Stream.of(
                    Arguments.of(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO),
                    Arguments.of(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ZERO),
                    Arguments.of(BigDecimal.ZERO, BigDecimal.ONE.negate(),BigDecimal.ONE)
            );
        }
    }
}
