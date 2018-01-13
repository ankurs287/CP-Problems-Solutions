import java.util.*;
import java.lang.*;
import java.io.*;

public class d2_429_a
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

		int n=Reader.nextInt();
		int k=Reader.nextInt();

		String s=Reader.next();
		char[] a=s.toCharArray();

		int[] freq=new int[26];
		for(int i=0;i<n;i++)
		{
			freq[a[i]-'a']++;
		}
		int f=1;
		for(int i=0;i<26;i++)
		{
			if(freq[i]>k)
			{
				System.out.println("NO");
				f=0;
				break;
			}
		}
		if(f==1)
			System.out.println("YES");
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