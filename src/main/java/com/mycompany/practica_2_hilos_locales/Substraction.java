/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_2_hilos_locales;
import java.util.Scanner;

/**
 *
 * @author almal
 */
public class Substraction extends Thread{
    int x, y;
    int ans = 0;

    public Substraction(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public void run() {
        System.out.println("The result of the substraction is:"+(x-y));
    }
    
}