package com.example.euclidalgorithm;

import java.util.ArrayList;

public class EuclidsAlgorithm {
    private ArrayList<String> listOfExpressions;

    public EuclidsAlgorithm() {
        listOfExpressions = new ArrayList<>();
    }

    private int calculateGCD(Fraction fraction) {
        int remainder = 1;
        int numerator = fraction.getNumerator();
        int denominator = fraction.getDenominator();

        while (remainder > 0) {
            remainder = denominator % numerator;
            listOfExpressions.add(String.format("%d = %d (mod %d)",
                    denominator, remainder, numerator));

            if (remainder != 0) {
                denominator = numerator;
                numerator = remainder ;
            }
        }

        return numerator;
    }

    public Fraction getReducedForm(Fraction fraction) {
        int gcd = calculateGCD(fraction);
        int numerator = fraction.getNumerator() / gcd;
        int denominator = fraction.getDenominator() / gcd;

        return new Fraction(numerator, denominator);
    }

    public ArrayList<String> getListOfExpressions() {
        return listOfExpressions;
    }

    public void clearListOfExpressions() {
        listOfExpressions.clear();
    }

    @Override
    public String toString() {
        StringBuilder finalResult = new StringBuilder();

        for (String expression : getListOfExpressions()) {
              finalResult.append(expression).append("\n");
        }

        return finalResult.toString();
    }
}
