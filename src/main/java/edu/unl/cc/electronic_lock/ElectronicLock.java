/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.electronic_lock;

/**
 *
 * @author luisr
 */
public class ElectronicLock {

    private Integer configuredKey;
    private int failedAttempts;
    private boolean closed;

    public ElectronicLock() {
        this.configuredKey = null;
        this.failedAttempts = 0;
        this.closed = false;
    }

    //Configuarar clave de 4 dígitos 
    public boolean configuredKey(Integer newKey) {
        if (newKey == null || newKey < 1000 || newKey > 9999) {
            System.out.println("Error: La clave debe tener 4 digitos");
            return false;
        }
        this.configuredKey = newKey;
        System.out.println("Clave configurada exitosamente");
        return true;
    }

    public Integer getConfiguredKey() {
        return configuredKey;
    }

    // Validar clave ingresada 
    public boolean validateKey(Integer keyEntered) {

        if (closed) {
            System.out.println("CERRADURA BLOQUEADA. No se permiten mas intentos.");
            return false;
        }

        if (configuredKey == null) {
            System.out.println("No hay clave configurada.Configure una primero.");
            return false;
        }

        if (keyEntered == null || keyEntered < 1000 || keyEntered > 9999) {
            System.out.println("Clave invalida. Debe ser de 4 digitos.");
            return false;
        }

        // Verificar si la clave es correcta 
        if (keyEntered.equals(configuredKey)) {
            System.out.println("CLAVE CORRECTA. Cerradura abierta.");
            failedAttempts = 0; // Resetear intentos
            return true;
        } else {
            failedAttempts++;
            int attemptsAvailable = 3 - failedAttempts;

            if (attemptsAvailable > 0) {
                System.out.println("Clave incorrecta. Intentos restantes: " + attemptsAvailable);
            } else {
                closed = true;
                System.out.println("CERRADURA BLOQUEADA por multiples intentos fallidos.");
            }
            return false;
        }
    }

    public void setConfiguredKey(Integer claveActual) {
        this.configuredKey = configuredKey;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int intentosFallidos) {
        this.failedAttempts = failedAttempts;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean bloqueada) {
        this.closed = closed;
    }
}
