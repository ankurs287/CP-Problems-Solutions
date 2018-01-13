import java.io.*;
import java.lang.*;
import java.util.*;

class subs2
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(in.readLine());
		int n=Integer.parseInt(st.nextToken());
		double k=Double.parseDouble(st.nextToken());
		
		st=new StringTokenizer(in.readLine());
		ArrayList<Double> b=new ArrayList<Double>();

		int ones=0,j=0;
		while(st.hasMoreTokens())
		{
			double x=Double.parseDouble(st.nextToken());
			if(x<=k && x!=1)
			{
				b.add(x);
				j++;
			}
			if(x==1)
			{
				ones++;
			}
		}

		Collections.sort(b);

		ArrayList<Double> a=new ArrayList<Double>();
		a.add(1.0);

		for(double i : b)
		{
			j=a.size();
			for(int g=0;g<j;g++)
			{
				if(a.get(g)*i<=k)
				{
					a.add(a.get(g)*i);
				}
				else
				{
					break;
				}
			}
			Collections.sort(a);
			// for(double p:a)
			// {
			// 	System.out.print(p+" ");
			// }
			// System.out.println();
		}

		int h=a.size()-1;
		double count=h*(Math.pow(2,ones))+((Math.pow(2,ones)-1));
		System.out.println((long)count);
	}
}