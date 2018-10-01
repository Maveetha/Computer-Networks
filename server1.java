package rpc;
import java.io.*;
import java.net.*;
class server1
{
 public static void main(String[] args)throws Exception
    {
 ServerSocket sersock= new ServerSocket(3000);
 System.out.println("Server ready");
 Socket sock=sersock.accept();
 BufferedReader KeyRead= new BufferedReader(new InputStreamReader(System.in));
 OutputStream ostream = sock.getOutputStream();
 PrintWriter pwrite = new PrintWriter(ostream,true);
 InputStream istream= sock.getInputStream();
 BufferedReader receiveRead= new BufferedReader(new InputStreamReader(istream));
 String receiveMessage,sendMessage,fun;
 int a,b,c;
     while(true)
     {
     fun=receiveRead.readLine();
     if(fun!=null)
         System.out.println("operation:"+fun);
     a= Integer.parseInt(receiveRead.readLine());
     System.out.println("parameter1:"+a);
     b=Integer.parseInt(receiveRead.readLine());
      System.out.println("parameter2:"+b);
     if(fun.compareTo("add")==0)
     {
     c=a+b;
     System.out.println("addition ="+c);
     pwrite.println("addition ="+c);
         }
     if(fun.compareTo("sub")==0)
     {
     c=a-b;
     System.out.println("subtraction="+c);
     pwrite.println("subtraction ="+c);
     }
     if(fun.compareTo("mul")==0)
     {
     c=a*b;
     System.out.println("multiplication ="+c);
     pwrite.println("multiplication ="+c);

     }
     if(fun.compareTo("div")==0)
     {
         c=a/b;
        System.out.println("division ="+c);
     pwrite.println("division ="+c);
      }
     System.out.flush();
     }

    }
 }

