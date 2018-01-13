// dsa1.java
import java.lang.*;
import java.util.*;
import java.io.*;

public class dsa1
{
	public static void main(String[] args)
	{
		try
		{
			Reader.init(System.in);
			int t=Reader.nextInt();
			while(t>0)
			{
				String s1=Reader.next();
				String s2=Reader.next();
				// System.out.println(s1+" "+s2);
				int[] f1=new int[26];
				int[] f2=new int[26];
				for(int i=0;i<s1.length();i++)
				{
					f1[s1.charAt(i)-'a']++;
				}
				for(int i=0;i<s2.length();i++)
				{
					f2[s2.charAt(i)-'a']++;
				}
				for(int i=0;i<26;i++)
				{
					// System.out.println(f1[i]+" "+f2[i]);
					if(f1[i]<=f2[i])
					{
						for(int j=0;j<f1[i];j++)
						{
							int tp=i+97;
							System.out.print((char)tp);
						}
						// char tp=f1[i]+'a';
						// System.out.print(tp);
					}
					else
					{
						for(int j=0;j<f2[i];j++)
						{
							int tp=i+97;
							System.out.print((char)tp);
						}
						// System.out.print((char)(f2[i]+'a'));	
					}
				}
				System.out.println();
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