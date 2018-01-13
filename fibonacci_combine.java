// fibonacci_combine.java
import java.lang.*;
import java.util.*;
import java.io.*;

public class fibonacci_combine
{
	public static long Ifib(long n,long m)
	{
		long first=0,second=1,ntbs=1;
        if(n==0)
        	return 0;
        for(int i=1;i<n;i++)
        {
            ntbs=(first+second)%m;
            first=second;
            second=ntbs;
        }
        return ntbs;
	}

    public static long Rfib(long n,long m) 
    {
        if(n==1)
            return 1;
        else if(n==0)
            return 0;
        else
        {
            return (Rfib(n-1,m)+Rfib(n-2,m))%m;
        }
    }
    public static long[][] clever_algo(long[][] A,long n,long m) 
    {
    	if(n==0 || n==1)
    	{
    		return A;
    	}
    	// else if(n==0)
    	// {
    	// 	long[][] Z={{1,1},{1,1}};
    	// 	return Z;
    	// }
        if(n==1)
            return A;
        long[][] E=clever_algo(A,n/2,m);
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

	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		double a=Reader.nextDouble();
		long n=(long)a;
		long m=2014;

     	double startTime = System.currentTimeMillis();   
        System.out.println(Ifib(n,m));
        double endTime = System.currentTimeMillis();
        double TimeElapsed= (endTime-startTime)/1000.0;
        System.out.println(TimeElapsed);

        startTime = System.currentTimeMillis();
        System.out.println(Rfib(n,m));
        endTime = System.currentTimeMillis();
        TimeElapsed= (endTime-startTime)/1000.0;
        System.out.println(TimeElapsed);

        long[][] A={{1,1},{1,0}};
	    startTime = System.currentTimeMillis();
        System.out.println(clever_algo(A,n,m)[0][0]);
        endTime = System.currentTimeMillis();
        TimeElapsed= (endTime-startTime)/1000.0;
        System.out.println(TimeElapsed);
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