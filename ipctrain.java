import java.util.*;
import java.lang.*;
import java.io.*;
 
class ipctrain
{
	public static int size=0;
	public static long[][] H;
	public static void insert(long[] x, long[][] H)
	{
		int i=size;
		H[size]=x;
		size++;
		while(i>0 && H[i][2] > H[(i-1)/2][2])
		{
			long[] temp=H[i];
			H[i]=H[(i-1)/2];
			H[(i-1)/2]=temp;

			i=(i-1)/2;
		}
	}
	public static void MaxHeapify(int i,long[][] H)
	{
		int n=size-1;
		boolean flag=true;
		while(i<=(n-1)/2 && flag)
		{
			int min=i;
			if(H[i][2] < H[2*i+1][2]) min=2*i+1;
			if(2*i+2<=n && H[min][2]<H[2*i+2][2])	min=2*i+2;
			if(min!=i)
			{
				long[] temp=H[i];
				H[i]=H[min];
				H[min]=temp;
				i=min;
			}
			else
				flag=false;
		}
	}
	public static void remove(long[][] H)
	{
		if(size>1)
			H[0]=H[size-1];
		size--;
		MaxHeapify(0,H);
	}
	public static long solve(long[][] H)
	{
		long so=0;
		for(int i=0;i<size;i++)
		{
			so+=(H[i][1]*H[i][2]);
			// System.out.println(H[i][0]+" "+H[i][1]+" "+H[i][2]);
		}
		return so;
	}
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		int t=Reader.nextInt();
		while(t-->0)
		{
			int n=Reader.nextInt();
			int d=Reader.nextInt();
			
			long[][] a=new long[n][3];
			// long sadness=0;
			for(int i=0;i<n;i++)
			{
				a[i][0]=Reader.nextLong();
				a[i][1]=Reader.nextLong();
				a[i][2]=Reader.nextLong();

				// sadness+=(a[i][2]*a[i][1]);
			}

			Arrays.sort(a, ORDER_BY_RULES);
			H=new long[n][3];

			int j=0;
			for(int i=1;i<=d;i++)
			{
				while(j<n && a[j][0]==i)
				{
					insert(a[j], H);
					j++;
				}
				if(size>0)
				{
					if(H[0][1]>1)
						H[0][1]--;

					else
						remove(H);
				}
			}
			long ss=solve(H);
			// System.out.println((ss<0?0:ss));
			System.out.println(ss);
			size=0;
		}
	}
	static final Comparator<long[]> ORDER_BY_RULES = new Comparator<long[]>() 
	{
		public int compare(long[] entry1, long[] entry2) 
		{
            return (int)entry1[0] - (int)entry2[0];
		}
	};
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