import java.util.*;
import java.lang.*;
import java.io.*;

class brokphon
{
	public static void main(String[] args) 
	{
		try
		{
			Reader.init(System.in);
			int t=Reader.nextInt();
			while(t>0)
			{
				int n=Reader.nextInt(),count=0;
				int[] a=new int[n];
				for(int i=0;i<n;i++)
				{
					a[i]=Reader.nextInt();
				}
				int check=a[0];
				for(int i=1;i<n;i++)
				{	
					if(a[i]!=check)
					{
						check=a[i];
						a[i]=-1;
						a[i-1]=-1;
					}
				}
				for(int i=0;i<n;i++)
				{
					if(a[i]==-1)
					{
						count++;
					}
				}
				System.out.println(count);
				t--;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
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