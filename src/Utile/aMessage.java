/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utile;

/**
 *
 * @author cault
 */
public class aMessage {

    /**
     * @param args the command line arguments
     */
    
    private Message message;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
    }

    aMessage(){
        message = Message.NULL;
    }
    
    public Message getMessage() {
        return message;
    }

   
    private void setMessage(Message message) {
        this.message = message;
    }

    public void MENU(){
    message = Message.MENU;
    }

    public void RULES(){
    message = Message.RULES;
    }

    public void GRID(){
    message = Message.GRID;
    }
    
}
