import java.io.*;
import java.lang.*;
import java.util.*;

class chefsuba
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		// System.out.println(Long.MAX_VALUE);
		// double uu=1223372036854775807000000000000000000000000000000000000000000000000000000000000000.0;
		StringTokenizer st;
		st=new StringTokenizer(in.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int p=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(in.readLine());
		int[] a=new int[n];

		int j=0, count=0, maxcount=0;
		while(st.hasMoreTokens())
		{
			a[j]=Integer.parseInt(st.nextToken());
			if(a[j]==1)
			{
				count++;
			}

			j++;
		}
		maxcount=count;
		int trouble=0;
		if(k>=n)
		{
			trouble=1;
		}

		j=0;count=0;
		int[][] b=new int[n][3];

		int x=0,y=k-1;
		int fcount=0;
		for(int i=0;i<n;i++)
		{
			b[i][1]=i;
			b[i][2]=(i+k-1)%n;
			
			if(a[i]==1)
			{
				count++;
			}

			if(i>=(k-1))
			{
				count=count-x;
				fcount=Math.max(fcount,count);
				b[j][0]=count;
				x=a[b[j][1]];
				j++;
			}
		}

		y=0;
		while(j!=n)
		{
			if(a[y]==1)
			{
				count++;
			}

			count=count-x;
			b[j][0]=count;
			x=a[b[j][1]];
			j++;
			y++;
		}

		// for(int i=0;i<j;i++)
		// {
		// 	System.out.println(b[i][0]+" "+b[i][1]+" "+b[i][2]);
		// }

		// for(int i=0;i<n-1;i++)
		// {                  
	 //        for(j=i+1;j<n;j++)
	 //        {
	 //            if(b[0][i] < b[0][j]) 
	 //            {
	 //                swap(b,0,i,j);
	 //                swap(b,1,i,j);
	 //                swap(b,2,i,j);
	 //            }
	 //        }
  //   	}

		// Arrays.sort(b[0]);
		Arrays.sort(b, (r, t) -> Integer.compare(r[0], t[0]));
		// java.util.Arrays.sort(b, new java.util.Comparator<int[]>() {
		// 	@Override
		//     public int compare(int[] a, int[] b) {
	 //        return Integer.compare(a[0], b[0]);
//     }
// });
  //   	System.out.println("----------");
  //   	for(int i=n-1;i>=0;i--)
		// {
		// 	System.out.println(b[i][0]+" "+b[i][1]+" "+b[i][2]);
		// }

		int start=0, end=n-1, flag=0;
		char[] q=in.readLine().toCharArray();
		char prev=q[0];
		// j=0;
		// while(flag!=1)
		// {
		// 	if(! ((b[1][j]>b[2][j]&& (start<=b[2][j] || start>b[1][j])) || (b[1][j]<b[2][j] && start>b[1][j] && start<=b[2][j])) )
		// 	{
		// 		flag=1;
		// 		count=b[0][j];
		// 		break;
		// 	}
		// 	else
		// 	{
		// 		flag=0;

		// 	}

		// 	j++;
		// }

		count=fcount;
		if(trouble==1)
		{
			count=maxcount;
		}
		for(int i=0;i<p;i++)
		{
			flag=0;
			if(k>=n && q[i]=='?')
			{
				System.out.println(count);
			}

			else if((q[i]=='?' && i>0 && prev=='?') || (i==0 && q[i]=='?'))
			{
				System.out.println(count);
			}
			else if(q[i]=='!' && k<n)
			{
				start=end;
				end--;
				if(end==-1)
				{
					end=n-1;
				}
			}
			else if(q[i]=='?')
			{
				j=n-1;
				// System.out.println("hh="+i+"s="+start+"e="+end);
				while(flag!=1)
				{
					if(! ((b[j][1]>b[j][2]&& (start<=b[j][2] || start>b[j][1])) || (b[j][1]<b[j][2] && start>b[j][1] && start<=b[j][2])) )
					{
						// System.out.println("hh="+i+"s="+start+"e="+end);
						flag=1;
						count=b[j][0];
						break;
					}
					else
					{
						flag=0;

					}

					j--;
				}
				System.out.println(count);
			}
			prev=q[i];
		}
	}
	// public static void swap(int[][] b,int r,int x, int y) 
	// {
	//     int temp=b[r][x];
	//     b[r][x]=b[r][y];
	//     b[r][y]=temp;
	// }
}