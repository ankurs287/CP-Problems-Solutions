import java.util.*;
import java.lang.*;
import java.io.*;

class lab11
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

		int v=Reader.nextInt();
		int e=Reader.nextInt();

		Node[] A=new Node[v+1];
		for(int i=0;i<v+1;i++)
		{
			A[i]=new Node();
		}

		int q=e;
		while(q-->0)
		{
			int x=Reader.nextInt();
			int y=Reader.nextInt();
			int z=Reader.nextInt();

			Node temp=A[x].link;
			Node n2=new Node(y,z);
			A[x].link=n2;

			n2.link=temp;

			Node temp2=A[y].link;
			Node n3=new Node(x,z);
			A[y].link=n3;
			n3.link=temp2;
		}
		
		// for(int i=1;i<v+1;i++)
		// {
		// 	Node ptr=A[i].link;
		// 	while(ptr!=null)
		// 	{
		// 		System.out.print(ptr.v+"/"+ptr.w+"  ");
		// 		// System.out.println();
		// 		ptr=ptr.link;
		// 	}
		// 	System.out.println();
		// }


		// prim's algo
		int[] d=new int[v+1];
		int[] p=new int[v+1];
		d[1]=0;
		p[1]=1;
		for(int i=2;i<v+1;i++)
		{
			d[i]=Integer.MAX_VALUE;
		}

		int t=v;
		int min=Integer.MAX_VALUE;
		int[] vis=new int[v+1];
		vis[1]=1;
		int w=0;
		int index=1;
		while(t-->0)
		{
			min=Integer.MAX_VALUE;
			for(int i=1;i<v+1;i++)
			{
				if(d[i]<min && vis[i]!=1)
				{
					index=i;
					min=d[i];
				}
			}
			w=d[index];
			vis[index]=1;

			Node ptr=A[index].link;
			while(ptr!=null)
			{
				if(vis[ptr.v]!=1 && ptr.w<d[ptr.v]) //belongs to d
				{
					d[ptr.v]=ptr.w;
					p[ptr.v]=index;
				}
				ptr=ptr.link;
			}
		}

		int f1=0;
		for(int i=1;i<v+1;i++)
		{
			// System.out.println(d[i]+" "+p[i]);
			if(d[i]!=Integer.MAX_VALUE)
				f1+=d[i];
		}
		// System.out.println("MST: "+f1);

		// the code
		int count=0;
		int[] dT=new int[v-1];
		int wt=0;
		int[] dn=new int[v+1];
		for(int i=2;i<v+1;i++)
		{
			wt=d[i];
			Node ptr=A[i].link;
			Node bf=A[i];
			while(ptr!=null)
			{
				if(ptr.v==p[i])
				{
					bf.link=ptr.link;
					break;
				}
				ptr=ptr.link;
				bf=bf.link;
			}

			ptr=A[p[i]].link;
			bf=A[p[i]];
			while(ptr!=null)
			{
				if(ptr.v==i)
				{
					bf.link=ptr.link;
					break;
				}
				ptr=ptr.link;
				bf=bf.link;
			}

			// for(int y=1;y<v+1;y++)
			// {
			// 	ptr=A[y].link;
			// 	System.out.print(y+": ");
			// 	while(ptr!=null)
			// 	{
			// 		System.out.print(ptr.v+"/"+ptr.w+"  ");
			// 		// System.out.println();
			// 		ptr=ptr.link;
			// 	}
			// 	System.out.println();
			// }

			
			for(int j=2;j<v+1;j++)
			{
				dn[j]=Integer.MAX_VALUE;
			}
			t=v;
			for(int j=0;j<v+1;j++)
			{
				vis[j]=0;
			}
			vis[1]=1;
			w=0;
			index=1;
			while(t-->0)
			{
				min=Integer.MAX_VALUE;
				for(int j=1;j<v+1;j++)
				{
					if(dn[j]<min && vis[j]!=1)
					{
						index=j;
						min=dn[j];
					}
				}
				w=dn[index];
				vis[index]=1;

				ptr=A[index].link;
				while(ptr!=null)
				{
					if(vis[ptr.v]!=1 && ptr.w<dn[ptr.v]) //belongs to d
					{
						dn[ptr.v]=ptr.w;
					}
					ptr=ptr.link;
				}
			}
			int o=0;
			for(int j=1;j<v+1;j++)
			{
				// System.out.println(d[i]+" "+p[i]);
				if(dn[j]!=Integer.MAX_VALUE)
					o+=dn[j];
			}
			dT[count]=o;
			count++;
			// System.out.println(o);

			// link connect again
			Node temp=A[i].link;
			Node a=new Node(p[i],wt);
			A[i].link=a;
			a.link=temp;

			Node temp2=A[p[i]].link;
			Node b=new Node(i,wt);
			A[p[i]].link=b;
			b.link=temp2;
		}

		int max=Integer.MAX_VALUE;
		int out=-1;
		for(int i=0;i<v-1;i++)
		{
			if(dT[i]>f1 && dT[i]<max)
			{
				out=dT[i];
				max=dT[i];
			}
		}
		System.out.println(out);
	}
}

class Node
{
	int v;
	Node link;
	int w;
	Node()
	{
		link=null;
		// front=null;
	}
	Node(int y,int z)
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
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}