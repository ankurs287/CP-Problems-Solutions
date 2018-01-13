import java.util.*;
import java.lang.*;
import java.io.*;
 
class chefsign2
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		int t=Reader.nextInt();
		while(t-->0)
		{
			String in=Reader.next();
			int n=in.length();
			int max=1, curr=1, min=1;
			int curr1=0, curr2=0, ml=0, mg=0;
			for(int i=0;i<n;i++)
			{
				String q=""+in.charAt(i);
				if(q.equals("<"))
				{
					curr1++;
					curr2=0;
				}
				else if(q.equals(">"))
				{
					curr2++;
					curr1=0;
				}
				if(curr1>ml)
				{
					ml=curr1;
				}
				if(curr2>mg)
				{
					mg=curr2;
				}
			}
			System.out.println(Math.max(mg,ml)+1);
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