// JPS CP1
import java.util.*;
import java.lang.*;
import java.io.*;

class jps_f
{
	public static int[] visit;
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

		int n=Reader.nextInt();
		int m=Reader.nextInt();

		Node[] A=new Node[n+1];
		for(int i=0;i<n+1;i++)
		{
			A[i]=new Node();
		}

		while(m-->0)
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
		int islands=0;
		for(int i=1;i<n+1;i++)
		{
			if(visit[i]!=1)
			{
				DFS(A,i);
				islands++;
			}
		}
		System.out.println(islands);

	}

	public static void DFS(Node[] A,int s) //S: start node
	{
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