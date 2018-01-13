// JPS CP!
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class cf1
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

		long n=Reader.nextLong();
		long k=Reader.nextLong();


		long d=n/(2*(k+1));
		long c=k*d;
		long w=n-(c+d);

		System.out.println(d+" "+c+" "+w);
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