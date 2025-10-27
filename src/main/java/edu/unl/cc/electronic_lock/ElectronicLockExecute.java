/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.electronic_lock;

import java.util.Scanner;

/**
 *
 * @author luisr
 */
public class ElectronicLockExecute {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElectronicLock lock = new ElectronicLock();
        System.out.println("Sistema de cerradura electronica");

        // Configurarar clave 
        System.out.println("PASO 1: Configurar clave");
        System.out.print("Ingrese una clave de 4 digitos: ");

        boolean configuredkey = false;

        while (!configuredkey) {
            Integer clave = sc.nextInt();

            if (lock.configuredKey(clave)) {
                configuredkey = true;
            } else {
                System.out.println("Por favor, intente nuevamente");
            }
        }
        //Abrir cerradura 
        System.out.println("PASO 2: Validar clave");

        while (!lock.isClosed()) {
            System.out.print("Ingrese la clave para abrir: ");
            Integer intento = sc.nextInt();

            if (lock.validateKey(intento)) {
                break; // Clave correcta, salir del bucle
            }
        }
        System.out.println("Intentos fallidos: " + lock.getFailedAttempts());
    }
}
