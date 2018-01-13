// JPS CP1
import java.util.*;
import java.lang.*;
import java.io.*;

class jps_a
{
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

		int[] visit=new int[n+1];
		int color[] = new int[n+1];
        for (int i=0; i<n+1; i++)
            color[i] = -1;

        // boolean res=bipartite(A,1,color);
        // if(!res)
        // {
        // 	System.out.println("-1");
        // 	return;
        // }
        int islands=0;
        for (int i = 1; i < n+1; i++)
        {
			if (color[i] == -1)
			{
				islands++;
			    if (!bipartite(A, i, color))
			    {
			       System.out.println("-1");
			       return;
				}
			}
		}

        int count=0;
		for(int i=1;i<n+1;i++)
		{
			if(color[i]==1)
				count++;
		}        
		System.out.println(count);
		for(int i=1;i<n+1;i++)
		{
			if(color[i]==1)
				System.out.print(i+" ");
		}
		System.out.println();
		// System.out.println("------");

		count=0;
		for(int i=1;i<n+1;i++)
		{
			if(color[i]==0)
				count++;
		}
		System.out.println(count);
		for(int i=1;i<n+1;i++)
		{
			if(color[i]==0)
				System.out.print(i+" ");
		}
		System.out.println();
	}
	public static boolean bipartite(Node[] A,int s,int[] color)
    {
 		color[s] = 1;
 
        LinkedList<Integer> que = new LinkedList<Integer>();
        que.add(s);
 
        while (que.size() != 0)
        {
        	int u = que.poll();
 
            Node curr=A[u].link;
            while(curr!=null)
            {
                if (color[curr.v]==-1)
                {
                    color[curr.v] = 1-color[u];
                    que.add(curr.v);
                }
 				else if (color[curr.v]==color[u])
 				{
                    return false;
 				}
                curr=curr.link;
            }
        }
        return true;
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