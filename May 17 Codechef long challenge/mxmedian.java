import java.io.*;
import java.lang.*;
import java.util.*;

class mxmedian
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

		int t=Integer.parseInt(in.readLine());
		StringTokenizer st;
		while(t-->0)
		{
			int n=Integer.parseInt(in.readLine());

			int[] a=new int[2*n+1];
			st=new StringTokenizer(in.readLine());
			for(int i=1;i<2*n+1;i++)
			{
				a[i]=Integer.parseInt(st.nextToken());
			}

			Arrays.sort(a);
			// int med=a[(2*n)-1];
			int[] a1=new int[2*n+1];

			int j=1;
			for(int i=n+1;i<2*n+1;i++)
			{
				a1[j]=a[i];
				j+=2;
			}

			j=2;
			for(int i=1;i<n+1;i++)
			{
				a1[j]=a[i];
				j+=2;
			}


			// System.out.println(n/2+1);
			int med=a[(3*n+1)/2];
			System.out.println(med);
			for(int i=1;i<2*n+1;i++)
			{
				System.out.print(a1[i]+" ");
			}
			System.out.println();
		}
	}
}