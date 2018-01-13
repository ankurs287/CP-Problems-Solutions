import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
class cook1
{
    public static void main(String[] args) throws IOException
	{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine());
        StringTokenizer st;
        while(t-->0)
        {
            st=new StringTokenizer(in.readLine());

            long[] a=new long[10000000];
            int i=0;
            while(st.hasMoreTokens())
            {
                a[i]=Long.parseLong(st.nextToken());
                i++;
            }
            long max=Integer.MIN_VALUE;
            int nc=0;
            for(int j=0;j<i;j++)
            {
                if(a[j]==i-1)
                {
                   nc=j;
                   break;
                }
            }
            for(int j=0;j<i;j++)
            {
                if(a[j]>max && j!=nc)
                {
                    max=a[j];
                }
            }
            System.out.println(max);
        }
    }
}