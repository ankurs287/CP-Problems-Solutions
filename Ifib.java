import java.lang.*;
import java.util.*;
import java.io.*;

public class Ifib
{
	public static void main(String[] args) throws IOException
	{
        double startTime = System.currentTimeMillis();

		Reader.init(System.in);
		long n=Reader.nextInt(),first=0,second=1,ntbs=1,m=2014;
        if(n==0) System.out.println(0);
        for(int i=1;i<n;i++)
        {
            ntbs=(first+second)%m;
            first=second;
            second=ntbs;
        }
        System.out.println(ntbs);
        
        double endTime = System.currentTimeMillis();
        double TimeElapsed= (endTime-startTime)/1000;
        System.out.println(TimeElapsed);
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