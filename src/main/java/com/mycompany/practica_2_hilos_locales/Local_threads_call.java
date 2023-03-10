/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.practica_2_hilos_locales;

import java.util.Scanner;

/**
 *
 * @author almal
 */
public class Local_threads_call {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        /*primarily we should have created the threads that contain the functions*/
        System.out.println("Please enter two integers ");
        /*Consequently we should create the previous mentioned threads which trigger the mathematical
                operations*/
        a = sc.nextInt();
        b = sc.nextInt();
        Addition addition = new Addition(a, b);
        addition.start();
        Substraction substraction = new Substraction(a, b);
        substraction.start();
        Multiplication multiplication = new Multiplication(a, b);
        multiplication.start();
        Division division = new Division(a, b);
        division.start();
    }
}
