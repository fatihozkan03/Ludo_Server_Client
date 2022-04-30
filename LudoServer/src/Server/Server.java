/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import game.Message;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ozkan
 */
//clientın gelişini dinleme threadi
class ServerThread extends Thread {

    public void run() {
        //server kapanmadığı sürece dinle
        while (!Server.serverSocket.isClosed()) {
            try {
                Server.Display("Client Bekleniyor...");
                // bir client gelene kadar beklenir
                Socket clientSocket = Server.serverSocket.accept();
                //client geldi
                Server.Display("Client Geldi...");
                //client soketinden bir sclient nesnesi oluşturuldu.
                SClient nclient = new SClient(clientSocket, Server.IdClient);
                
                Server.IdClient++; // ID verildi
               
                Server.Clients.add(nclient); //Client listeye eklendi.
                
                nclient.listenThread.start(); //client mesaj dinlenmesi başlatıldı

            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class Server {

    public static ServerSocket serverSocket;//server soketi eklendi.
    
    public static int IdClient = 0; 
    
    public static int port = 0;// Serverın dinlendiği Port
    
    public static ServerThread runThread;//Thread serveri dinler.

    public static ArrayList<SClient> Clients = new ArrayList<>();

    
    public static Semaphore pairTwo = new Semaphore(1, true);//semafor 

    // başlatmak için sadece port numarası
    public static void Start(int openport) {
        try {
            Server.port = openport;
            Server.serverSocket = new ServerSocket(Server.port);

            Server.runThread = new ServerThread();
            Server.runThread.start();

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Display(String msg) {

        System.out.println(msg);

    }

    // serverdan clietlara mesaj gönderme
    public static void Send(SClient cl, Message msg) {

        try {
            cl.sOutput.writeObject(msg);
        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
