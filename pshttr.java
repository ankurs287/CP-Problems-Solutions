import java.util.*;
import java.lang.*;
import java.io.*;
 
class pshttr
{
	public static int[] vis;
	public static int[] p;
	public static int[] pos;
	public static long[] d;
	public static int size=0;
	public static void insert(long[] x, long[][] H)
	{
		int i=size;
		H[size]=x;
		size++;
		while(i>0 && H[i][1] < H[(i-1)/2][1])
		{
			pos[(int) H[i][0] ] = (i-1)/2;
			pos[(int) H[(i-1)/2][0] ] = i;

			long[] temp=H[i];
			H[i]=H[(i-1)/2];
			H[(i-1)/2]=temp;

			i=(i-1)/2;
		}
	}
	public static void MinHeapify(int i, long[][] H)
	{
		int n=size-1;
		boolean flag=true;
		while(i<=(n-1)/2 && flag)
		{
			int min=i;
			if(H[i][1] > H[2*i+1][1]) min=2*i+1;
			if(2*i+2<=n && H[min][1] > H[2*i+2][1])	min=2*i+2;
			if(min!=i)
			{
				pos[(int)H[min][0]]=i;
				pos[(int) H[i][0]]=min;

				long[] temp=H[i];
				H[i]=H[min];
				H[min]=temp;
				i=min;
			}
			else
				flag=false;
		}
	}
	public static long[] remove(long[][] H)
	{
		// if(size==0)
		// 	return;
		long[] temp=H[0];
		H[0]=H[--size];
		MinHeapify(0,H);
		return temp;
	}
	public static void print(long[][] H)
	{
		for(int i=0;i<size;i++)
		{
			System.out.println(H[i][0]+" "+H[i][1]);
		}
	}
	public static void decreaseKey(long[][] H, int v, long dist)
	{

	    int i = pos[v];
	    H[i][1] = dist;

	    while(i > 0 && H[i][1] < H[(i - 1) / 2][1])
	    {
	        pos[(int) H[i][0] ] = (i-1)/2;
	        pos[(int) H[(i-1)/2][0] ] = i;

	        long[] temp=H[i];
	        H[i]=H[(i-1)/2];
	        H[(i-1)/2]=temp;

	        i = (i - 1) / 2;
	    }
	}
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		int t=Reader.nextInt();
		while(t-->0)
		{
			int n=Reader.nextInt();
			
			Node[] A=new Node[n+1];
			for(int i=0;i<=n;i++)
			{
				A[i]=new Node();
			}
			int q=n-1;
			while(q-->0)
			{
				int x=Reader.nextInt();
				int y=Reader.nextInt();
				long z=Reader.nextLong();

				Node temp=A[x].link;
				Node n2=new Node(y,z);
				A[x].link=n2;

				n2.link=temp;

				Node temp2=A[y].link;
				Node n3=new Node(x,z);
				A[y].link=n3;
				n3.link=temp2;
			}
			
			q=Reader.nextInt();
			while(q-->0)
			{
				int s=Reader.nextInt();
				int d=Reader.nextInt();
				long z=Reader.nextLong();

				p=new int[n+1];
				Dijkstra(A, s, n);
				long ans=0;
				int temp=0;
				// for(int i=0;i<=n;i++)
				// {
				// 	System.out.println(i+" "+p[i]+" ");
				// }
				while(true)
				{
					if(temp==s)
						break;
					temp=p[d];
					Node ptr=A[d].link;
					while(ptr!=null)
					{
						if(ptr.v==temp)
						{
							if(ptr.w<=z)
								ans=ans^ptr.w;
							break;
						}
						ptr=ptr.link;
					}
					d=temp;
				}
				System.out.println(ans);
			}
		}
	}
	public static void Dijkstra(Node[] A,int s, int n) //S: start node
	{
		d=new long[n+1];
		pos=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			pos[i]=i-1;
			d[i]=Integer.MAX_VALUE;
		}
		d[s]=0;
		long[][] H=new long[n+1][2];
		for(int i=1;i<=n;i++)
		{
			long[] temp={i, d[i]};
			insert(temp, H);
		}
		vis=new int[n+1];
		p=new int[n+1];
		int ne=n;
		// print(H);
		while(ne-->0)
		{
			// long min=Integer.MAX_VALUE;
			// int u=0;
			// for(int i=1;i<=n;i++) //min element in D
			// {
			// 	if(d[i]<=min && vis[i]==0)
			// 	{
			// 		min=d[i];
			// 		u=i;
			// 	}
			// }

			// System.out.println(H[0][1]);
			long[] t=remove(H);
			int u=(int)t[0];
			vis[u]=1;
			Node ptr=A[u].link;
			while(ptr!=null)
			{
				if(d[ptr.v] > d[u] + ptr.w)
				{
					d[ptr.v]=d[u]+ptr.w;
					decreaseKey(H, ptr.v, d[ptr.v]);
					p[ptr.v]=u;
				}
				ptr=ptr.link;
			}
		}
	}
}
class Node
{
	int v;
	Node link;
	long w;
	Node()
	{
		link=null;
		// front=null;
	}
	Node(int y,long z)
	{
		link=null;
		v=y;
		w=z;
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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
} 