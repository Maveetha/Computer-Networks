package rpc;
import java.io.*;
import java.net.*;
class client1

{
    public static void main(String[] args)throws Exception
            {
        Socket sock= new Socket("127.0.0.1",3000);
        BufferedReader KeyRead = new BufferedReader(new InputStreamReader(System.in));
        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite= new PrintWriter(ostream,true);
        InputStream istream=sock.getInputStream();
        BufferedReader receiveRead= new BufferedReader(new InputStreamReader(istream));
        System.out.println("client reader type and press enter key");
        String receiveMessage ,sendMessage,temp;
        while(true)

       {
            System.out.println("\n Enter operation to perform(add,sub,mul,div)....");
            temp=KeyRead.readLine();
            sendMessage=temp.toLowerCase();
             pwrite.println(sendMessage);
            System.out.println("Enter first parameter");
            sendMessage=KeyRead.readLine();
            pwrite.println(sendMessage);
            System.out.println("Enter second parameter");
            sendMessage=KeyRead.readLine();
            pwrite.println(sendMessage);
            System.out.flush();
            if((receiveMessage=receiveRead.readLine())!=null)
                System.out.println(receiveMessage);

          }


    }
}

