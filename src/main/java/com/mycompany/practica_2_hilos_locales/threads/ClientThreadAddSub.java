/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.practica_2_hilos_locales.threads;

import com.mycompany.practica_2_hilos_locales.hiddenfunctions.HiddenFunctionAddition;
import com.mycompany.practica_2_hilos_locales.hiddenfunctions.HiddenFunctionSubstraction;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author almal
 */
public class ClientThreadAddSub extends Thread {
    private Socket socket;
    public ClientThreadAddSub (Socket socket){
        this.socket=socket;
        
    }
    
    @Override
    public void run(){
        try{
        PrintWriter EscritorSalida = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader LectorEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int FinalInteger=0;
        int InPutInteger,InPutInteger_2;
        float OutPutInteger;
        HiddenFunctionSubstraction ptt = new HiddenFunctionSubstraction();
        OutPutInteger = ptt.ReturnsSubstractionResult(0,0);
        HiddenFunctionAddition ptt2 = new HiddenFunctionAddition();
        OutPutInteger = ptt2.ReturnsAdditionResult(0,0);
        EscritorSalida.println(FinalInteger);
        System.out.println(" Please type any character or string to proceed ");
        System.out.println(" Otherwise to exit you have to type zero twice");
        String Entrada=LectorEntrada.readLine();
                

          String datos [] = Entrada.split(" ");        
        InPutInteger=Integer.parseInt(datos[1]);
        InPutInteger_2=Integer.parseInt(datos[2]);
             
        if(datos[0].equals("Suma")){
               OutPutInteger = ptt2.ReturnsAdditionResult(InPutInteger,InPutInteger_2);
               System.out.println("The result of the addition is "+OutPutInteger);
          }else if(datos[0].equals("Resta")){
                 OutPutInteger = ptt.ReturnsSubstractionResult(InPutInteger,InPutInteger_2);
                 System.out.println("The result of the substraction is "+OutPutInteger);    
          }
        
        EscritorSalida.close();
        LectorEntrada.close();
        socket.close();
        }catch(Exception ex){
          ex.printStackTrace();
        }
    }
}
