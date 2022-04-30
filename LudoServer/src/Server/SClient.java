/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import game.Message;
import static game.Message.Message_Type.Selected;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ozkan
 */
public class SClient {

    int id;
    public String name = "NoName";
    Socket soket;
    ObjectOutputStream sOutput;
    ObjectInputStream sInput;
  
    Listen listenThread;  //Clienttan gelenleri dinleyen Thread
    
    PairingThread pairThread;//Clientları eşleştirmek için Thread
    
    SClient rival;//2. Client
   
    public boolean paired = false; //eşleşme durumu

    public SClient(Socket gelenSoket, int id) {
        this.soket = gelenSoket;
        this.id = id;
        try {
            this.sOutput = new ObjectOutputStream(this.soket.getOutputStream());
            this.sInput = new ObjectInputStream(this.soket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.listenThread = new Listen(this);//thread nesnesi
        this.pairThread = new PairingThread(this);//thread nesnesi

    }

    
    public void Send(Message message) {//clienttan mesaj gönderme
        try {
            this.sOutput.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //client dinleme threadi
    //her clientin ayrı bir dinleme thredi var
    class Listen extends Thread {

        SClient TheClient;

        //thread için constructor metod(nesne almak için)
        Listen(SClient TheClient) {
            this.TheClient = TheClient;
        }

        public void run() {
            while (TheClient.soket.isConnected()) { //client bağlı olduğu sürece dönsün
                try {
                    Message received = (Message) (TheClient.sInput.readObject()); //mesajı bekler
                    //mesaj geldiğinde buraya geçilir. Mesajın tipine göre işlemler ayrılır.
                    switch (received.type) {
                        case Name:
                            TheClient.name = received.content.toString();
                            TheClient.pairThread.start();
                            break;
                        case Send:
                            Server.Send(TheClient.rival, received);
                            System.out.println("Send");
                            break;
                        case ZarDurumu:
                            Server.Send(TheClient.rival, received);
                            break;
                        case Side:
                            Server.Send(TheClient.rival, received);
                            break;
                        case Bitis:
                            break;

                    }

                } catch (IOException ex) {
                    Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
                    
                    Server.Clients.remove(TheClient);//Clientın bağlantısı koptuğunda listeden silinir.

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
                    
                    Server.Clients.remove(TheClient);//Clientın bağlantısı koptuğunda listeden silinir.
                }
            }

        }
    }

    //client
    //her clientin ayrı bir eşleştirme threadi var
    class PairingThread extends Thread {

        SClient TheClient;

        PairingThread(SClient TheClient) {
            this.TheClient = TheClient;
        }

        public void run() {
            //client bağlı ve eşleşmemiş olduğu durumda dön
            while (TheClient.soket.isConnected() && TheClient.paired == false) {
                try {
                    /*lock mekanizması
                    sadece bir client içeri girebilir.
                    diğerleri release olana kadar bekler */
                    Server.pairTwo.acquire(1);
                    
                   
                    if (!TheClient.paired) { //client eğer eşleşmemişse gir
                        SClient crival = null;//eşleşme sağlanana kadar dön
                        
                        while (crival == null && TheClient.soket.isConnected()) {//liste içerisinde eş ara
                            
                            for (SClient clnt : Server.Clients) {
                                if (TheClient != clnt && clnt.rival == null) {//eşleşme sağlandı ve gerekli işaretlemeler yapıldı
                                    
                                    crival = clnt;
                                    crival.paired = true;
                                    crival.rival = TheClient;
                                    TheClient.rival = crival;
                                    TheClient.paired = true;
                                    break;
                                }
                            }
                            
                            //sürekli dönmesin 1 saniyede bir dönsün
                            
                            sleep(1000);//thredi uyutuyoruz
                        }
                        //eşleşme gerceklesti.
                        //her iki tarafada eşleşme mesajı gönder. 
                        
                        //oyunu başlat.
                        Message msg1 = new Message(Message.Message_Type.RivalConnected);
                        msg1.content = TheClient.name;
                        Server.Send(TheClient.rival, msg1);

                        Message msg2 = new Message(Message.Message_Type.RivalConnected);
                        msg2.content = TheClient.rival.name;
                        Server.Send(TheClient, msg2);
                    }
                    //lock mekanizmasını servest bırak bırakılmazsa deadlock olur.
                    
                    Server.pairTwo.release(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PairingThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
