// JPS CP!
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class cf2
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

		int n=Reader.nextInt();
		int m=Reader.nextInt();

        int[] l=new int[m];
        for(int i=0;i<m;i++)
        {
            l[i]=Reader.nextInt();
        }

        int[] a=new int[n+1];
        int j=0;
        for(int i=0;i<m-1;i++)
        {
            int x=(l[i+1]-l[i])%n;
            // System.out.println(x);
            if(x==0)
            {
                a[l[j]]=n;
            }
            else
            {
                a[l[j]]=Math.abs(x);
            }
            j++;
        }

        for(int i=1;i<=n;i++)
        {
            if(a[i]==0)
            {
                System.out.println("-1");
                return;
            }
        }
        for(int i=1;i<=n;i++)
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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}