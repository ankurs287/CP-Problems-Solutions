import java.util.*;
import java.lang.*;
import java.io.*;

class simdish
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

		int t=Reader.nextInt();
		String[][] A=new String[t][4];

		for(int i=0;i<t;i++)
		{
			A[i][0]=Reader.next();
			A[i][1]=Reader.next();
			A[i][2]=Reader.next();
			A[i][3]=Reader.next();
		}

		for(int i=0;i<t;i++)
		{
			int in=0;
			while(in++<4)
			{
				for(int j=0;j<t;j++)
				{
					A[i][in]
				}
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
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}