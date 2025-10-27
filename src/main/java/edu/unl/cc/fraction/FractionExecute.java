/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.fraction;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author luisr
 */
public class FractionExecute {

    public static Fraction readFraction(Scanner sc) {
        while (true) {
            try {
                System.out.print("Numerador: ");
                int numerator = sc.nextInt();

                System.out.print("Denominador: ");
                int denominator = sc.nextInt();

                return new Fraction(numerator, denominator);

            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar números enteros.");
                sc.nextLine();

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("PROGRAMA DE FRACCIONES");
        System.out.println("Ingrese la primera fracción:");
        Fraction f1 = readFraction(sc);
        System.out.println("Ingrese la segunda fracción:");
        Fraction f2 = readFraction(sc);

        System.out.println("Fracción 1: " + f1.showFraction() + " = " + f1.decimalFraction());
        System.out.println("Fracción 2: " + f2.showFraction() + " = " + f2.decimalFraction());

        System.out.println("Suma: " + f1.getAdition(f2).showFraction());
        System.out.println("Resta: " + f1.getSubtraction(f2).showFraction());
        System.out.println("Multiplicación: " + f1.getMultiplication(f2).showFraction());
        System.out.println("División: " + f1.getDivision(f2).showFraction());
        System.out.println("La primer fraccion invertida es: " + f1.invertFraction().showFraction());
        System.out.println("La segunda fraccion invertida es: " + f2.invertFraction().showFraction());
        System.out.println("La primer fracción simplificada es: " + f1.getSimplification());
        System.out.println("La segunda fracción simplificada es: " + f2.getSimplification());

        sc.close();
    }

}
