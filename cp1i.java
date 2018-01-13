import java.util.*;
import java.io.*;
import java.lang.*;

 class cp1i
{   
    public static long a=0;
    public static long b=0;
    public static long f1=0;
    public static long f2=0, l=0,r=0;
    public static long[] sum;
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int n=Reader.nextInt();
        int q=Reader.nextInt();

        f1=Reader.nextLong();
        f2=Reader.nextLong();

        a=Reader.nextLong();
        b=Reader.nextLong();

        long[] x=new long[n+1];
        for(int i=1;i<=n;i++)
        {
            x[i]=Reader.nextLong();
        }

        sum=new long[n+1];
        while(q-->0)
        {
            l=Reader.nextLong();
            r=Reader.nextLong();


            // System.out.println(func(3));

            long max=r-l+1;
            x[r]+=func()
            count[max]++;
        }







        // for(int i=1;i<=n;i++)
        // {
        //     System.out.print(sum[i]+" ");
        // }
    }
    public static long func(long i)
    {
        if(i==1)
        {
            return f1;
        }
        else if(i==2)
        {
            return f2;
        }
        else
        {
            long ans=a*func(i-2)+b*func(i-1);

            sum[(int)(r)]+=ans;
            r--;
            // System.out.println(ans);
            return ans;
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

