package me.thedivazo.kata.testsolution.calculator;

public record Expression(
        int firstArgument,
        Operator operator,
        int secondArgument
) {}
