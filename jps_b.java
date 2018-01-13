// JPS CP!
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class jps_b
{
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

		int t=Reader.nextInt();
        while(t-->0)
        {
            int n=Reader.nextInt();
            int m=Reader.nextInt();
            int v=Reader.nextInt();

            Node[] A=new Node[2010+1];
            for(int i=0;i<2010+1;i++)
            {
                A[i]=new Node();
            }

            int b=Reader.nextInt();
            int g=Reader.nextInt();
            int h=Reader.nextInt(); 

            for(int i=0;i<m;i++)
            {
                int x=Reader.nextInt();
                int y=Reader.nextInt();
                int l=Reader.nextInt();

                Node temp=A[x].link;
                Node n2=new Node(y,l);
                A[x].link=n2;
                n2.link=temp;

                Node temp2=A[y].link;
                Node n3=new Node(x,l);
                A[y].link=n3;
                n3.link=temp2;
            }

            int[] bus=new int[v];
            for(int i=0;i<v;i++)
            {
                bus[i]=Reader.nextInt();
                
            }

            // dijkstra's algo
            int[] D=new int[2010+1];
            for(int i=0;i<=2010;i++)
            {
                if(i!=b)
                    D[i]=Integer.MAX_VALUE;
            }

            int[] vis=new int[2010+1];
            int[] q=new int[2010+1];
            int[] P=new int[2010+1];
            P[b]=0;

            int l=n;
            while(l-->0)
            {
                // System.out.println("stuck");
                int min=Integer.MAX_VALUE;
                int u=0;
                for(int i=1;i<=2010;i++) //min element in D
                {
                    if(D[i]<=min && vis[i]==0)
                    {
                        min=D[i];
                        u=i;
                    }
                }

                vis[u]=1;

                Node ptr=A[u].link;
                while(ptr!=null)
                {
                    if(D[ptr.v]==Integer.MAX_VALUE || D[ptr.v] >= D[u] + ptr.w)
                    {
                        D[ptr.v]=D[u]+ptr.w;
                        P[ptr.v]=u;
                    }
                    ptr=ptr.link;
                }
            }

            System.out.println("dis and parent");
            for(int i=1;i<=n;i++)
            {
                System.out.println(D[i]+" "+P[i]+" ");
            }
            System.out.println();

            int[] ans=new int[v];
            int j=0;
            for(int i=0;i<v;i++)
            {
                int curr=bus[i];
                int k=P.length;
                while(k-->0)
                {
                    // System.out.println("stuck");
                    if((P[curr]==h && P[h]==g) || (P[curr]==g && P[g]==h))
                    {
                        ans[j]=bus[i];
                        j++;
                        break;
                    }
                    curr=P[curr];
                }
            }
            // System.out.println("ansq");
            Arrays.sort(ans,0,j);
            for(int i=0;i<j;i++)
            {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
	}
	
}

class Node
{
    int v;
    Node link;
    int w;

    Node()
    {
        link=null;
    }
    Node(int y, int l)
    {
        link=null;
        v=y;
        w=l;
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