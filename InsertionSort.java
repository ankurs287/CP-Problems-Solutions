// InsertionSort
import java.lang.*;
import java.util.*;
import java.io.*;

class InsertionSort
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
		// Insertion Sort
		for(int i=1;i<n;i++)
		{
			int j=i;
			while(j>0 && a[j-1]>a[j])
			{
				int temp=a[j];
				a[j]=a[j-1];
				a[j-1]=temp;
				j--;
			}
		}
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
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