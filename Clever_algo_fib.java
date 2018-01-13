import java.lang.*;
import java.util.*;
import java.io.*;

public class Clever_algo_fib
{
	public static void main(String[] args) throws IOException
	{
        // double startTime = System.currentTimeMillis();

		Reader.init(System.in);
		long n=Reader.nextInt();
        long m=2014;
        if(n==0)
        {
        	System.out.println(0);
        	System.exit(0);
        }
        else if(n==1)
        {
        	System.out.println(1);
        	System.exit(0);
        }
        double startTime = System.currentTimeMillis();
        long[][] C=new long[2][2];
        long[][] A={{1,1},{1,0}};
        C=algo(A,n-1,m);
        System.out.println(C[0][0]);
        
        double endTime = System.currentTimeMillis();
        double TimeElapsed= (endTime-startTime)/1000;
        System.out.println(TimeElapsed);
	}
    public static long[][] algo(long[][] A,long n,long m) 
    {
        if(n==1)
            return A;
        long[][] E=algo(A,n/2,m);
        if(n%2==0)
        {
            return multiply(E,E,m);
        }
        else
        {
        	return multiply(A,multiply(E,E,m),m);
        }
	}
    public static long[][] multiply(long[][] C,long[][] B,long m)
    {
    	long[][] D=new long[2][2];
    	D[0][0]=(C[0][0]*B[0][0]+C[0][1]*B[1][0])%m;
    	D[0][1]=(C[0][0]*B[0][1]+C[0][1]*B[1][1])%m;
    	D[1][0]=(C[1][0]*B[0][0]+C[1][1]*B[1][0])%m;
    	D[1][1]=(C[1][0]*B[0][1]+C[1][1]*B[1][1])%m;
    	return D;
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