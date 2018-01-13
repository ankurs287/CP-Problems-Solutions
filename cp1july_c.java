import java.util.*;
import java.lang.*;
import java.io.*;
 
class cp1july_c
{
    public static long m=1000000007;
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

        int t=Reader.nextInt();
        while(t-->0)
        {
            // long n=Reader.nextLong();
            long n=t;

            long ans=(power(2,n-1)*(n*n-n+2))%m;
            ans=(ans-1+m)%m;
            // System.out.println(ans);

            if(ans!=ano(n))
            {
                System.out.println(n);
                System.out.println(ans+" "+ano(n));
            }
        }

	}
    public static long ano(long x)
    {
        long g=0;
        for(int i=1;i<=x;i++)
        {
            long h=((long)Math.pow(2,i-1))%m * (i%m) * (i+1)%m ;
            h/=2;
            g+=h;
        }
        return g;
    }
    public static long power(long a, long b)
    {
        if(b==0) return 1;
        if(b%2==1) return (a%m * power(a,b/2)%m *power(a,b/2))%m;
        return (power(a,b/2)%m * power(a,b/2))%m;
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