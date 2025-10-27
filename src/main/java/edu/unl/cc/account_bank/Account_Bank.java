/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.account_bank;

/**
 *
 * @author luisr
 */
public class Account_Bank {
    
    // ATRIBUTOS
    private String account_number;
    private String name_holder;
    private Float balance;
    private String[] history;
    private int count;
    
    // METODOS
    // Constructor 
    public Account_Bank(String account_number, String name_holder, float balance) {
        this.account_number = account_number;
        this.name_holder = name_holder;
        this.balance = balance;
        this.history = new String[200];
        this.count = 0;
    }

    // Depositar dinero
    public void deposit(Float amount) {
        if (verify_amount(amount)) {
            balance += amount;
            recordMovement("Depósito: +$" + amount);
            System.out.println("Depósito realizado. Nuevo saldo: $" + balance);
        } else {
            System.out.println("Monto inválido, debe ser positivo.");
        }
    }

    // Retirar dinero
    public void withdraw(Float amount) {
        if (verify_withdraw(amount)) {
            balance -= amount;
            recordMovement("Retiro: -$" + amount);
            System.out.println("Retiro realizado. Nuevo saldo: $" + balance);
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }

    // REGISTAR EL MOVIMIENTO
    public String recordMovement(String movement) {
        if (count < history.length) {
            history[count] = movement;
            count++;
            return "Movimiento registrado";
        } else {
            return "El historial esta lleno, no se podra registrar mas movimientos";
        }
    }

    // MOSTAR EL HISTORIAL
    public void showHistory() {
        System.out.println("\n=== HISTORIAL DE TRANSACCIONES ===");
        if (count == 0) {
            System.out.println("No hay transacciones registradas.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + history[i]);
            }
        }
    }

    // VERIFICAR EL MONTO DEL DOPOSITO ES VALIDO
    private boolean verify_amount(Float amount) {
        return amount > 0;
    }

    // VERIFICAR SI EL RETIRO ES POSIBLE
    private boolean verify_withdraw(Float amount) {
        return amount <= balance && amount > 0;
    }

    // GETTERS
    public String get_account_number() {
        return account_number;
    }

    public String get_name_holder() {
        return name_holder;
    }

    public Float getBalance() {
        return balance;
    }

    // SETTER
    public void setBalance(Float balance) {
        this.balance = balance;
    }

    // MOSTRAR INFORMACION
    public void showInfo() {
        System.out.println("Número de cuenta: " + account_number);
        System.out.println("Titular: " + name_holder);
        System.out.println("Saldo: $" + balance);
    }

}
