package pl.sda.mg;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CalculatorTests {

    @Test
    public void add_addingMoreThan2Numbers_returnsCorrectResult() {
        // to będzie test „czarnej skrzynki”

        //arrange
        Subcalculator sub = new Subcalculator();
        Calculator calc = new Calculator(sub);

        // act
        int result = calc.Add(3,4,5,6,7);

        //assert
        assertThat(result).isEqualTo(25);

    }

    @Test
    public void add_addingMoreThan2Numbers_correctlyCallsSubcalculator() {
        // to będzie test „białej skrzynki”

        //arrange
        //Subcalculator sub = mock(Subcalculator.class);
        Subcalculator sub = spy(Subcalculator.class);
        Calculator calc = new Calculator(sub);

        // act
        calc.Add(1, 2, 5);

        //assert
        verify(sub, times(3)).Add(anyInt(), anyInt());
        verify(sub, times(1)).Add(0, 1);
        verify(sub, times(1)).Add(1, 2);
        verify(sub, times(1)).Add(3, 5);
        verifyNoMoreInteractions(sub);



    }
}