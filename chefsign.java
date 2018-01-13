import java.util.*;
import java.lang.*;
import java.io.*;
 
class chefsign
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		int t=Reader.nextInt();
		while(t-->0)
		{
			String[] a=new String[1000000];

			// BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
			String in=Reader.next();

			int j=0;
			int f=0, flag=0,l=0;
			for(int i=1;j<in.length();i+=2)
			{
				a[i]=""+in.charAt(j);
				j++;
				if(a[i].equals("<") && flag==0)
				{
					f=i;
					flag=1;
				}
				else if(a[i].equals(">"))
				{
					l=i;
				}
			}

			j=in.length();
			if(flag==1)
			{
				a[f-1]="1";
				a[f+1]="2";
				for(int i=f+2;i<2*j+1;i+=2)
				{
					if(a[i].equals(">")) a[i+1]=""+(Integer.parseInt(""+a[i-1])-1);
					else if(a[i].equals("<")) a[i+1]=""+(Integer.parseInt(""+a[i-1])+1);
					else a[i+1]=a[i-1];
				}
				for(int i=f-2;i>=0;i-=2)
				{
					if(a[i].equals("<")) a[i-1]=""+(Integer.parseInt(""+a[i+1])+1);
					else if(a[i].equals("<")) a[i-1]=""+(Integer.parseInt(""+a[i+1])-1);
					else a[i-1]=a[i+1];
				}
			}
			else
			{
				a[l+1]="1";
				a[l-1]="2";
				for(int i=l-2;i>=0;i-=2)
				{
					if(a[i].equals(">")) 
					{
						a[i-1]=""+(Integer.parseInt(""+a[i+1])+1);
						// System.out.println(i+" "+a[i+1]+" "+a[i-1]);
					}
					else a[i-1]=a[i+1];
				}
			}

			int ans=1;
			if(flag==1)
			{
				int min=Integer.MAX_VALUE;
				int max=Integer.MIN_VALUE;
				for(int i=0;i<2*j+1;i+=2)
				{
					if(Integer.parseInt(""+a[i])<min)
					{
						min=Integer.parseInt(""+a[i]);
					}
					if(Integer.parseInt(""+a[i])>max)
					{
						max=Integer.parseInt(""+a[i]);
					}
				}

				max=max+1-(min);
				System.out.println(max);
				for(int i=0;i<2*j+1;i++)
				{
					System.out.print(a[i]+" ");
				}
				System.out.println();
				continue;
			}

			System.out.println(a[0]);


			// for(int i=0;i<2*j+1;i++)
			// {
			// 	System.out.print(a[i]+" ");
			// }
			// System.out.println();
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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
} 