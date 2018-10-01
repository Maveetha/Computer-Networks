import java.io.*;
import java.net.*;
class Serverrarp
{
    public static void main(String args[])
    {
        try
        {
            DatagramSocket server=new DatagramSocket(1309);
            while(true)
            {
                byte[] sendbyte=new byte[1024];
                byte[] receivebyte=new byte[1024];
                DatagramPacket receiver=new DatagramPacket(receivebyte,receivebyte.length);
                server.receive(receiver);
                String str=new String(receiver.getData());
                String s=str.trim();
                InetAddress addr=receiver.getAddress();
                int port=receiver.getPort();
                 String a[][]={{ "165.165.80.80",
                 "6A:08:AA:C2"},
                {"165.165.79.1",
                "8A:BC:E3:FA"}};
                
              
                for(int i=0;i<a.length;i++)
                {
                  int j=0;
                        if(s.equals(a[i][j+1]))
                            
                    {
                        sendbyte=a[i][j].getBytes();
                        DatagramPacket sender=new DatagramPacket(sendbyte,sendbyte.length,addr,port);
                        server.send(sender);
                        break;
                    }
                    
                }
                break;
                }
            }
              catch(Exception e)
              {
                  System.out.println(e);
                
                
                
                
            }
        }
    }

