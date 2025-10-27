/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.Quadratic_Equation;

/**
 *
 * @author luisr
 */
public class QuadraticEquation {

    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("El coeficiente 'a' no puede ser 0");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String showEquation() {
        return a + "x^2 + " + b + "x + " + c + " = 0";
    }

    public double calculateDiscriminant() {
        return (b * b) - (4 * a * c);
    }

    public double getPositiveRoot() {
        return (-b + Math.sqrt(calculateDiscriminant())) / (2 * a);

    }

    public double getNegativeRoot() {
        return (-b - Math.sqrt(calculateDiscriminant())) / (2 * a);
    }

    public double getA() {
        if (a == 0) {
            throw new IllegalArgumentException("El coeficiente a no puede ser 0");
        }
        return a;
    }

    public void setA(double a) {
        if (a == 0) {
            throw new IllegalArgumentException("El coeficiente a no puede ser 0");
        }
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
