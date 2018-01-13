import java.util.*;
import java.lang.*;
import java.io.*;
 
class calc
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		int t=Reader.nextInt();
		while(t-->0)
		{
			long n=Reader.nextLong();
			long b=Reader.nextLong();
			long temp=n/2;
			if(temp%b==0)
			{
				System.out.println(temp*(n-temp)/b);
			}
			else
			{
				long f1=temp-(temp%b);
				long f2=temp+b; f2=f2-(f2%b);
				if(f1*(n-f1)/b >= f2*(n-f2)/b)
				{
					System.out.println(f1*(n-f1)/b);
				}
				else
				{
					System.out.println(f2*(n-f2)/b);
				}
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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
} 