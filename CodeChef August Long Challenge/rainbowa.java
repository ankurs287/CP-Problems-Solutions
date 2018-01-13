import java.util.*;
import java.io.*;
import java.lang.*;

class rainbowa
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0)
        {
            int n=Reader.nextInt();

            int[] a=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=Reader.nextInt();
            }
            if(n%2==0)
            {
                System.out.println("no");
                continue;
            }

            boolean f1=true, f2=true, f3=true, f4=true;
            int[] check=new int[100000];
            for (int i = 0; i < n/2; i++)
            { 
                check[a[i]]=1;
                if (a[i] > a[i + 1]) 
                    f1=false;
            }
            check[a[n/2]]=1;

            for(int i=n-1;i>n/2;i--)
                if(a[i] > a[i-1])
                    f2=false;

            for(int i=1;i<=7;i++)
                if(check[i]!=1)
                    f3=false;

            String s=Arrays.toString(a).replace(",","").replace(" ","").replace("[","").replace("]","");
            if(s.indexOf("8")>-1 || s.indexOf("9")>-1 || s.indexOf("10")>-1)
            {
               System.out.println("no");
               continue;
            }

            f4=isPalindrome(s);

            // System.out.println(f1+" "+f2+" "+f3+" "+f4);
            if(f1&&f2&&f3&&f4) System.out.println("yes");
            else System.out.println("no");
        }
    }
    public static boolean isPalindrome(String str) 
    {
        return str.equals(new StringBuilder(str).reverse().toString());
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