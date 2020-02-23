package pl.sda.mg;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void calculate_8plus9_returnsSeventeen() {
        StringCalculator calc = new StringCalculator();

        int result = calc.calculate("8+9");

        assertThat(result).isEqualTo(17);

    }
}
