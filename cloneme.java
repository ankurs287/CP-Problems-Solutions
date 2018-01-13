// cloneme.java
import java.util.*;
import java.io.*;
import java.lang.*;

class cloneme
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int t=Reader.nextInt();
        while (t-->0) 
        {
            int n=Reader.nextInt();
            int q=Reader.nextInt();

            int[] arr=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=Reader.nextInt();
            }

            while(q-->0)
            {
                int a=Reader.nextInt()-1;
                int b=Reader.nextInt()-1;
                int c=Reader.nextInt()-1;
                int d=Reader.nextInt()-1;

                int l=b-a+1;

                int[] a1=new int[l];
                int[] a2=new int[l];
                int j=0;
                for(int i=a;i<=b;i++)
                {
                    a1[j]=arr[i];
                    j++;
                }
                j=0;
                for(int i=c;i<=d;i++)
                {
                    a2[j]=arr[i];
                    j++;
                }

                Arrays.sort(a1);
                Arrays.sort(a2);
                
                int count=0;
                for(int i=0;i<l;i++)
                {
                    if(a1[i]!=a2[i])
                    {
                        count++;
                    }
                    if(count>1)
                    {
                        break;
                    }
                }

                if(count<2)
                    System.out.println("YES");
                else
                    System.out.println("NO");
                   
            }
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