package com.mycompany.cliente;

import java.rmi.RemoteException;
import java.util.Scanner;

import com.mycompany.cliente.rmi.Comunicacion;

public class MaquinaA {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String entrada = "";
        String operacion = "";
        boolean validado = false;
        int [] numeros = new int[2];
        do{

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

            
            Comunicacion comunicacion = new Comunicacion(operacion);
            try{
                comunicacion.enviaDatos(entrada);
                System.out.println("Datos Enviados");
            }
            catch(RemoteException ex){
                ex.printStackTrace();
            }
            
            System.out.println("¿Quiere hacer otra operación? (Introduzca cualquier caracter para continuar o escriba 'Salir')");
            entrada = scanner.nextLine();

        }
        while(entrada.equals("Salir"));

    }

    
}
