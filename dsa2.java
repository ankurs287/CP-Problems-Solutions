import java.lang.*;
import java.util.*;
import java.io.*;

public class dsa2
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		int cap=Reader.nextInt();
		int n=Reader.nextInt();
		int q=Reader.nextInt();
		int[] a=new int[cap];
		for(int i=0;i<n;i++)
		{
			a[i]=Reader.nextInt();
		}
		for(int i=0;i<q;i++)
		{
			int f=Reader.nextInt();
			if(f==1) //perform Insert
			{
				int shifts=0;
				int nti=Reader.nextInt();
				if(n<cap)
				{
					int index=0;
					while(a[index]<nti && index<n)
					{
						index++;
					}
					for(int j=n-1;j>=index;j--)
					{
						a[j+1]=a[j];
						// shifts++;
					}
					// System.out.println("nti: "+nti+"index: "+index+"numb: "+a[index]);
					n++;
					shifts=n-index-1;
					a[index]=nti;
				}
				System.out.println(n+" "+shifts);
			}
			else if(f==2) //perform deletion
			{
				int x=Reader.nextInt();
				int index=0,shifts2=0;
				while(a[index]!=x){
					index++;
				}
				for(int j=index;j<n-1;j++)
				{
					a[j]=a[j+1];
					// shifts++;
					// System.out.println("yo");
				}
				n--;
				shifts2=n-index;
				System.out.println(n+" "+shifts2);
			}
			else if(f==3) //display array	
			{
				for(int j=0;j<n;j++)
				{
					System.out.print(a[j]+" ");
				}
				System.out.println();
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