// JPS CP!
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class jps_b1
{
    public static int e,mn,N=2010,count=0;
    public static int[][] dist=new int[N][N]; 
    public static int[] d=new int[N]; 
    public static int[][] prev=new int[N][N + 1];
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

		int t=Reader.nextInt();
        while(t-->0)
        {
            dist=new int[N][N]; 
            d=new int[N]; 
            prev=new int[N][N + 1];

            int n=Reader.nextInt();
            int m=Reader.nextInt();
            int v=Reader.nextInt();

            int b=Reader.nextInt();
            int g=Reader.nextInt();
            int h=Reader.nextInt(); 

            mn=-1;
            for(int i=0;i<m;i++)
            {
                int x=Reader.nextInt();
                int y=Reader.nextInt();
                int l=Reader.nextInt();

                dist[x][y] = l;
                dist[y][x] = l;
                mn = Math.max(x, Math.max(y, mn));
            }

            int[] bus=new int[v];
            for(int i=0;i<v;i++)
            {
                bus[i]=Reader.nextInt();
            }

            dijkstra(b);
            // printD();
            int j=0;
            int[] ans=new int[v];
            for (int i = 0; i <v; ++i) 
            {
                // System.out.println ("Path to "+ i);
                count=0;
                printPath(bus[i], 0, g, h);
                if(count>=2)
                {
                    ans[j]=bus[i];
                    j++;
                    // System.out.println(bus[i]+" ");
                }
                // System.out.println();
            }
            Arrays.sort(ans,0,j);
            for(int i=0;i<j;i++)
            {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
	}
    public static void dijkstra(int s) 
    {
        int i, k, mini;
        int[] visited=new int[N];

        for (i = 1; i <= mn; ++i) {
            d[i] = Integer.MAX_VALUE;
            prev[i][0] = 0; /* no path has yet been found to i */
            visited[i] = 0; /* the i-th element has not yet been visited */
        }

        d[s] = 0;

        for (k = 1; k <= mn; ++k) 
        {
            mini = -1;
            for (i = 1; i <= mn; ++i)
                if (visited[i]==0 && ((mini == -1) || (d[i] < d[mini])))
                    mini = i;

            visited[mini] = 1;

            for (i = 1; i <= mn; ++i)
            {
                if (dist[mini][i]!=0) 
                {
                    if (d[mini] + dist[mini][i] < d[i]) 
                    { /* a shorter path has been found */
                        d[i] = d[mini] + dist[mini][i];
                        prev[i][0] = 1;
                        prev[i][1] = mini;
                    } 
                    else if (d[mini] + dist[mini][i] == d[i]) 
                    { /* a path of the same length has been found */
                        ++prev[i][0];
                        prev[i][prev[i][0]] = mini;
                    }
                }
            }
        }
    }
    public static void printD() {
        int i;

        System.out.println("Distances:");
        // for (i = 1; i <= mn; ++i)
            // System.out.println( i + " ");
        for (i = 1; i <= mn; ++i) {
           System.out.println(d[i]+" ");
        }
    }
    public static void printPath(int dest, int depth, int g, int h) 
    {
        int i, j;

        // System.out.println( dest);
        if(dest==g || dest==h)
        {
            count++;
        }
        for (i = 1; i <= prev[dest][0]; ++i) 
        {
            // for (j = 0; j <= depth; ++j)
            //    System.out.println(" |");
            printPath(prev[dest][i], depth + 1, g, h);
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