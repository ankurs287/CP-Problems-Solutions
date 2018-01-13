import java.util.*;
import java.lang.*;
import java.io.*;
 
class cp1july_d
{
	public static long n=0;
	public static long[] not=new long[3];
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

		n=Reader.nextLong();
		long a=Reader.nextLong();
		long b=Reader.nextLong();
		long c=Reader.nextLong();

		long ans= num(a) + num(b) + num(c) - num(lcm(a,b)) - num(lcm(a,c)) - num(lcm(b,c)) + num(lcm(lcm(a,b),c));
		System.out.println(ans);
	}
	public static long num(long x)
	{
		long g= (n-x+1)/x;
		g= n/x;
		// System.out.println(g);
		return g;
	}
	public static long lcm(long a, long b)
    {
        return (a*b)/gcd(a, b);
    }
    public static long gcd(long p, long q)
    {
        if (q == 0) 
        {
            return p;
        }
        return gcd(q, p % q);
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