/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.account_bank;

import java.util.Scanner;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author luisr
 */
public class Bank_Execute {

    public static Account_Bank createAccount(Scanner scanner) {
        System.out.println("Ingrese el numero de cuenta: ");
        String account_number = scanner.next();

        System.out.println("Ingrese el nombre del titular: ");
        String name_holder = scanner.next();

        Float balance = 0f;

        return new Account_Bank(account_number, name_holder, balance);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account_Bank account = null;

        int opc;

        do {
            System.out.println("\n BIENVENIDO A NUESTRO BANCO \n");
            System.out.println("Seleccione una opción:");
            System.out.println("1.\tCrear cuenta");
            System.out.println("2.\tDspositar");
            System.out.println("3.\tRetirar");
            System.out.println("4.\tConsultar saldo");
            System.out.println("5.\tInformación de la cuenta");
            System.out.println("6.\tVer historial de transacciones");
            System.out.println("7.\tSalir");
            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    if (account == null) {
                        account = createAccount(scanner);
                        System.out.println("\nCuenta creada con éxito. Saldo inicial: $0.0");
                    } else {
                        System.out.println("\nYa existe una cuenta creada. No puede crear otra sin reiniciar el programa.");
                    }
                    break;

                case 2:
                    if (account != null) {
                        System.out.println("Ingrese un monto a depositar: ");
                        Float amount = scanner.nextFloat();
                        account.deposit(amount);
                    } else {
                        System.out.println("Primero debe crear una cuenta...");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.println("Ingrese el monto a retitrar: ");
                        Float amount = scanner.nextFloat();
                        account.withdraw(amount);
                    } else {
                        System.out.println("Primero debe crear una cuenta...");
                    }
                    break;

                case 4:
                    if (account != null) {
                        System.out.println("Su saldo es de: " + account.getBalance());
                    } else {
                        System.out.println("No existe una cuenta...");
                    }
                    break;

                case 5:
                    if (account != null) {
                        System.out.println("Número de la cuenta: " + account.get_account_number());
                        System.out.println("Nombre del titular: " + account.get_name_holder());
                        System.out.println("Saldo: " + account.getBalance());
                    } else {
                        System.out.println("No existe una cuenta...");
                    }
                    break;

                case 6:
                    if (account != null) {
                        account.showHistory();
                    } else {
                        System.out.println("Pimero debe crear una cuenta");
                    }
                    break;

                case 7:
                    System.out.println("Gracias por utilizar este sistema bancario.");
                    break;

                default:
                    System.out.println("Ingrese una opcion valida...");
                    break;
            }
        } while (opc != 7);
        scanner.close();
    }
}
