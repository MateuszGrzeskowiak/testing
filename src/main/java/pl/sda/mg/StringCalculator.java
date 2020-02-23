package pl.sda.mg;

import javax.swing.*;

public class StringCalculator {
    public int calculate(String input) {

        String first = input.substring(0,1);
        String second = input.substring(2,3);

        int firstNumber = Integer.parseInt(first);
        int secondNumber = Integer.parseInt(second);

        return firstNumber + secondNumber;
    }
}
