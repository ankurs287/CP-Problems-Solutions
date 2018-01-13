import java.io.*;
import java.lang.*;
import java.util.*;

class unicours
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		Scanner s=new Scanner(System.in);

		int t=Integer.parseInt(in.readLine());
		StringTokenizer st;
		while(t-->0)
		{
			int n=Integer.parseInt(in.readLine());

			int[] a=new int[n];
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<n;i++)
			{
				a[i]=Integer.parseInt(st.nextToken());
			}

			Arrays.sort(a);
			int max=a[n-1];
			int ans=n-max;
			System.out.println(ans);
		}
	}
}