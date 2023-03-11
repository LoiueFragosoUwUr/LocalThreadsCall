package com.mycompany.practica_2_hilos_locales.hiddenfunctions;
import java.net.*;
import java.io.*;
/**
 *
 * @author almal
 */
public class HiddenFunctionSubstraction {
    
    public int ReturnsSubstractionResult (int ReceivedInteger,int ReceivedInteger_2){
        int Result=0;// gives a location within the memory
        Result=ReceivedInteger-ReceivedInteger_2;
        return Result;
    }
}


