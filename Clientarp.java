import java.io.*;
import java.net.*;
class Clientarp
{
    public static void main(String args[])
    {
        try
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            Socket clsct=new Socket("127.0.0.1",139);
            DataInputStream din=new DataInputStream(clsct.getInputStream());
            DataOutputStream dout=new DataOutputStream(clsct.getOutputStream());
            System.out.println("enter the logical address:");
            String str1=in.readLine();
            dout.writeBytes(str1+'\n');
            String str=din.readLine();
            System.out.println("the physical addresses is:"+str);
            clsct.close();
            
        }catch(Exception e)
    
    {
        System.out.println(e);
    }
    }
}
