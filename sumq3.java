// sumq.java
import java.util.*;
import java.io.*;
import java.lang.*;

class sumq3
{
    public static long m=1000000007;
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int t=Reader.nextInt();
        while(t-->0)
        {
            int p=Reader.nextInt();
            int q=Reader.nextInt();
            int r=Reader.nextInt();

            long[] a=new long[p];
            long[] b=new long[q];
            long[] c=new long[r];


            for(int i=0;i<p;i++)
            {
                a[i]=Reader.nextLong();
            }
            for(int i=0;i<q;i++)
            {
                b[i]=Reader.nextLong();
            }
            for(int i=0;i<r;i++)
            {
                c[i]=Reader.nextLong();
            }

            Arrays.sort(a);
            Arrays.sort(b);
            Arrays.sort(c);

            long[] asum=new long[p];
            long temp=0;
            for(int i=0;i<p;i++)
            {
                temp+=a[i];
                asum[i]=temp;
            }
            long[] csum=new long[r];
            temp=0;
            for(int i=0;i<r;i++)
            {
                temp+=c[i];
                csum[i]=temp;
            }

            long sum=0;
            for(int i=0;i<q;i++)
            {
                int an=search(a, 0, p-1, b[i]);
                int cn=search(c, 0, r-1, b[i]);
                if(an==-1 || cn==-1)
                {
                    continue;
                }
                long temp1=(b[i]*b[i]*(an+1)*(cn+1))%m;
                long temp2=(b[i]*(an+1)*(csum[cn]))%m;
                long temp3=(b[i]*(cn+1)*(asum[an]))%m;
                long temp4=(asum[an]*csum[cn])%m;
                long temp5=(temp4+temp3+temp2+temp1)%m;
                sum=(sum+temp5)%m;
            }
            System.out.println(sum);

            // long[] array={10, 20, 30 , 40 , 44, 45, 88, 90};
            // System.out.println(search(array,0,7,1));
        }
    }
    public static int search(long[] array, int start, int end, long y) 
    {

       if(start==end)
          return array[start] <= y ? start : -1;

       int mid = start + (end - start) / 2;

       if( y < array[mid] )
          return search( array, start, mid, y );

       int ret = search( array, mid+1, end, y );
       return ret == -1 ? mid : ret;
    }
    // public static int searcha(long[] a, long y)
    // {
    //     int store=0;
    //     int l = 0, r = a.length - 1;
    //     while (l <= r)
    //     {
    //         int m = l + (r-l)/2;
    //         if(a[m]==y)
    //         {
    //             return m;
    //         }
    //         if (a[m] < y)
    //         {
    //             store=m;
    //             l=m+1;
    //         }
    //         else if(a[m]>y)
    //         {
    //             r = m - 1;
    //         }
    //     }
    //     return store;
    // }
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