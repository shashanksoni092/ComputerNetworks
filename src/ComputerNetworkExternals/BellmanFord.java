package ComputerNetworkExternals;

import java.util.Scanner;

public class BellmanFord {

	static int graphs[][];
	static int via[][];
	static int rt[][];
	static int e;
	static int v;
	
	public static void main(String[] args)
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertex");
		v=sc.nextInt();
		
		System.out.println("Enter the number of edges");
		e=sc.nextInt();
		
		graphs=new int[v][v];
		rt=new int[v][v];
		via=new int[v][v];
		
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				if(i==j)
				{
					graphs[i][j]=0;
				}
				else {
					graphs[i][j]=9999;
				}
			}
		}
		
		
		for(int i=0;i<e;i++)
		{
			System.out.println("Enter the source");
			int source=sc.nextInt();
			
			System.out.println("Enter the Destination");
			int dest=sc.nextInt();
			
			source--;
			dest--;
			
			System.out.println("Enter the cost");
			int cost=sc.nextInt();
			
			graphs[source][dest]=cost;
			graphs[dest][source]=cost;
			
		}
		
		dvr("The routing table is");
		
		System.out.println("Enter the source vertex to change");
		int source=sc.nextInt();
		
		System.out.println("Enter the Destination vertex to change");
		int dest=sc.nextInt();
		
		source--;
		dest--;
		
		System.out.println("Enter the new cost ");
		int cost=sc.nextInt();
		
		graphs[source][dest]=cost;
		graphs[dest][source]=cost;
		
		dvr("The routing table after the change is");
		
	}

	private static void dvr(String string) {
		
		
		System.out.println();
		init();
		update();
		print();
		
		
	}

	private static void print() {
		
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				System.out.print(rt[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void update() {
		
		int k=0;
		for(int i=0;i<4*v;i++)
		{
			update(k);
			k++;
			if(k==v)
				k=0;
		}
	}

	private static void update(int source) {
	
		for(int i=0;i<v;i++)
		{
			if(graphs[source][i]!=9999)
			{
				int dist=graphs[source][i];
				for(int j=0;j<v;j++)
				{
					int interdist=rt[i][j];
					if(via[i][j]==source)
						interdist=9999;
					
					if(dist+interdist<rt[source][j])
					{
						rt[source][j]=dist+interdist;
						via[source][j]=i;
					}
				}
			}
		}
		
	}

	private static void init() {
		
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				if(i==j)
				{
					rt[i][j]=0;
					via[i][j]=i;
				}
				else {
					rt[i][j]=9999;
					via[i][j]=100;
				}
				
			}
		}
	}
	
}
