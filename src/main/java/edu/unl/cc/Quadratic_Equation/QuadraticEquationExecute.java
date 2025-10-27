/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.Quadratic_Equation;

import java.util.Scanner;

/**
 *
 * @author luisr
 */
public class QuadraticEquationExecute {
    public static QuadraticEquation readEquation(Scanner sc) {
        QuadraticEquation equation;
        while (true) {
            try {
                System.out.println("Ingresando coeficientes para la ecuación cuadrática");
                System.out.print("Ingrese a: ");
                double a = sc.nextDouble();
                System.out.print("Ingrese b: ");
                double b = sc.nextDouble();
                System.out.print("Ingrese c: ");
                double c = sc.nextDouble();

                equation = new QuadraticEquation(a, b, c);
                break;

            } catch (Exception e) {
                sc.nextLine();
                System.out.println(e.getMessage());
                System.out.println("Ingrese nuevamente los valores");
            }
        }
        return equation;
    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuadraticEquation equation = null;
        int opcion;
        System.out.println("PROGRAMA PARA RESOLVER ECUACIONES CUADRÁTICAS");
        do {
            System.out.println("----------MENÚ PARA EJERCICIO: ECUACIÓN CUADRÁTICA----------");
            System.out.println("1. Ingresar coeficientes a, b, c");
            System.out.println("2. Mostrar ecuación");
            System.out.println("3. Calcular raíces");
            System.out.println("4. Salir");
            System.out.print("Digite el número de la opción que desee: ");
            System.out.println("");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    equation = readEquation(sc);
                    System.out.println("Coeficientes ingresados correctamente");
                    break;

                case 2:
                    if (equation != null) {
                        System.out.println("Ecuación: " + equation.showEquation());
                    } else {
                        System.out.println("Primero ingrese los coeficientes.");
                    }
                    break;

                case 3:
                    if (equation != null) {
                        System.out.println("X1: " + equation.getPositiveRoot());
                        System.out.println("X2: " + equation.getNegativeRoot());
                    } else {
                        System.out.println("Primero ingrese los coeficientes.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente otra vez.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
