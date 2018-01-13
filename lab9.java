import java.util.*;
import java.lang.*;
import java.io.*;

class lab9
{
	public static int size=0;
	public static int levelsum=0;
	
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

		int x=Reader.nextInt();
		int y=Reader.nextInt();

		int num=x*y*8;

		int[] a=new int[256];

		for(int i=0;i<x*y;i++)
		{
			int value=Reader.nextInt();
			a[value]++;
		}

		Node[] t=new Node[x*y];

		int j=0;
		for(int i=0;i<256;i++)
		{
			if(a[i]!=0)
			{
				t[j]=new Node();
				t[j].v=a[i];
				t[j].pvalue=i;
				j++;
			}
		}
		size=j;

		int misc=0;
		if(size==1)
		{
			misc=1;
		}
		for(int i=0;i<size && size!=1;i++)
		{
			heapify(t,i);
		}

		while(size!=1)
		{
			Node ltemp=t[0];
			delete(t);
			Node rtemp=t[0];
			delete(t);

			Node temp=new Node(ltemp,rtemp);
			insert(t,temp);
		}
		if(misc==0)
		{
			display(t[0],0);
		}
		else
		{
			levelsum=t[0].v;
		}
		System.out.println(Math.round(((float)num/(float)levelsum)*10)/10.0d);

		Node[] u=new Node[25];
		int max=0, sum=a[0], k=0;
		for(int i=0;i<256;i+=10)
		{
			max=i;sum=a[i];
			if(i==240)
			{
				j=i+1;
				i=246;
				// System.out.println(i);
			}
			else
			{
				j=i+1;
			}

			for(;j<=i+9;j++)
			{
				if(a[j]>0 && a[j]>a[max])
				{
					max=j;
					// System.out.println(max);
				}
				sum=sum+a[j];
				// System.out.println(j);
				// System.out.println();
			}

			// System.out.println(max);
			if(sum>0)
			{
				// System.out.println(max+" "+sum);
				u[k]=new Node();
				u[k].v=sum;
				u[k].pvalue=max;
				k++;	
			}
		}

		size=k;
		misc=0;
		if(size==1)
		{
			misc=1;
		}
		for(int i=0;i<size && size!=1;i++)
		{
			heapify(u,i);
		}

		while(size!=1)
		{
			Node ltemp=u[0];
			delete(u);
			Node rtemp=u[0];
			delete(u);

			Node temp=new Node(ltemp,rtemp);
			insert(u,temp);
		}
		levelsum=0;
		if(misc==0)
		{
			display(u[0],0);
		}
		else
		{
			levelsum=u[0].v;
		}

		System.out.println(Math.round(((float)num/(float)levelsum)*10)/10.0d);
	}

	public static void heapify(Node[] H,int i)
	{
		int n=size-1;
		int flag=1;
		while(i<=(n-1)/2 && flag==1)
		{
			int min=i;
			if(H[i].v>H[2*i+1].v)
			{
				min=2*i+1;
			}
			if(2*i+2<=n && H[min].v>H[2*i+2].v)
			{
				min=2*i+2;
			}
			if(min!=i)
			{
				Node temp=H[i];
				H[i]=H[min];
				H[min]=temp;
				i=min;
			}
			else
			{
				flag=0;
			}
		}
	}
	
	public static void insert(Node[] H, Node x)
	{
		H[size]=x;
		int i=size;
		size++;
		while(i>0 && H[i].v<H[(i-1)/2].v)
		{
			Node temp=H[i];
			H[i]=H[(i-1)/2];
			H[(i-1)/2]=temp;
			i=(i-1)/2;
		}
	}

	public static void delete(Node[] H)
	{
		H[0]=H[--size];
		heapify(H,0);
	}

	public static void display (Node root, int in) 
	{
		if (!(root.left==null && root.right==null) )
		{
			display(root.left,in+1);
			display (root.right,in+1);
		}

		else
		{
			// in++;
			// System.out.print (" " + in);
			levelsum=levelsum+in*root.v;
		}
	}

}

class Node
{
	int pvalue;
	int v;
	Node left;
	Node right;
	Node()
	{
		left=null;
		right=null;
		pvalue=-1;
		v=0;
	}

	Node(Node l,Node r)
	{
		left=l;
		right=r;
		v=l.v+r.v;
		pvalue=v;
	}

	Node(int a, int b)
	{
		left=null;
		right=null;
		v=b;
		pvalue=a;
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