package stop.and.wait.protocol;
import java.io.*;
import java.net.*;
public class Client {
    public static void main(String args[]){
    PrintWriter out=null; 
    String line1;
    BufferedReader networkln=null;
     try {
    Socket thesocket=new Socket("local host",0001);
    networkln= new BufferedReader(new InputStreamReader(thesocket.getInputStream()));
     BufferedReader userln=new BufferedReader(new InputStreamReader(System.in));
     out=new PrintWriter(thesocket.getOutputStream());
     System.out.println("Talk Client");
     while(true){
     System.out.println("Send Message to server");
     String theline=userln.readLine();
     if(theline.equals("end"))
         break;
     out.println(theline);
     out.flush();
     System.out.println("Message Sent!");
     System.out.println("");
     System.out.println("Message received from the server"+networkln.readLine());
     }
    }
     catch(IOException e){
     System.err.println(e);
     }
      try{
         if(networkln!=null)
          networkln.close();
         if(out!=null)
             out.close();
      }
      catch (IOException e){
        System.err.println(e);      
            }
            
    }
}



