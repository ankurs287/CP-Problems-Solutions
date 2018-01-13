// JPS CP1
import java.util.*;
import java.lang.*;
import java.io.*;
// http://algosaur.us/segment-tree/
class cp1july_e
{
    public static int[] seg;
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int n=Reader.nextInt();
        int[] a=new int[n];

        for(int i=0;i<n;i++)
        {
            a[i]=Reader.nextInt();
        }

        seg = new int[4*n];
        build(a,0,0,n-1);

        // for(int i=0;i<seg.length;i++)
        // {
        //  System.out.print(seg[i]+" ");
        // }System.out.println();

        long profit=0;
        for(int i=0;i<n-1;i++)
        {
            int temp=query(0, 0, n-1, i+1, n-1);
            // System.out.println(temp);
            if(temp>a[i])
            {
                profit+=temp-a[i];
            }
        }
        System.out.println(profit);
    }
    public static void build(int[] a, int v,int L,int R)
    {
        if (L == R)
        {
            seg[v] = a[L];
        }
        else
        {
            int mid = (L + R) / 2 ;
            build(a, 2 * v + 1, L, mid);
            build(a, 2 * v + 2, mid + 1, R);
            seg[v] =Math.max(seg[2 * v + 1],seg[2 * v + 2]);
        }
    }
    public static int query(int v, int L, int R, int x, int y)
    {
        if (R < x || y < L)
            return 0;
        else if (x <= L && L <= R && R <= y)
            return seg[v];
        else
        {
            int mid = (L + R) / 2;
            return Math.max(query(2 * v+1, L, mid, x, y), query(2 * v + 2, mid + 1, R, x, y));
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
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}