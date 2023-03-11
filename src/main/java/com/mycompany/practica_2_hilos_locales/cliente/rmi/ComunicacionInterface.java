package com.mycompany.practica_2_hilos_locales.cliente.rmi;

public interface ComunicacionInterface extends java.rmi.Remote{
    public void enviaDatos(String datos) throws java.rmi.RemoteException;
}
