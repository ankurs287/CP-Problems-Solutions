// InsertionSort
import java.lang.*;
import java.util.*;
import java.io.*;

class tut2_1
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		int n=Reader.nextInt();
		System.out.println(sum(n));
	}
	public static int sum(int n)
	{
		if(n==1) return 1;
		return n + sum(n-1);
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