import java.lang.*;
import java.util.*;
import java.io.*;

public class tut3
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		int n=Reader.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=Reader.nextInt();
		}
		int s=Reader.nextInt();
		int low=0,high=n-1;
		System.out.println("index: "+bin(a,s,low,high));
	}
	public static int bin(int[] a,int s,int low,int high)
	{
		if(low>high)
		{
			System.out.println("Not Found");
			return -1;
		}
		else
		{
			int mid=(low+high)/2;
			if(s==a[mid])
			{
				// System.o
				return mid;
			}
			else if(s<a[mid])	
			{
				return bin(a,s,low,mid-1);
			}
			else
			{
				return bin(a,s,mid+1,high);
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
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}