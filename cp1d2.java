import java.util.*;
import java.io.*;
import java.lang.*;

class cp1d2
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int b=Reader.nextInt();
        int c=Reader.nextInt();
        int k=Reader.nextInt();
        // int n=c-b+1,pc=0;
        c++;
        boolean a[] = new boolean[c+1];
        for(int i=0;i<c;i++)
            a[i] = true;
         
        for(int p = 2; p*p <=c; p++)
        {
            if(a[p] == true)
            {
                for(int i = p*2; i <= c; i += p)
                {
                    a[i]=false;
                }
            }
        }

        a[1]=false;
        int pc=0;
        for(int i=b;i<c;i++)
        {
            if(a[i])
                pc++;
            // System.out.println(i+" "+a[i]);
        }
        if(pc<k)
        {
            System.out.println("-1");
            return;
        }

        int count=0, max0=0;
        for (int i=b;i<c;i++)
        {
            if (a[i])
            {
                count=0;
            }
            else
            {
                count++;
                max0=Math.max(max0,count);
            }
        }

        int ws=max0+k;
        count=0;int ep=0;
        for(int i=b;i<c;i++)
        {
            if(a[i])
            {
                count++;
            }
            if(count==k)
            {
                ep=i;
                break;
            }
        }
        ws=Math.max(ep-b+1,ws);

        count=0;
        for(int i=b;i<b+ws;i++)
        {
            if(a[i])
            {
                count++;
            }
        }
        // System.out.println(ws);
        for(int i=b+ws;i<c;i++)
        {
            if(a[i-ws])
            {
                count--;
            }
            if(a[i])
            {
                count++;
            }
            if(count<k)
            {
                ws++;
                i++;
                // System.out.println(i+" "+c);
                while(i<c && !a[i])
                {
                    // System.out.println("kyu");
                    ws++;
                    i++;
                }
                if(a[i])
                {
                    count++;
                }
            }
        }
        System.out.println(ws);
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