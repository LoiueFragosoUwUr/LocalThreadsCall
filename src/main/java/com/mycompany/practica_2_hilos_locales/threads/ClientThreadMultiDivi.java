/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.practica_2_hilos_locales.threads;

import com.mycompany.practica_2_hilos_locales.hiddenfunctions.HiddenFunctionDivision;
import com.mycompany.practica_2_hilos_locales.hiddenfunctions.HiddenFunctions;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author almal
 */
public class ClientThreadMultiDivi extends Thread {
    private Socket socket;
    public ClientThreadMultiDivi (Socket socket){
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
        HiddenFunctionDivision ptt = new HiddenFunctionDivision();
        OutPutInteger = ptt.ReturnsDivisionResult(0,0);
        HiddenFunctions ptt2 = new HiddenFunctions();
        OutPutInteger = ptt2.ReturnsMultiplicationResult(0,0);
        EscritorSalida.println(FinalInteger);
        System.out.println(" Please type any character or string to proceed ");
        System.out.println(" Otherwise to exit you have to type zero twice");
        String Entrada=LectorEntrada.readLine();
    
          String datos [] = Entrada.split(" ");        
          InPutInteger=Integer.parseInt(datos[1]);
          InPutInteger_2=Integer.parseInt(datos[2]);
          
          if(datos[0].equals("Multiplicacion")){
               OutPutInteger = ptt2.ReturnsMultiplicationResult(InPutInteger,InPutInteger_2);
               System.out.println("The result of the multiplication is "+OutPutInteger);
          }else if(datos[0].equals("Division")){
                 OutPutInteger = ptt.ReturnsDivisionResult(InPutInteger,InPutInteger_2);
                 System.out.println("The result of the division is "+OutPutInteger);    
          }
        EscritorSalida.close();
        LectorEntrada.close();
        socket.close();
        }catch(Exception ex){
          ex.printStackTrace();
        }
    }
}
