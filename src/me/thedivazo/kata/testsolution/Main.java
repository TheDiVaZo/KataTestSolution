package me.thedivazo.kata.testsolution;

import me.thedivazo.kata.testsolution.calculator.ArabianCalc;
import me.thedivazo.kata.testsolution.calculator.RomanCalc;

import java.util.Scanner;

public class Main {
    private static ArabianCalc arabianCalc = new ArabianCalc();
    private static RomanCalc romanCalc = new RomanCalc();
    public static void main(String[] args) {

    }
    public static String calc(String input) {
        if (arabianCalc.isLegalExpression(input)) return calc(input);
        else if (romanCalc.isLegalExpression(input)) return romanCalc.calc(input);
        throw new IllegalArgumentException("Выражение неккоректно");
    }
}