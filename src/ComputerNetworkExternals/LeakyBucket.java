package ComputerNetworkExternals;

import java.util.Scanner;
import java.util.TreeSet;

public class LeakyBucket {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the burstiness");
		int L=sc.nextInt();
		
		System.out.println("Enter the Interpacker arrival time");
		int I=sc.nextInt();
		
		System.out.println("Enter number of ta values");
		int tval=sc.nextInt();
		TreeSet<Integer>arrivalTimes=new TreeSet<Integer>();
		
		for(int i=0;i<tval;i++)
		{
			arrivalTimes.add(sc.nextInt());
		}
		int LCT=arrivalTimes.first();
		int X=0;
		for(int ta:arrivalTimes)
		{
			int Xa=X-(ta-LCT);
			if(Xa>L)
			{
				System.out.println("Non conforming");
			}
			else {
				X=Xa+I;
				LCT=ta;
				System.out.println("conforming");
			}
			
		}
		
		
	}

}
