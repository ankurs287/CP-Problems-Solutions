import java.util.*;
import java.lang.*;
import java.io.*;

class lab10
{
	public static int[] visit;
	public static int ne=0;

	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

		int n=Reader.nextInt();
		int d=Reader.nextInt();

		// int[][] a=new int[n+1][n+1];

		Node[] A=new Node[n+1];
		for(int i=0;i<n+1;i++)
		{
			A[i]=new Node();
		}

		while(d-->0)
		{
			int x=Reader.nextInt();
			int y=Reader.nextInt();
			// a[x][y]=1;

			Node temp=A[x].link;
			Node n2=new Node(y);
			A[x].link=n2;
			n2.link=temp;

			Node temp2=A[y].link;
			Node n3=new Node(x);
			A[y].link=n3;
			n3.link=temp2;
		}

		visit=new int[n+1];

		int j=0;
		int[] nc=new int[n];

		for(int i=1;i<n+1;i++)
		{
			if(visit[i]!=1)
			{
				ne=0;
				DFS(A,i);
				// System.out.println("--");
				nc[j]=ne;
				j++;
			}
		}
		System.out.println(j);
		
		selectionSort(nc,j);

		for(int i=0;i<j;i++)
		{
			System.out.print(nc[i]+" ");
		}


	}
	
	public static void DFS(Node[] A,int s) //S: start node
	{
		// System.out.println(s); 
		ne++;
		visit[s]=1;

		Node curr=A[s].link; //Address of first node

		while(curr!=null)
		{
			int val=curr.v;
			if(visit[val]!=1)
			{
				DFS(A,val);
			}
			curr=curr.link;
		}
	}
	public static void selectionSort(int[] ats,int d)
	{  
        for(int i=0;i<d;i++)  
        {  
            int q=i;  
            for (int j=i+1;j<d;j++)
            {  
                if(ats[j]<ats[q])
                {  
                    q=j;  
                }  
            }  
            int t=ats[q];   
            ats[q]=ats[i];  
            ats[i]=t;  
        }
    } 
}

class Node
{
	int v;
	Node link;
	// Node front;

	Node()
	{
		link=null;
		// front=null;
	}
	Node(int y)
	{
		link=null;
		v=y;
	}

}


/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}