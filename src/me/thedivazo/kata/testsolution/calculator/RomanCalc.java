package me.thedivazo.kata.testsolution.calculator;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanCalc extends AbstractCalculator {
    private static final TreeMap<Integer, String> romanNumbers = new TreeMap<>();
    static {
        romanNumbers.put(1000, "M");
        romanNumbers.put(900, "CM");
        romanNumbers.put(500, "D");
        romanNumbers.put(400, "CD");
        romanNumbers.put(100, "C");
        romanNumbers.put(90, "XC");
        romanNumbers.put(50, "L");
        romanNumbers.put(40, "XL");
        romanNumbers.put(10, "X");
        romanNumbers.put(9, "IX");
        romanNumbers.put(5, "V");
        romanNumbers.put(4, "IV");
        romanNumbers.put(1, "I");
    }

    public RomanCalc() {
        super(Pattern.compile("(^III|II|IX|IV|I|VIII|VII|VI|V|X)\\s(\\+|\\-|\\*|\\/)\\s(III|II|IX|IV|I|VIII|VII|VI|V|X$)"));
    }

    @Override
    protected Expression getExpression(String input) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) throw new IllegalArgumentException("Аргумент должен быть корректным");
        return new Expression(
                convertNumber(matcher.group(1)),
                Operator.get(matcher.group(2)),
                convertNumber(matcher.group(3)));
    }

    protected int convertNumber(String number) {
        int result = 0;
        boolean isAllNumberIteratedFlag = false;
        while (!isAllNumberIteratedFlag && !number.isEmpty()) {
            isAllNumberIteratedFlag = true;
            for (Map.Entry<Integer, String> entry : romanNumbers.entrySet()) {
                int arabianNumber = entry.getKey();
                String romanNumber = entry.getValue();
                if (number.startsWith(romanNumber)) {
                    number = number.substring(romanNumber.length());
                    result+=arabianNumber;
                    isAllNumberIteratedFlag = false;
                    break;
                }
            }
        }
        if (isAllNumberIteratedFlag) throw new IllegalArgumentException("Ошибка конвертации");
        return  result;

    }

    @Override
    protected String convertNumber(int number) {
        if (number < 1) throw new IllegalArgumentException("Римские числа не должны быть меньше еденицы");
        int l =  romanNumbers.floorKey(number);
        if ( number == l ) {
            return romanNumbers.get(number);
        }
        return romanNumbers.get(l) + convertNumber(number-l);
    }
}
