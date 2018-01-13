// news.java
import java.util.*;
import java.lang.*;
import java.io.*;

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
public class news
{
	public static void main(String[] args)
	{
		try
		{
			
			Reader.init(System.in);
			String s=Reader.next();
			int t=Reader.nextInt();
			while(t>0)
			{
				int count=0;
				int n=Reader.nextInt();
				String sm=Reader.next();
				for(int i=0;i<s.length()-n;i++)
				{
					// System.out.println(s.substring(i,i+n)+" "+sm);
					if(s.substring(i,i+n).equals(sm))
					{
						// System.out.println(s.substring(i,i+n));
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