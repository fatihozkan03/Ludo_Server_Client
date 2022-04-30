/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Ozkan
 */

public class Message implements java.io.Serializable {
    //mesaj tipleri enum 
    public static enum Message_Type {None, Name,Send,RedSquare, Disconnect,RivalConnected, Text, Selected, Bitis,Start, ZarDurumu, Side}
    //mesajın tipi
    public Message_Type type;
    //mesajın içeriği obje tipinde (her dosya yuklenmesi icin)
    public Object content;
    
    public Message(Message_Type t)
    {
        this.type=t;
    }
 

    
    
}
