package ComputerNetworkExternals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket=new Socket("127.0.0.1", 1234);
		System.out.println("Enter the filename");
		InputStreamReader in=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(in);
		String filename=br.readLine();
		
		OutputStream ostream=socket.getOutputStream();
		PrintWriter pw=new PrintWriter(ostream,true);
		pw.println(filename);

		InputStream input=socket.getInputStream();
		BufferedReader context=new BufferedReader(new InputStreamReader(input));
		
		String str="";
		while((str=context.readLine())!=null)
		{
			System.out.println(str);
		}
		
	}

}
