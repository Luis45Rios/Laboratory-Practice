/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.fraction;

/**
 *
 * @author luisr
 */
public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero. Ingrese nuevamente la fracción");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String showFraction() {
        return numerator + "/" + denominator;
    }

    public String decimalFraction() {
        double resultado = (double) numerator / denominator;
        return String.format("%.2f", resultado);
    }

    public Fraction getAdition(Fraction newFraction) {
        int num1 = this.numerator * newFraction.denominator + newFraction.numerator * this.denominator;
        int den1 = this.denominator * newFraction.denominator;
        return new Fraction(num1, den1);
    }

    public Fraction getSubtraction(Fraction newFraction) {
        int num1 = this.numerator * newFraction.denominator - newFraction.numerator * this.denominator;
        int den1 = this.denominator * newFraction.denominator;
        return new Fraction(num1, den1);
    }

    public Fraction getMultiplication(Fraction newFraction) {
        int num1 = this.numerator * newFraction.numerator;
        int den1 = this.denominator * newFraction.denominator;
        return new Fraction(num1, den1);
    }

    public Fraction getDivision(Fraction newFraction) {
        if (newFraction.numerator == 0) {
            throw new IllegalArgumentException("No se puede dividir para una fracción con numerador 0");
        }
        int num1 = this.numerator * newFraction.denominator;
        int den1 = this.denominator * newFraction.numerator;
        return new Fraction(num1, den1);
    }

    public Fraction invertFraction() {
        if (numerator == 0) {
            throw new IllegalArgumentException("No se puede invertir si el numerador es cero");
        }
        return new Fraction(denominator, numerator);
    }

    private int calculateMCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }

    public Fraction getSimplification() {
        int mcd = calculateMCD(numerator, denominator);
        int numSimplificado = numerator / mcd;
        int denSimplificado = denominator / mcd;
        return new Fraction(numSimplificado, denSimplificado);
    }

    public int getNumerador() {
        return numerator;
    }

    public void setNumerador(int numerador) {
        this.numerator = numerador;
    }

    public int getDenominador() {
        return denominator;
    }

    public void setDenominador(int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero. Ingrese nuevamente la fracción");
        }
        this.denominator = denominador;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    
    }
}
