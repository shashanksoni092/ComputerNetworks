package ComputerNetworkExternals;

import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class RSA {

	static BigInteger p;
	static BigInteger q;
	static BigInteger n;
	static BigInteger phi;
	static BigInteger e;
	static BigInteger d;
	static int bitlength=1024;
	static Random r;
	public static void main(String[] args) throws IOException
	{
	
		r=new Random();
		p=BigInteger.probablePrime(bitlength, r);
		q=BigInteger.probablePrime(bitlength, r);
		
		n=p.multiply(q);
		
		phi=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		
		e=BigInteger.probablePrime(bitlength/2, r);
				
		while(phi.gcd(e).compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0)
			e.add(BigInteger.ONE);
		
		d=e.modInverse(phi);
		
		DataInputStream ds=new DataInputStream(System.in);
		System.out.println("Enter the string");
		String input=ds.readLine(); 
		
		System.out.println("Encrypted string is ");
		
		byte[]encrypted=encrypted(input.getBytes()); 
		byte[]decrypted=decrypted(encrypted);
		
		
		System.out.println("The decrypted string is "+new String(decrypted));
		
	}
	private static byte[] decrypted(byte[] encrypted) {
		return new BigInteger(encrypted).modPow(d, n).toByteArray();
		}
	private static byte[] encrypted(byte[] bytes) {
		
		return new BigInteger(bytes).modPow(e, n).toByteArray();
		}

}
