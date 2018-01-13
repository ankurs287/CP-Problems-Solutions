// sumq.java
import java.util.*;
import java.io.*;
import java.lang.*;

class sumq1
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

            long[][] help=new long[4][q]; //help[0]=a's end , help[2]=c' end
            
            long stemp=0;
            for( long i: a)
            {
                stemp=((stemp%m)+(i%m))%m;
            }
            for(int i=0;i<q;i++)
            {
                help[0][i]=p-1;
                help[1][i]=stemp;
            }

            stemp=0;
            for( long i: c)
            {
                stemp=((stemp%m)+(i%m))%m;
            }
            for(int i=0;i<q;i++)
            {
                help[2][i]=r-1;
                help[3][i]=stemp;
            }
            // ok
            // for(int i=0;i<q;i++)
            // {
            //     System.out.println(help[0][i]+" "+help[1][i]+" "+help[2][i]+" "+help[3][i]);
            // }

            int j=0; stemp=0;
            for(int i=0;i<q;i++)
            {
                for(;j<p;j++)
                {
                    stemp=((stemp%m)+(a[j]%m))%m;
                    if(a[j]>b[i])
                    {
                        stemp=stemp-a[j];
                        help[0][i]=j-1;
                        help[1][i]=stemp;
                        break;
                    }
                }
            }

            j=0;
            stemp=0;
            for(int i=0;i<q;i++)
            {
                for(;j<r;j++)
                {
                    stemp=((stemp%m)+(c[j]%m))%m;
                    if(c[j]>b[i])
                    {
                        stemp=stemp-c[j];
                        help[2][i]=j-1;
                        help[3][i]=stemp;
                        break;
                    }
                }
            }

            // for(int i=0;i<q;i++)
            // {
            //     System.out.println(b[i]+": "+help[0][i]+" "+help[1][i]+" "+help[2][i]+" "+help[3][i]);
            // }

            long sum=0;
            for(int i=0;i<q;i++)
            {
                if(help[0][i]>=0 && help[2][i]>=0)
                {
                    stemp=((help[0][i]+1)*b[i])%m;
                    stemp=((stemp%m)+(help[1][i]%m));

                    long stemp2=((help[2][i]+1)*b[i])%m;
                    stemp2=((stemp2%m)+(help[3][i]%m))%m;

                    sum=(sum+((stemp*stemp2)%m))%m;
                    stemp=0;
                    stemp2=0;
                }
            }
            System.out.println(sum);


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

