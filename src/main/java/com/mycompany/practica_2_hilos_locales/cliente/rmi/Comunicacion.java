package com.mycompany.cliente.rmi;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Comunicacion implements ComunicacionInterface{

    private String operation;
    private String host;
    private int port;
    private Socket s;
    private PrintWriter os;

    public Comunicacion(String operation){
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("server.properties"));
            
            if(operation.equals("Suma") || operation.equals("Resta")){
                host = properties.getProperty("hostSumaResta");
                port = Integer.parseInt(properties.getProperty("portSumaResta"));
            }else if(operation.equals("Multiplicacion") || operation.equals("Division")){
                host = properties.getProperty("hostMultiDivi");
                port = Integer.parseInt(properties.getProperty("portMultiDivi"));
            }

        } catch (Exception e) {
            System.out.println("Propiedades no encontradas");
        }
    }

    public static boolean validaOperacion(String operacion){

        return operacion.equals("Suma") || operacion.equals("Resta") || operacion.equals("Multiplicacion") || operacion.equals("Division");
    }

    @Override
    public void enviaDatos(String datos) throws RemoteException {
        try {
            connect();
        } catch (IOException ex) {
            Logger.getLogger(Comunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(s != null && os != null){
            try {
                os.println(datos);
                os.flush();
            } catch (Exception e) {
                System.err.println("I/O Fallo al leer /escribir socket");
                throw new java.rmi.RemoteException("I/O failed in reading/writing socket");
            }
        }

        try{
            disconnect();
        }
        catch(IOException ex){
            Logger.getLogger(Comunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private synchronized void connect() throws java.rmi.RemoteException, IOException{
        s = new Socket(host, port);
        os = new PrintWriter(s.getOutputStream());
    }

    private synchronized void disconnect() throws java.rmi.RemoteException, IOException{
        os.close();
        s.close();
    }
}
