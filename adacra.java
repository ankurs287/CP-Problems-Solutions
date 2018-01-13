import java.util.*;
import java.io.*;
import java.lang.*;

class adacra
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0)
        {
            String s=Reader.next();
            int u=0, d=0, fu=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='U' && fu==0)
                {
                    u++;
                    fu=1;
                }
                else if(s.charAt(i)=='D') fu=0;
            }
            fu=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='D' && fu==0)
                {
                    d++;
                    fu=1;
                }
                else if(s.charAt(i)=='U') fu=0;
            }
            System.out.println(Math.min(u,d));
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