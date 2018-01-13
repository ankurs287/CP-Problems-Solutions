import java.util.*;
import java.io.*;
import java.lang.*;

class cp1e
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

        Arrays.sort(a);

        int[] b=new int[n+1];

        int j=1;
        for(int i=1;i<=n;i+=2)
        {
            b[i]=a[j];
            j++;
        }

        for(int i=2;i<=n;i+=2)
        {
            b[i]=a[j];
            j++;
        }

        for(int i=2;i<=n;i+=2)
        {
            if(b[i]<b[i-1])
            {
                System.out.println("Impossible1");
                return;
            }
        }

        for(int i=3;i<=n;i+=2)
        {
            if(b[i]>b[i-1])
            {
                System.out.println("Impossible");
                return;
            }
        }

        for(int i=1;i<=n;i++)
        {
            System.out.print(b[i]+" ");
        }
        System.out.println();
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

