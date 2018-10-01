import java.io.*;
import java.net.*;
class Serverarp
{
    public static void main(String args[])
    {
        try
            {   
                ServerSocket obj=new ServerSocket(139);
            
                 Socket obj1=obj.accept();
                 while(true)
                 {
                  
                 
                DataInputStream din=new DataInputStream(obj1.getInputStream());
                DataOutputStream dout=new DataOutputStream(obj1.getOutputStream());
        
            
                String str=din.readLine();
               
                String a[][]=new String[2][2];
                 a[0][0]="165.165.80.80";
                a[0][1]="6A:08:AA:C2";
                a[1][0]="165.165.79.1";
                a[1][1]="8A:BC:E3:FA";
                
                
                for(int i=0;i<10;i++)
                {
                    
                        if(str.equals(a[i][0]))
                        {
                             dout.writeBytes(a[i][1]+'\n');
                             break;
                    }
                    else
                    {
                        System.out.println("no mac found");
                    }
                    }
                obj.close();
                }
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
}



