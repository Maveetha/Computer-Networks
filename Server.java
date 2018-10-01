package stop.and.wait.protocol;
import java.io.*;
import java.net.*;
public class Server {
    public static void main(String args[])
              throws Exception{
    ServerSocket ecsvr=null;
    String line1,line2;
    DataInputStream dis=null;
    PrintStream ptr=null;
    Socket clsckt = null;
    BufferedReader in1=null;
    ecsvr= new ServerSocket(0001);
    System.out.println("Talk Server");
    clsckt=ecsvr.accept();
    dis=new DataInputStream(clsckt.getInputStream());
    ptr=new PrintStream(clsckt.getOutputStream());
    System.out.println("node connected");
    while(true){
    line1=dis.readLine();
    System.out.println("Message received");
    System.out.println("The Message:"+line1);
    in1= new BufferedReader(new InputStreamReader(System.in));
    line2= in1.readLine();
    if(line2.equals("end")){
    break;
    }
    ptr.println(line2);
    ptr.flush();
    System.out.println("Message sent Successfully");
    }
    dis.close();
    ptr.close();
    }
}


