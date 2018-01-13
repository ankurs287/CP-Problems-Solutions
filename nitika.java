import java.io.*;
import java.lang.*;
import java.util.*;
 
class nitika
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st=new StringTokenizer(in.readLine());
		int t=Integer.parseInt(st.nextToken());
 
		while(t-->0)
		{
			st=new StringTokenizer(in.readLine());
			int p=0;
 
			String[] name=new String[3];
			while(st.hasMoreTokens())
			{
				name[p++]=st.nextToken();
			}
 
			if(p==1)
			{
				System.out.println(name[0].toUpperCase().charAt(0)+""+name[0].substring(1).toLowerCase());
			}
			else if(p==2)
			{
				System.out.println(name[0].toUpperCase().charAt(0)+". "+name[1].toUpperCase().charAt(0)+""+name[1].substring(1).toLowerCase());
			}
			else if (p==3)
			{
				System.out.println(name[0].toUpperCase().charAt(0)+". "+name[1].toUpperCase().charAt(0)+". "+name[2].toUpperCase().charAt(0)+""+name[2].substring(1).toLowerCase());	
			}
		}
	}
} 