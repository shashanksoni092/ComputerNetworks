package ComputerNetworkExternals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss=new ServerSocket(1234);
		Socket socket=ss.accept();
		
		InputStream in=socket.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String filename=br.readLine();
		
		BufferedReader context=new BufferedReader(new FileReader(filename));
		
		OutputStream ostream=socket.getOutputStream();
		PrintWriter pw=new PrintWriter(ostream,true);
		
		String str="";
		
		while((str=context.readLine() )!= null)
		{
			pw.println(str);
		}
		
	}

}
