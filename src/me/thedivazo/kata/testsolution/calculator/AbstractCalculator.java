package me.thedivazo.kata.testsolution.calculator;

import java.util.regex.Pattern;

public abstract class AbstractCalculator {
    protected Pattern pattern;
    public AbstractCalculator(Pattern pattern) {
        this.pattern = pattern;
    }
    public boolean isLegalExpression(String input) {
        return pattern.matcher(input).matches();
    }
    protected abstract Expression getExpression(String input);
    protected abstract String convertNumber(int number);
    public String calc(String input) {
        Expression expression = getExpression(input);
        return switch (expression.operator()) {
            case PLUS -> convertNumber(expression.firstArgument()+expression.secondArgument());
            case MINUS -> convertNumber(expression.firstArgument()-expression.secondArgument());
            case MULTI -> convertNumber(expression.firstArgument()*expression.secondArgument());
            case DIV -> convertNumber(expression.firstArgument()/expression.secondArgument());
        };
    }
}
