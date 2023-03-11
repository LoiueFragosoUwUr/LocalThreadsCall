package com.mycompany.practica_2_hilos_locales.hiddenfunctions;
import java.net.*;
import java.io.*;
/**
 *
 * @author almal
 */
public class HiddenFunctionDivision {
    
    public float ReturnsDivisionResult (int ReceivedInteger,int ReceivedInteger_2){
        float Result=0;// gives a location within the memory
        Result=(float)ReceivedInteger/ReceivedInteger_2;
        return Result;
    }
}


