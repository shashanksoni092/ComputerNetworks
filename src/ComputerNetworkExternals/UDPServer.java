package ComputerNetworkExternals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

	public static void main(String[] args)
	{
		
	
	try {
		
		DatagramSocket ds=new DatagramSocket();
		DatagramPacket dp;
	
		byte[] Buffer;
		String input;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Buffer=new byte[1248];
		
		while(true){
			
		input=br.readLine();
		System.out.println(input);
		Buffer=input.getBytes();
		dp=new DatagramPacket(Buffer, Buffer.length,InetAddress.getLocalHost(),1024);
		ds.send(dp);
		if(input=="exit")
		{
			ds.close();
		}
		}
		
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	}
}
