package pl.sda.mg;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringCalculatorTests {
    @Test
    public void calculate_1plus1_returnsTwo() {
        StringCalculator calc = new StringCalculator();

        int result = calc.calculate("1+1");

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void calculate_1plus2_returnsThree() {
        StringCalculator calc = new StringCalculator();

        int result = calc.calculate("1+2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void calculate_2plus2_returnsFour() {
        StringCalculator calc = new StringCalculator();

        int result = calc.calculate("2+2");

        assertThat(result).isEqualTo(4);
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
                arguments("1+1", 2),
                arguments("1+2", 3),
                arguments("2+2", 4),
                arguments("8+9", 17)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    public void calculate_8addingTwoSingleDigits_returnsCorrectResult
            (String input, int expectedResult) {

        StringCalculator calc = new StringCalculator();

        int result = calc.calculate(input);

        assertThat(result).isEqualTo(expectedResult);

    }
}
