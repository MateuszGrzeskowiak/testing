package pl.sda.mg;

public class Converter {

    public int valueOfSingleRoman(char singleRoman) {
        int result = 0;
        if (singleRoman == 'I') {
            result = 1;
        }
        if (singleRoman == 'V') {
            result = 5;
        }
        if (singleRoman == 'X') {
            result = 10;
        }
        if (singleRoman == 'L') {
            result = 50;
        }
        if (singleRoman == 'C') {
            result = 100;
        }
        if (singleRoman == 'D') {
            result = 500;
        }
        if (singleRoman == 'M') {
            result = 1000;
        }
        return result;
    }

    public int convertRomanToArabic(String RomanNumber) {
        char[] chars = RomanNumber.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            char current = chars[i];
            char next = chars[i + 1];
            int currentValue = valueOfSingleRoman(current);
            int nextValue = valueOfSingleRoman(next);
            if (currentValue >= nextValue) {
                sum = sum + valueOfSingleRoman(current);
            } else {
                sum = sum - valueOfSingleRoman(current);
            }
        }
        return sum + valueOfSingleRoman(chars[chars.length - 1]);
    }
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
