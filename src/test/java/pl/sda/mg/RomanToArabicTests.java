package pl.sda.mg;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RomanToArabicTests {
    @Test
    public void convert_StringI_returnOne() {
        Converter converter = new Converter();
        int result = converter.convertRomanToArabic("I");
    }

    @Test
    public void convert_StringII_returnTwo() {
        Converter converter = new Converter();
        converter.convertRomanToArabic("II");
    }

    @Test
    public void convert_StringIII_returnThree() {
        Converter converter = new Converter();
        converter.convertRomanToArabic("III");
    }

    @Test
    public void convert_StringIV_returnFour() {
        Converter converter = new Converter();
        converter.convertRomanToArabic("IV");
    }

    @Test
    public void convert_StringV_returnFive() {
        Converter converter = new Converter();
        converter.convertRomanToArabic("V");
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
                arguments("I", 1),
                arguments("II", 2),
                arguments("III", 3),
                arguments("IV", 4),
                arguments("V", 5),
                arguments("VI", 6),
                arguments("VII", 7),
                arguments("VIII", 8),
                arguments("IX", 9),
                arguments("X", 10),
                arguments("XI", 11),
                arguments("XII", 12),
                arguments("XIII", 13),
                arguments("XIV", 14),
                arguments("XV", 15),
                arguments("XVI", 16),
                arguments("XVII", 17),
                arguments("XVIII", 18),
                arguments("XIX", 19),
                arguments("XX", 20),
                arguments("XXI", 21),
                arguments("XXII", 22),
                arguments("XXIII", 23),
                arguments("XXIV", 24),
                arguments("XXV", 25),
                arguments("XXVI", 26),
                arguments("XXVII", 27),
                arguments("XXVIII", 28),
                arguments("XXIX", 29),
                arguments("XXX", 30),
                arguments("XXXI", 31),
                arguments("XXXII", 32),
                arguments("XXXIII", 33),
                arguments("XXXIV", 34),
                arguments("XXXV", 35),
                arguments("XXXVI", 36),
                arguments("XXXVII", 37),
                arguments("XXXVIII", 38),
                arguments("XXXIX", 39),
                arguments("XL", 40),
                arguments("XLI", 41),
                arguments("XLII", 42),
                arguments("XLIII", 43),
                arguments("XLIV", 44),
                arguments("XLV", 45),
                arguments("XLVI", 46),
                arguments("XLVII", 47),
                arguments("XLVIII", 48),
                arguments("XLIX", 49),
                arguments("MMLXI", 2061)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    public void converter_convertingString_returnsCorrectResult
            (String input, int expectedResult) {

        Converter convert = new Converter();

        int result = convert.convertRomanToArabic(input);

        assertThat(result).isEqualTo(expectedResult);
    }
}
