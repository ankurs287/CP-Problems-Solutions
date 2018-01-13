import java.util.*;
import java.io.*;
import java.lang.*;

class cp1c1
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int n=Reader.nextInt();

        int[] a=new int[n];
        int[] s=new int[n];

        for(int i=0;i<n;i++)
        {
            a[i]=Reader.nextInt();
        }

        if(n==1)
        {
            System.out.println("15");
            return;
        }
        if(n==2)
        {
            if(a[0]>=a[1])
            {
                System.out.println("30");
            }
            else
            {
                System.out.println("25");
            }
            return;
        }

        int sum=15, max=a[n-1], spcase=0, o10=0;
        s[n-1]=15;

        for(int i=n-2;i>=0;i--)
        {
            if(a[i]>=max)
            {
                sum+=15;
                s[i]=15;
                max=a[i]; 
            }
            else
            {   
                int j=0,cmax=Integer.MIN_VALUE,res=0;
                for(j=i+1;j<n;j++)
                {
                    if(a[j]>a[i])
                    {
                        cmax=a[j];
                        res=10;
                        break;
                    }
                }
                j++;
                for(;j<n;j++)
                {
                    if(a[j]<cmax)
                    {
                        res=5;
                        break;
                    }
                }
                sum+=res;
                s[i]=res;
            }
        }
        // int ns=0;
        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(s[i]+" ");
        //     ns+=s[i];
        // }
        // System.out.println();
        System.out.println(sum);
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

