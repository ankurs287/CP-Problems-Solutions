import java.util.*;
import java.io.*;
import java.lang.*;

class cp1j
{
    public static int MAX=2000;
    public static Long m=new Long(1000000007);
    public static long[][] dp=new long[MAX+1][MAX+1];
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int i1,j1;
        for(i1=0;i1<=2000;i1++)
        {
            for(j1=0;j1<=2000;j1++)
            {
                dp[i1][j1]=-1;
            }
        }

        int t=Reader.nextInt();
        while(t-->0)
        {
            int n=Reader.nextInt();
            long[] a=new long[n];
            long sum=0;
            for(int i=0;i<n;i++)
            {
                a[i]=Reader.nextLong();
                sum=((sum%m)+(a[i]%m))%m;
            }
            Arrays.sort(a);
            for(int i=0;i<n;i++)
            {
                int le=i;
                int re=n-i-1;
                int r=Math.min(le,re);

                for(int j=1;j<=r;j++)
                {
                    int ro=(j<n-j)?j:n-j;
                    long t1=ncr(le,ro);
                    long t2=ncr(re,ro);
                    long t3=(t1*t2)%m;
                    long s1=(a[i]*t3)%m;
                    sum=(sum+s1);
                }
                sum=sum%m;
            }
            System.out.println(sum);
        }
    }
    
    // public static long ncr(int n,int r)
    // {
    //     if(n==r || r==0 || n==1 || n==0)
    //     {
    //         return 1;
    //     }
    //     if(r==1)
    //     {
    //         return n;
    //     }
    //     if(cache[n][r]==-1)
    //         cache[n][r] = ((ncr(n-1,r))+(ncr(n-1,r-1)));
    //     return cache[n][r];
    // }

    public static long ncr(int n, int r) 
    {
        if (dp[n - 1][r - 1] != -1) {
            return dp[n - 1][r - 1];
        }
        else if (n == r) {
            return 1;
        }
        else if (r == 1) {
            return n;
        }
        else {
            dp[n - 2][r - 1] = ncr(n - 1, r);
            dp[n - 2][r - 2] = ncr(n - 1, r - 1);
            dp[n - 1][r - 1] = (dp[n - 2][r - 1] + dp[n - 2][r - 2]) % 1000000007;
            return dp[n - 1][r - 1];
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

