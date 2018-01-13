// unionset.java
import java.util.*;
import java.io.*;
import java.lang.*;

class unionset
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int t=Reader.nextInt();
        while(t-->0)
        {
            int n=Reader.nextInt();
            int k=Reader.nextInt();
            
            int[][] a=new int[n][2501];

            for(int i=0;i<n;i++)
            {
            	int j=Reader.nextInt();
            	while(j-->0)
            	{
            		int x=Reader.nextInt();
            		a[i][x]=x;
            	}
            }

            int count=0;
            int pairs=n*(n-1)/2;
            for(int i=0;i<n;i++)
            {
            	for(int j=i+1;j<n;j++)
            	{
            		for(int p=1;p<=k;p++)
            		{
            			if(a[i][p]!=p && a[j][p]!=p)
            			{
            				pairs--;
            				break;
            			}
            		}
            	}
            }
            System.out.println(pairs);
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

