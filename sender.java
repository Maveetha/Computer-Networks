import java.net.*;
 import java.io.*;
 import java.rmi.*;
 public class sender{
     public static void main(String a[])throws Exception
    {
         ServerSocket ser=new
         ServerSocket(10);
         Socket s=ser.accept();
         DataInputStream in=new DataInputStream(System.in);
         DataInputStream in1=new DataInputStream(s.getInputStream());
         String sbuff[]=new String[8];
         PrintStream p;
         int Sptr=0,sws=8,nf,ano,i;
         String ch;
         do
         {
             p=new
             PrintStream(s.getOutputStream());
             System.out.print("enter the number of frames:");
             nf=Integer.parseInt(in.readLine());
             p.println(nf);
             if(nf<=sws-1)
             {
                 System.out.println("enter "+nf+" messages to be send\n");
                 for(i=1;i<=nf;i++)
                 {
                     sbuff[Sptr]=in.readLine();
                     p.println(sbuff[Sptr]);
                     Sptr=++Sptr%8;
                 }
                 sws-=nf;
                 System.out.print("acknowledgement received");
                 ano=Integer.parseInt(in1.readLine());
                 System.out.println("for"+ano+"frames");
                 sws+=nf;

             }
            else
             {
                 System.out.println("the number of frames exceeds window size");
                 break;
            }
             System.out.println("\n");
             ch=in.readLine();
             p.println(ch);
         }
         while(ch.equals("yes"));
         s.close();
     }
}
