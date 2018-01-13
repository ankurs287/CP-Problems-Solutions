// dectobin_rec.java
import java.lang.*;
import java.util.*;
import java.io.*;

public class dectobin_rec
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		long n=Reader.nextInt();
		System.out.println("Number in Binary: "+btd(n));
	}
	public static long btd(long n)
	{
		if(n==1)
		{
			return 1;
		}
		else if(n==0)
		{
			return 0;
		}
		else
		{
			return(n%2+10*btd(n/2));
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