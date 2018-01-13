// goodset.java
import java.util.*;
import java.io.*;
import java.lang.*;

class goodset
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int t=Reader.nextInt();
        while(t-->0)
        {
            int n=Reader.nextInt();

            int[] a=new int[n];
            a[0]=1; 
            if(n>1)
                a[1]=2;
            if (n>2)
                a[2]=4;

            for(int i=3;i<n;i++)
            {
                a[i]=a[i-1]+3;
            }

            for(int i=0;i<n;i++)
            {
                System.out.print(a[i]+" ");
            }
            System.out.println();
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

