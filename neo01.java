// neo01.java
import java.util.*;
import java.io.*;
import java.lang.*;

class neo01
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int t=Reader.nextInt();
        while(t-->0)
        {
            int n=Reader.nextInt();
            long[] a=new long[n];
            
            long sump=0, mulp=0, negsum=0; int j=0;
            for(int i=0;i<n;i++)
            {
                long x=Reader.nextLong();
                if(x>=0)
                {
                    sump+=x;
                    mulp++;
                }
                else
                {
                    negsum+=x;
                    a[j]=x;
                    j++;
                }
            }

            Arrays.sort(a);

            long tempsum=mulp*sump+negsum;

            long chosen=0;
            for(int i=j-1;i>=0;i--)
            {
                long x=((mulp+1)*sump)+((mulp+1)*(a[i]+chosen));
                x=x+negsum-a[i];
                // System.out.println(x);
                if(x>=tempsum)
                {
                    tempsum=x;
                    negsum=negsum-a[i];
                    mulp++;
                    chosen=chosen+a[i];
                }
            }
            // System.out.println(mulp+" "+negsum);
            // tempsum=(sump+negsum)*mulp;

            // for(int i=0;i<j;i++)
            // {
            //     if(chosen[i]!=1)
            //     {
            //         tempsum+=a[i];
            //     }
            // }
            // System.out.println(chosen+" "+negsum);
            System.out.println(tempsum);



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

