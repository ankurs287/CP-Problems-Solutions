// Spoon.java
import java.lang.*;
import java.util.*;
import java.io.*;

class Spoon
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		int t=Reader.nextInt();
		while(t>0)
		{
			char[] sp={'s','p','o','o','n'};
			int r=Reader.nextInt();
			int c=Reader.nextInt();
			char[][] p=new char[r][c];
			for(int i=0;i<r;i++)
			{
				String s=Reader.next();
				s.toLowerCase();
				p[i]=s.toCharArray();

			}

			// System.out.println(p.length);
			int k=0;
			for(int i=0;i<r;i++)
			{
				for(int j=0;j<c && k<5;j++)
				{
					char a=p[i][j];
					char b=sp[k];
					if(a==b)
					{
						k++;
						if(k==5)
						{
							break;
						}
					}
					else
					{
						k=0;
					}
				}
			}
			if(k!=5)
			{
				for(int i=0;i<c;i++)
				{
					for(int j=0;j<r && k<5;j++)
					{
						char a=p[j][i];
						char b=sp[k];
						if(a==b)
						{
							k++;
							System.out.println(k);
							if(k==5)
							{
								break;
							}
						}
						else
						{
							k=0;
						}
					}
				}	
			}
			if(k==5)
			{
				System.out.println("yo");
			}
			else
			{
				System.out.println("no");
			}
			t--;
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