package me.thedivazo.kata.testsolution.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArabianCalc extends AbstractCalculator {
    public ArabianCalc() {
        super(Pattern.compile("(^10|[1-9])\\s(\\+|\\-|\\*|\\/)\\s(10|[1-9]$)"));
    }

    @Override
    protected Expression getExpression(String input) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) throw new IllegalArgumentException("Аргумент должен быть корректным");
        return new Expression(
                Integer.parseInt(matcher.group(1)),
                Operator.get(matcher.group(2)),
                Integer.parseInt(matcher.group(3)));
    }

    @Override
    protected String convertNumber(int number) {
        return String.valueOf(number);
    }
}
