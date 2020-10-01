package com.vinayakaz.prac;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void maind( String[] args )
    {
       
        
        SendMessage sendMessage = new SendMessage();
        
        try {
           // sendMessage.run();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Receiver receiver  = new Receiver();
        
        try {
            receiver.run();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
