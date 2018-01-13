import java.lang.*;
import java.util.*;
import java.io.*;

public class Rfib
{
	public static void main(String[] args) throws IOException
	{
        double startTime = System.currentTimeMillis();

		Reader.init(System.in);
		long n=Reader.nextInt();
        long m=2014;
        System.out.println(rfib(n,m));
        
        double endTime = System.currentTimeMillis();
        double TimeElapsed= (endTime-startTime)/1000;
        System.out.println(TimeElapsed);
	}
    public static long rfib(long n,long m) 
    {
        if(n==1)
            return 1;
        else if(n==0)
            return 0;
        else
        {
            return (rfib(n-1,m)+rfib(n-2,m))%m;
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