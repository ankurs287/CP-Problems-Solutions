import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
class cook1
{
    public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
        int T=Reader.nextInt();
        while(T-->0)
        {
            BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st=new StringTokenizer(inp.readLine());

            int[] a=new int[100];
            int i=0;
            while(st.hasMoreTokens())
            {
                a[i]=Intege.parseInt(st.nextToken());
                i++;
            }
            int max=Integer.MIN_VALUE;
            int nc=0;
            for(int j=0;j<i;j++)
            {
                if(a[j]==i-1) nc=1;
                if(a[j]>max && nc==1)
                    max=a[j];
            }
            System.out.println(max);
        }
    }
}
 
 
