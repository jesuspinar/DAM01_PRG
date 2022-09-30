package com.programacionOO.tema14.practica02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private final int BACKLOG = 3; // max num of request queue

    public EchoServer(int port){

        try {
            boolean done = false;
            ServerSocket socketServidor = new ServerSocket(port); //localhost by default
            Socket recepcion = socketServidor.accept();
            BufferedReader in=new BufferedReader(new InputStreamReader(recepcion.getInputStream()));
            PrintWriter out = new PrintWriter(recepcion.getOutputStream(),true);

            out.println("Hola! Introduzca ADIOS para salir");

            while(!done) {
                String linea = in.readLine();

                if (linea.trim().equals("ADIOS")){
                    done = true;
                }else {
                    out.println("Try again");
                }
            }
            recepcion.close();
        } catch (IOException ioException) {
            ioException.printStackTrace(); }

    }

}
