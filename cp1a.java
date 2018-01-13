import java.util.*;
import java.io.*;
import java.lang.*;

class cp1a
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int n=Reader.nextInt();
        int m=Reader.nextInt();

        int[] a=new int[n];
        int[] af=new int[n];
        int[] mic=new int[n];

        for(int i=0;i<n;i++)
        {
            a[i]=Reader.nextInt();
            af[i]=a[i];
            mic[i]=1;
        }

        Arrays.sort(a);
        Arrays.sort(af);

        m=m-n;
        
        while(m-->0)
        {
            int max=fmax(af);
            mic[max]++;
            af[max]=(int)Math.ceil((double)a[max]/mic[max]);
        }

        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(af[i]+" ");
        // }
        System.out.println(af[fmax(af)]);
    }

    public static int fmax(int[] b)
    {
        int maxIndex=0;
        for (int i=1;i<b.length;i++)
        {
            int n=b[i];
            if(n>b[maxIndex]) 
            {
                maxIndex=i;
            }
        }
        return maxIndex;
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

