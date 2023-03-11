/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_2_hilos_locales.threads;
import java.util.Scanner;
/**
 *
 * @author almal
 */
public class Multiplication extends Thread{
    int x, y;
    int ans = 0;

    public Multiplication(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public void run() {
        System.out.println("The result of the multiplication is:"+(x*y));
    }
    
}
