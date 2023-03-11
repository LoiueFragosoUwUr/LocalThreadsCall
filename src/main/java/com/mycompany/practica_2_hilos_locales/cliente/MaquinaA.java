package com.mycompany.practica_2_hilos_locales.cliente;

import java.rmi.RemoteException;
import java.util.Scanner;

import com.mycompany.practica_2_hilos_locales.cliente.rmi.Comunicacion;
import com.mycompany.practica_2_hilos_locales.threads.Addition;
import com.mycompany.practica_2_hilos_locales.threads.Division;
import com.mycompany.practica_2_hilos_locales.threads.Multiplication;

public class MaquinaA {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String entrada = "";
        String operacion = "";
        char opcion = ' ';
        boolean validado = false;
        int [] numeros = new int[2];
        do{
            System.out.println("¿Cómo quiere ejecutar su código?");
            System.out.println("a. Forma local");
            System.out.println("b. Forma remota");

            opcion = scanner.nextLine().charAt(0);

            System.out.println("Ingrese una operación a realizar y dos dígitos separados por un espacio: (Suma, Resta, Multiplicacion o Division)");
                entrada = scanner.nextLine();
                String [] datos = entrada.split(" ");
                do{
                    if(datos.length == 3){
                        for(int i = 0; i < 3; i++){
                            if(i ==0){
                                operacion = datos[i];
                                validado = Comunicacion.validaOperacion(operacion);
                                System.out.println("Entra");
                                if(!validado){
                                    System.out.println("Debe colocar una operación válida");
                                    break;
                                }                       
                            }
                            else{
                                try{
                                    numeros[i-1] = Integer.parseInt(datos[i]);
                                }
                                catch(Exception ex){
                                    System.out.println("Los datos deben ser numeros");
                                    validado = false;
                                    break;
                                }
                                
                            }
                        }
                    }
                    else{
                        System.out.println("Solo deben ser 3 argumentos");
                    }
                }
                while(!validado);

            if(opcion == 'a'){

                if(operacion.equals("Suma")){
                    Addition addition = new Addition(numeros[0], numeros[1]);
                    addition.start();
                    try{
                        addition.join();
                    }
                    catch(Exception ex){

                    }
                }else if(operacion.equals("Resta")){
                    Addition addition = new Addition(numeros[0], -numeros[1]);
                    addition.start();
                    try{
                        addition.join();
                    }
                    catch(Exception ex){
                        
                    }
                } else if(operacion.equals("Multiplicacion")){
                    Multiplication multi = new Multiplication(numeros[0], numeros [1]);
                    multi.start();
                    try{
                        multi.join();
                    }
                    catch(Exception ex){
                        
                    }
                } else if(operacion.equals("Division")){
                    Division divi = new Division(numeros[0], numeros [1]);
                    divi.start();
                    try{
                        divi.join();
                    }
                    catch(Exception ex){
                        
                    }
                }

            }
            else if(opcion == 'b'){
                Comunicacion comunicacion = new Comunicacion(operacion);
                try{
                    comunicacion.enviaDatos(entrada);
                    System.out.println("Datos Enviados");
                }
                catch(RemoteException ex){
                    ex.printStackTrace();
                }
            }

            
            
            System.out.println("¿Quiere hacer otra operación? (Introduzca cualquier caracter para continuar o escriba 'Salir')");
            entrada = scanner.nextLine();

        }
        while(!entrada.equals("Salir"));

    }

    
}
