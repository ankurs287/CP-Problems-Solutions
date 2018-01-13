import java.io.*;
import java.lang.*;
import java.util.*;

class chefrout
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

		int t=Integer.parseInt(in.readLine());

		while(t-->0)
		{
			char[] n=in.readLine().toCharArray();
			int flag=1;
			for(int i=1;i<n.length;i++)
			{
				if(n[i]<n[i-1])
				{
					flag=0;
					System.out.println("no");
					break;
				}
			}
			if(flag==1)
			{
				System.out.println("yes");
			}

		}
	}
}