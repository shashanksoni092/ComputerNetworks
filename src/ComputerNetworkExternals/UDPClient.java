package ComputerNetworkExternals;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPClient {

	public static void main(String[] args)
	{
		
	
	try {
		
		DatagramSocket ds=new DatagramSocket(1024);
		DatagramPacket dp;
		byte[] Buffer=new byte[1248];
		
		while(true)
		{
			dp=new DatagramPacket(Buffer, Buffer.length);
			ds.receive(dp);
			String line=new String(Buffer);
			if(line=="exit")
				ds.close();
			System.out.println(line);
			
		}
		
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	}
	
}
