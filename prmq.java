// prmq.java
import java.util.*;
import java.io.*;
import java.lang.*;

class prmq
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int n=Reader.nextInt();
        int[] a=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            a[i]=Reader.nextInt();
        }

        boolean[] prime=primeno(10000000);

        int q=Reader.nextInt();
        while(q-->0)
        {
            int l=Reader.nextInt();
            int r=Reader.nextInt();
            int x=Reader.nextInt();
            int y=Reader.nextInt();

            System.out.println(F(l, r, x, y, a, prime));
        }
        
    }

    public static int F(int L, int R, int X, int Y, int[] a, boolean[] prime) 
    {
        int result=0;
        for(int i=X;i<=Y;i++)  
        {
            if(prime[i]) 
            {
                for(int j=L;j<=R;j++)
                {
                    int number=a[j];
                    int exponent=0;
                    while( number % i == 0 ) 
                    {
                        exponent = exponent + 1 ;
                        number = number/i;
                    }
                    result = result + exponent;
                }
            }
        }
        return result;
    }

    public static boolean[] primeno(int n)
    {
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<n;i++)
        {
            prime[i] = true;
        }
         
        for(int p = 2; p*p <=n; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*2; i <= n; i += p)
                {
                    prime[i] = false;
                }
            }
        }

        prime[0]=false;
        prime[1]=false;
        return prime;
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