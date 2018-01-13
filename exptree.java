import java.util.*;
import java.lang.*;
import java.io.*;
 
class exptree
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0)
        {
            long n=Reader.nextLong();
            
            long m = 1000000007;
            long p=((n%m)*((n%m)-1))%m;
            long q=(((2*(n%m))%m - 3)*2)%m;
            
            long c=modInverse(q, m)%m;
            System.out.print((p*c)%m+" ");

            m=1000000009;
            p=((n%m)*((n%m)-1))%m;
            q=(((2*(n%m))%m - 3)*2)%m;
            
            c=modInverse(q, m)%m;
            System.out.println((p*c)%m+" ");

        }    
    }
    public static long modInverse(long a, long m)
    {
        long g = gcd(a, m);
        if (g != 1)
        {
            // cout << "Inverse doesn't exist";
        }
        else
        {
            return(power(a, m-2, m));
        }
        return 0;
    }
     
    public static long power(long x, long y, long m)
    {
        if (y == 0)
            return 1;
        long p = power(x, y/2, m) % m;
        p = (p * p) % m;
     
        return (y%2 == 0)? p : (x * p) % m;
    }
     
    public static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
}
 
 
/** Class for buffered reading long and double values */
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