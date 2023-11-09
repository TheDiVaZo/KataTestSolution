package me.thedivazo.kata.testsolution.calculator;

public enum Operator {
    MINUS,
    PLUS,
    MULTI,
    DIV;

    public static Operator get(String operator) {
        switch (operator) {
            case "+": return PLUS;
            case "-": return MINUS;
            case "*": return MULTI;
            case "/": return DIV;
            default: throw new IllegalArgumentException("Такой оператор не поддерживается");
        }
    }
}
