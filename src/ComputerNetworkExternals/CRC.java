package ComputerNetworkExternals;

import java.util.Scanner;

public class CRC {

	static int[]Dataword;
	static int[]codeword;
	static int[]Divisor;
	static int[]crc;
	static int[]remainder;
	
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of dataword");
		int dataword_size=sc.nextInt();
		
		System.out.println("Enter the dataword ");
		Dataword=new int[dataword_size];
		for(int i=0;i<dataword_size;i++)
		{
			Dataword[i]=sc.nextInt();
		}
		
		System.out.println("Enter the size of divisor");
		int divisor_size=sc.nextInt();
		
		System.out.println("Enter the divisor");
		Divisor=new int[divisor_size];
		for(int i=0;i<divisor_size;i++)
		{
			Divisor[i]=sc.nextInt();
		}
		
		int total_length=dataword_size+divisor_size-1;
		
		remainder=new int[total_length];
		crc=new int[total_length];
		codeword=new int[total_length];
		
		
		for(int i=0;i<dataword_size;i++)
		{
			codeword[i]=Dataword[i];
			remainder[i]=Dataword[i];
			
		}
		
		remainder=divide(codeword,Divisor,remainder);
		
		System.out.println("Remainder is:-");
		for(int i=0;i<remainder.length;i++)
		{
			System.out.print(remainder[i]);
		}
		System.out.println();
		for(int i=0;i<remainder.length;i++)
		{
			crc[i]=codeword[i]^remainder[i];
		}
		System.out.println("crc is:-");
		for(int i=0;i<codeword.length;i++)
		{
			System.out.print(crc[i]);
		}
		
		System.out.println("Enter crc");
		for(int i=0;i<crc.length;i++)
		{
			crc[i]=sc.nextInt();
		}
		
		for(int i=0;i<remainder.length;i++)
		{
			remainder[i]=crc[i];
		}
		remainder=divide(crc, Divisor, remainder);
		
		for(int i=0;i<remainder.length;i++)
		{
			if(remainder[i]!=0)
			{
				System.out.println("Error");
				break;
			}
			if(i==remainder.length-1)
			{
				System.out.println("No error");
			}
		}
		
	}


	private static int[] divide(int[] codeword, int[] Divisor, int[] remainder) {
		int count=0;
		
		while(true)
		{
		for(int i=0;i<Divisor.length;i++)
		{
			remainder[count+i]=remainder[count+i]^Divisor[i];
		}

		while(remainder[count]==0 && count!=remainder.length-1)
		{
			count++;
		}
		
		if((remainder.length-count)<Divisor.length)
		{
			break;
		}
		
		}
		
			return remainder;
		
	}

}
