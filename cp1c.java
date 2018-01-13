import java.util.*;
import java.io.*;
import java.lang.*;

class cp1c
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
        for(int i=n-3;i>=0;i--)
        {
            if(a[n-2]<a[n-1] && i==n-2)
            {
                sum+=10;
                s[n-2]=10;
                o10=1;
                // System.out.println("asa");
                continue;
            }
            if(a[i]>=max)
            {
                sum+=15;
                s[i]=15;
                max=a[i];   
            }
            else if(a[i]>=a[i+1] && s[i+1]==10 && spcase==1) 
            {
                sum+=10;
                s[i]=10; 
            }
            else if(a[i]<a[i+1] && s[i+1]==10 && spcase==1) 
            {
                sum+=5;
                s[i]=5; 
            }
            else if(a[i]<=a[i+1] && s[i+1]==10 && spcase==0)
            {
                sum+=10;
                s[i]=10;   
            }
            else if(a[i]>a[i+1] && s[i+1]==10)
            {
                spcase=1;

                sum+=10;
                s[i]=10;   
            }
            else if(a[i]<=a[i+1] && s[i+1]==15)
            {
                sum+=5;
                s[i]=5;
            }
            else if(a[i]>=a[i+1] && s[i+1]==15)
            {
                sum+=15;
                s[i]=15;
            }
            else if(s[i+1]==5 && o10==1)
            {
            	if(check(a,i))
            	{
            		sum+=10;
	                s[i]=10;
            	}
            	else
            	{
            		sum+=5;
                	s[i]=5;
            	}
            }
            else if(s[i+1]==5)
            {
                sum+=5;
                s[i]=5;
            }
        }
        // int ns=0;
        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(s[i]+" ");
        //     ns+=s[i];
        // }
        // System.out.println();
        // System.out.println(ns);
        System.out.println(sum);
    }
    public static boolean check(int[] a, int i)
    {
    	int flag=0, j=i+2,cmax=Integer.MIN_VALUE;
    	for(;j<a.length;j++)
    	{
    		if(a[j]>a[i])
    		{
    			cmax=a[j];
    			flag=1;
    			break;
    		}
    	}
    	if(flag==1)
    	{
    		for(;j<a.length;j++)
    		{
    			if(a[j]<cmax)
    			{
    				// System.out.println("true");
    				return false;
    			}
    		}
    	}
    	// System.out.println("false");
    	return true;
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

