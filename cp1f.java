import java.util.*;
import java.io.*;
import java.lang.*;

class cp1f
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

		int n=Reader.nextInt();

		int[][] a=new int[n][2];
		for(int i=0;i<n;i++)
		{
			a[i][0]=Reader.nextInt();
			a[i][1]=Reader.nextInt();
		}

		//sorting y coordinates
		Arrays.sort(a, new java.util.Comparator<int[]>() { public int compare(int[] c, int[] b) { return (c[1] < b[1] ? -1 : (c[1] == b[1] ? 0 : 1));}});
		long curr=a[0][1], currc=0, sum1=0;
		for(int i=1;i<n;i++)
		{
			if(a[i][1]==curr)
			{
				currc++;
			}
			else
			{
				sum1+=fact(currc);
				curr=a[i][1];
				currc=0;
			}
		}
		sum1+=fact(currc);
		// System.out.println(sum1);

		// System.out.println("----yyy-----");
		// for(int i=0;i<n;i++)
		// {
		//     System.out.println(a[i][0]+" "+a[i][1]);
		// }
		// System.out.println("------");
		
		//sorting x coordinates
		Arrays.sort(a, new java.util.Comparator<int[]>() { public int compare(int[] c, int[] b) { return (c[0] < b[0] ? -1 : (c[0] == b[0] ? 0 : 1));}});
		currc=0;curr=a[0][0];long sum2=0;
		for(int i=1;i<n;i++)
		{
			if(a[i][0]==curr)
			{
				currc++;
			}
			else
			{
				sum2+=fact(currc);
				curr=a[i][0];
				currc=0;
			}
		}
		sum2+=fact(currc);
		// System.out.println(sum2);
		

		// System.out.println("------xxx-----");
		// for(int i=0;i<n;i++)
		// {
		//     System.out.println(a[i][0]+" "+a[i][1]);
		// }
		// System.out.println("------");

		//finding duplicates
		long dupl=0, sum3=0;
		for(int i=0;i<n-1;i++)
		{
			if(a[i][1]==a[i+1][1] && a[i][0]==a[i+1][0])
			{
				dupl++;
			}
			else
			{
				sum3+=fact(dupl);
				dupl=0;
			}
		}
		sum3+=fact(dupl);
		// System.out.println(sum3);
		System.out.println(sum1+sum2-sum3);
	}

	public static long fact(long n) 
	{
		long fact=n*(n+1);
		return fact/2;
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

	static long nextLong() throws IOException {
		return Long.parseLong( next() );
	}
	
	static double nextDouble() throws IOException {
		return Double.parseDouble( next() );
	}
}

