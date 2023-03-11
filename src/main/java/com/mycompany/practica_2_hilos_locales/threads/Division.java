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
public class Division extends Thread{
    int x, y;
    float ans;

    public Division(int x, int y) {
        this.x = x;
        this.y = y;
        this.ans =(float)x/y;
        // floatValue of the Float Object
    }

    @Override
    public void run() {
        System.out.println("The result of the division is: "+ans);
    }

}
