// JPS CP1
import java.util.*;
import java.lang.*;
import java.io.*;
// http://algosaur.us/segment-tree/
class jps_c
{
	public static int[] seg;
	public static int[] org;
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

		int n=Reader.nextInt();
		int[] a=new int[n];

		for(int i=0;i<n;i++)
		{
			a[i]=Reader.nextInt();
		}

		seg = new int[4*n];
		org=new int[4*n];
		for(int i=0;i<4*n;i++)
		{
			org[i]=-1;
		}
		build(a,0,0,n-1);

		// for(int i=0;i<seg.length;i++)
		// {
		// 	System.out.print(seg[i]+" ");
		// }System.out.println();

		int q=Reader.nextInt();
		while(q-->0)
		{
			int c=Reader.nextInt();
			if(c==1)
			{
				int x=Reader.nextInt();
				System.out.println(query(x,n));
				// System.out.println("yes");
			}
			else
			{
				int qq=Reader.nextInt();
				int val=Reader.nextInt();
				update(0,0,n-1,qq,val);
				// for(int i=0;i<seg.length;i++)
				// {
				// 	System.out.print(seg[i]+" ");
				// }System.out.println();
				// System.out.println("updated");
			}
		}

	}
	public static void build(int[] a, int v,int L,int R)
	{
	    if (L == R)
	    {
	        seg[v] = zeroes(a[L]);
	        org[v] = L;
	    }
	    else
	    {
	        int mid = (L + R) / 2 ;
	       	build(a, 2 * v + 1, L, mid);
	        build(a, 2 * v + 2, mid + 1, R);
	        seg[v] =seg[2 * v + 1] + seg[2 * v + 2];
	    }
	}

	public static int zeroes(int num)
	{
		String s=Integer.toString(num);
		int count = s.length() - s.replaceAll("0", "").length();
		return count;
	}
	public static int query(int x,int n)
	{
	    if(x>seg[0])
	    {
	    	return -1;
	    }

	    int p=0;
	    int add=0;
	    while(true)
	    {
    		if(seg[2*p+1]+add>=x)
    		{
    			p=2*p+1;
    		}
	    	else
	    	{
	    		add+=seg[2*p+1];
	    		p=2*p+2;
	    	}
	    	// System.out.println(p);
	    	if(org[p]!=-1)
	    	{
	    		return org[p];
	    	}
	    }
	}
	public static void update(int v, int L, int R, int x, int y)
	{
	    if(L <= x && x <= R)
	    { 
	        if (L == R)
	        {
	            seg[v]= zeroes(y);
	            org[v]= x;
	        }
	        else
	        {
	            int mid = (L + R) / 2;
	            update(2 * v + 1, L, mid, x, y);
	            update(2 * v + 2, mid + 1, R, x, y);

	            seg[v] = seg[2 * v+2] + seg[2 * v + 1];
	        }
	    }
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