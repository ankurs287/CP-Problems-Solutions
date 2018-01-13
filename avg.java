// avg.java
import java.util.*;
import java.lang.*;
import java.io.*;

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
public class avg
{
	public static void main(String[] args)
	{
		try
		{
			Reader.init(System.in);
			int n=Reader.nextInt();
			int [] a=new int[n];
			int sum=0,count=0;
			for(int i=0;i<n;i++)
			{
				a[i]=Reader.nextInt();
				sum=sum+a[i];
			}
			sum=sum/n;
			for(int i=0;i<n;i++)
			{
				if(a[i]>sum)
				{
					count++;
				}
			}
			System.out.println(count);
		}
		catch(Exception e)
		{
        	// e.printStackTrace();
		}
	}
}