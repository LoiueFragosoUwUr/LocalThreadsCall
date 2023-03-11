package com.mycompany.practica_2_hilos_locales.servers;

import com.mycompany.practica_2_hilos_locales.threads.ClientThreadMultiDivi;
import java.io.*;
import java.net.*;

/**
 *
 * @author almal
 */
public class ServerSocketMultiDivi {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("No puedo escuchar en el puerto: 4444.");
            System.exit(1); // cerrar y avisar al sistema operativo que terminamos con estatus de 0
        }
        while(1==1){
        
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println(" se conceta un cliente ");
        } catch (IOException e) {
            System.err.println("Fallo al aceptar la peticion.");
            System.exit(1);
        }
        ClientThreadMultiDivi nuevo = new ClientThreadMultiDivi(clientSocket);
        nuevo.start();
        }
    }
}
