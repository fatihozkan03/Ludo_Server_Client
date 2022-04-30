/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo;

import game.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Ludo.Client.sInput;
import Ludo.Scene;

/**
 *
 * @author Ozkan
 */
// serverdan gelecek mesajları dinleyen thread
class Listen extends Thread {

    public void run() {
        //soket bağlı olduğu sürece döner
        while (Client.socket.isConnected()) {
            try {
                //mesaj gelmesini bloking olarak dinyelen komut
                Message received = (Message) (sInput.readObject());
                //mesaj geldi
                //mesaj tipine göre
                switch (received.type) {
                    case Name:
                        break;
                   
                    case Send:
                        System.out.println("Geldim.");
                        Scene.game.ReadFromServer(received);
                        break;
                        
                    case ZarDurumu:
                        Scene.game.DiceCounter=(int)received.content;
                        break;
                        
                    case Side:
                        Scene.game.side=received.content.toString();
                        Scene.game.zar.setEnabled(true);
                        break;
                    case RedSquare:
                        Scene.SetRedSquare();
                        
                        break;
                    case Bitis:
                        break;

                }

            } catch (IOException ex) {

                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                break;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }

    }
}

public class Client {

    //her clienta ait bir soket
    public static Socket socket;

   
    public static ObjectInputStream sInput; //verileri almak için gerekli nesne
    
    public static ObjectOutputStream sOutput;//verileri göndermek için gerekli nesne
    
    public static Listen listenMe;//serverı dinleme threadi 

    public static void Start(String ip, int port) {
        try {
            
            Client.socket = new Socket(ip, port);// Client Soket nesnesi
            Client.Display("Servera bağlandı");
           
            Client.sInput = new ObjectInputStream(Client.socket.getInputStream()); // input stream
         
            Client.sOutput = new ObjectOutputStream(Client.socket.getOutputStream());   // output stream
            Client.listenMe = new Listen();
            Client.listenMe.start();
            
            
            Message msg = new Message(Message.Message_Type.Name);//ilk mesaj Player
            msg.content = "Player";
            Client.Send(msg);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void Display(String msg) {

        System.out.println(msg);

    }

    //mesaj gönderme 
    public static void Send(Message msg) {
        try {
            Client.sOutput.writeObject(msg);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
