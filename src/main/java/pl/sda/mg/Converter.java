package pl.sda.mg;

import org.junit.jupiter.params.provider.Arguments;

import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Converter {

    public int convert(String input) {
//        if (input.equals("I")) {
//            return 1;
//        }else if (input.equals("II")){
//            return 2;
//        }else return 3;
//    }

        Map<java.lang.Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        int result = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            char nextChar = input.charAt(i + 1);


            int currentCharValue = map.get(currentChar);
            int nextCharValue = map.get(nextChar);

            if (currentCharValue < nextCharValue) {
                result = result - currentCharValue + nextCharValue;
            } else if (currentCharValue >= nextCharValue){
                result = result + currentCharValue + nextCharValue;

            }


//            if (input.charAt(i) == 'I') {
//                result = result + map.get('I');
//            }else if (input.length() == 2 && input.charAt(0) == 'I' && input.charAt(1) == 'V'){
//                result = 4;
//
//            }else if (input.length() == 2 && input.charAt(0) == 'I' && input.charAt(1) == 'X'){
//                result = 9;
//
//            } else if (input.length() == 3 && input.charAt(0) == 'X' && input.charAt(1) == 'I' && input.charAt(2) == 'V'){
//                result = 14;
//
//            } else if (input.length() == 3 && input.charAt(0) == 'X' && input.charAt(1) == 'I' && input.charAt(2) == 'X'){
//                result = 19;
//
//            } else if (input.length() == 4 && input.charAt(0) == 'X' && input.charAt(1) == 'X' && input.charAt(2) == 'I' && input.charAt(3) == 'V'){
//                result = 24;
//
//            } else if (input.length() == 4 && input.charAt(0) == 'X' && input.charAt(1) == 'X' && input.charAt(2) == 'I' && input.charAt(3) == 'X'){
//                result = 29;
//
//            } else if (input.length() == 5 && input.charAt(0) == 'X' && input.charAt(1) == 'X' && input.charAt(2) == 'X' && input.charAt(3) == 'I' && input.charAt(4) == 'V'){
//                result = 34;
//
//            } else if (input.length() == 5 && input.charAt(0) == 'X' && input.charAt(1) == 'X' && input.charAt(2) == 'X' && input.charAt(3) == 'I' && input.charAt(4) == 'X'){
//                result = 39;
//
//
//            } else if (input.charAt(i) == 'V') {
//                result = result + 5;
//
//            }else if (input.charAt(i) == 'X'){
//                result = result + 10;
//
//            }else if (input.charAt(i) == 'L'){
//                result = result + 50;
//
//            }
        }
        return result;

    }

}
