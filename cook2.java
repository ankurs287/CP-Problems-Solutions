import java.util.*;
import java.lang.*;
import java.io.*;
 
class cook2
{
    public static void main(String[] args) throws IOException
	{
        Reader.init(System.in);

        int t=Reader.nextInt();
        while(t-->0)
        {
            int n=Reader.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=Reader.nextInt();
            }
            int count=0;
            for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    int te=a[i] | a[j];
                    if(te<= Math.max(a[i],a[j]))
                        count++;
                }
            }
            System.out.println(count);
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