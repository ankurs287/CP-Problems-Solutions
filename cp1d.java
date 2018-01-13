import java.util.*;
import java.io.*;
import java.lang.*;

class cp1d
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int b=Reader.nextInt();
        int c=Reader.nextInt();
        int k=Reader.nextInt();
        int n=c-b+1,pc=0;
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

	    int count=0, max0=0,ep=0;
	    for (int i=0;i<n;i++)
	    {
	    	if (a[i])
	    	{
	            count=0;
	    	}
	        else
	        {
	            count++;
	            if(count>max0)
	            {
	            	ep=i;
	            }
	            max0=Math.max(max0,count);
	        }
	    }

        count=0;
        int[] e=new int[n];
        e[0]=ep;int j=1;
        for(int i=ep+2;i<n;i++)
        {
        	if(a[i])
        	{
        		count=0;
        	}
        	else
        	{
        		count++;
        		if(count==max0)
        		{
        			e[j]=i;
        			j++;
        			count=0;
        		}
        	}
        }

        int q=0,lws=0;int ws=0;
        while(q<j)
        {
        	ep=e[q];
        	q++;
        	int sp=ep-max0+1;
        	ws=max0+k;
        	int ws1=1; int flag=0;
        	count=0;


        for(int i=ep+1;i<n;i++)
        {
        	if(a[i])
        	{
        		count++;
        	}
        	if(count==k)
        	{
        		ws1=i-sp+1;
        		flag=1;
        		break;
        	}
        }

		if(flag!=1)
		{
			for(int i=sp-1;i>=0;i--)
			{
				if(a[i])
				{
					count++;
				}
				if(count==k)
	        	{
	        		ws1=n-i;
	        		flag=1;
	        		break;
	        	}
			}
		}

		int ws2=1;flag=0;count=0;
		for(int i=sp-1;i>=0;i--)
		{
			if(a[i])
			{
				count++;
			}
			if(count==k)
        	{
        		ws2=ep-i+1;
        		flag=1;
        		break;
        	}
		}
		if(flag!=1)
		{
			for(int i=ep+1;i<n;i++)
			{
				if(a[i])
				{
					count++;
				}
				if(count==k)
	        	{
	        		ws2=i+1;
	        		flag=1;
	        		break;
	        	}
			}
		}
        ws=Math.max(ws1,ws2);
        ws=Math.max(ws,lws);
        lws=ws;
}    
        System.out.println(ws);

        // if(valid(a,ws,k))
        // {
        // 	System.out.println("yoho");
        // }
        // for(;ws<=j;ws++)
        // {
        //     if(valid(a,ws,k))
        //     {
        //         System.out.println(ws);
        //         return;
        //     }
        // }
        // System.out.println("-1");
    }

    public static boolean valid(int[] a,int ws, int k)
    {
        int s=0, e=s+ws-1, count=0, flag=0;
        for(;e<a.length;e++)
        {
            for(int i=s;i<=e;i++) //no of 1s in that window
            {
                if(a[i]==1)
                {
                    count++;
                }
                if(count==k)
                {
                    flag=1;   
                    break;
                }
            }
            if(flag==0)
            {
                return false;
            }
            flag=count=0;
            s++;
        }
        return true;
    }

    public static boolean isPrime(int n) 
    {
        if(n==1)
        {
            return false;
        }
        if(n>2 && (n&1)==0)
        {
           return false;
        }
        
        for(int i = 3; i * i <= n; i += 2)
        {
            if (n % i == 0)
            { 
                return false;
            }
        }
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