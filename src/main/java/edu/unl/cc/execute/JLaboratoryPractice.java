/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.unl.cc.execute;

import edu.unl.cc.Quadratic_Equation.QuadraticEquationExecute;
import edu.unl.cc.account_bank.Bank_Execute;
import edu.unl.cc.electronic_lock.ElectronicLockExecute;
import edu.unl.cc.fraction.FractionExecute;
import java.util.Scanner;

/**
 *
 * @author luisr
 */
public class JLaboratoryPractice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=====Practica de Laboratorio=====\n");
        System.out.println("Seleccione una opcion: ");
        System.out.println("\n1.    Cerradura Electronica");
        System.out.println("2.  Cuenta Bancaria");
        System.out.println("3.  Ecuacion Cuadratica");
        System.out.println("4.  Fraccion");
        
        int opc = scanner.nextInt();
        
        switch (opc) {
            case 1:
                ElectronicLockExecute.main(args);
                break;
                
            case 2:
                Bank_Execute.main(args);
                
            case 3:
                QuadraticEquationExecute.main(args);
                
            case 4:
                FractionExecute.main(args);
            default:
                throw new AssertionError();
        }
    }
}
