import java.util.*;
import java.io.*;
import java.lang.*;

class cp1g
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int t=Reader.nextInt();
        while(t-->0)
        {
            int n=Reader.nextInt();
            long[] a=new long[n+1];
            
            for(int i=1;i<=n;i++)
            {
                a[i]=Reader.nextLong();
            }
            
            while(n-->0)
            {
                int q=Reader.nextInt();
                a[q]=Integer.MIN_VALUE;

                long l=maxSequenceSum(a);
                if(l<0)
                    System.out.println(0);
                else
                    System.out.println(l);
            }
        }
    }
    public static long maxSequenceSum(long[] arr)
    {
        long maxSoFar = arr[1], maxEndingHere = arr[1];
 
        for (int i = 2; i < arr.length; i++)
        {
            /* calculate maxEndingHere */
            if (maxEndingHere < 0)
                maxEndingHere = arr[i];
            else
                maxEndingHere += arr[i];
 
            /* calculate maxSoFar */
            if (maxEndingHere >= maxSoFar)
                maxSoFar = maxEndingHere;
        }
        return maxSoFar;
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

