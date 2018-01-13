// JPS CP!
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class jps_g
{
	public static int N = 100010;
	public static int[] ans, f, h, pe, d;
	public static ArrayList<ArrayList<Integer[]>> loarr = new ArrayList<ArrayList<Integer[]>>();

	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);

		int n=Reader.nextInt();
		int m=Reader.nextInt();

		ans=new int[N]; f=new int[N]; pe=new int[N]; d=new int[N]; h=new int[N];
		for(int i=0;i<N;i++)
		{
			loarr.add(new ArrayList<Integer[]>());
		}
		
		int[] a=new int[m+1];
		int[] b=new int[m+1];
		int[] c=new int[m+1];

		int[][] extra=new int[m+1][2];

		Integer[] ind=new Integer[m+1];
		for(int i=1;i<=m;i++)
		{
			a[i]=Reader.nextInt();
			b[i]=Reader.nextInt();
			c[i]=Reader.nextInt();

			extra[i][0]=c[i];
			extra[i][1]=i;

			ind[i]=i;
		}

        // Arrays.sort(ind, (r, t) -> c[r] - c[t]);
		java.util.Arrays.sort(extra, new java.util.Comparator<int[]>() {
			@Override
		    public int compare(int[] a, int[] b) {
	        return Integer.compare(a[0], b[0]);
    }
});
		for(int i=1;i<=m;i++)
		{
			ind[i]=extra[i][1];
		}

        for (int i = 1; i <= m; )
	    {
	        int j=0;
	        
	        for (j = i; j<=m && c[ind[j]] == c[ind[i]]; j++)
	        {
	        	add_edge(par(a[ind[j]]), par(b[ind[j]]), ind[j]);
	        }

	        for (j = i; j<=m && c[ind[j]] == c[ind[i]]; j++) 
	        {
	            int k = par(a[ind[j]]);
	            if (f[k]==0) 
	            {
	            	dfs(k, 0, 0);
	            }
	        }
	        for (j = i; j<=m && c[ind[j]] == c[ind[i]]; j++) 
	        {
	        	uni(a[ind[j]], b[ind[j]]);
	        }
	        i = j;
	    }
	    int count=0;
	    for (int i = 1; i <= m; i++)
	    {
		 //    if (ans[i]==0) System.out.println("none"); 
		 // 	else
		 // 	{
			//     if (ans[i] == 1) 
			//     {
			//     	System.out.println("at least one"); 
			//     }
			// 	else
			// 	    System.out.println("any");
			// }
			if(ans[i]==0)
			{
				count++;
			}
		}
		System.out.println(count);
	}

	public static int par(int x)
	{
	    while (pe[x]!=0)
	    {
	    	x = pe[x];	
	    } 
	    return x;
	}
	public static void add_edge(int x, int y, int i)
	{
	    if (x == y) return;
	    ans[i] = 1;

	    loarr.get(x).add(new Integer[] {y,i});
	    loarr.get(y).add(new Integer[] {x,i});
	    // v[x].push_back({y, i});
	    // v[y].push_back({x, i});
	}
	public static void dfs(int c, int g, int h)
	{
	    f[c] = 1; d[c] = h;
	    ArrayList<Integer[]> qq= loarr.get(c);
	    Iterator<Integer[]> i = qq.iterator();
	    while (i.hasNext())
	    { 
	    	Integer[] ww=i.next();
	    	if(f[ww[0]]==0) 
		    {
		        dfs(ww[0], ww[1], h + 1);
		        d[c] = Math.min(d[c], d[ww[0]]);
		    } 
		    else
		    if (ww[1] != g) d[c] = Math.min(d[c], d[ww[0]]);
		    if (d[c] == h) ans[g] = 2;
		}
	}
	public static void uni(int x, int y)
	{
	    x = par(x); y = par(y);
	    loarr.add(x,new ArrayList<Integer[]>());
	    loarr.add(y,new ArrayList<Integer[]>());
	    
	    // loarr.get(x)=new ArrayList<Integer[]>();
	    // loarr.get(y)=new ArrayList<Integer[]>();
	    
	    f[x] = f[y] = 0;
	    
	    if (x == y) return;
	    
	    if (h[x] > h[y])
	    { 
	    	pe[y] = x; 
	    }
	    else
	    {
	        pe[x] = y;
	        if (h[x] == h[y]) 
	        {
	        	h[y]++;
	        }
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
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}