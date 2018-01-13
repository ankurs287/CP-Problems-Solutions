import java.util.*;
import java.lang.*;
import java.io.*;
 
class cook3
{
    public static void main(String[] args) throws IOException
	{
        Reader.init(System.in);

        int t=Reader.nextInt();
        while(t-->0)
        {
            int n=Reader.nextInt();
            
            Node[] A=new Node[n];
            for(int i=0;i<n;i++)
            {
                A[i]=new Node();
                for(int j=0;j<n;j++)
                {
                    if(j!=i)
                    {
                        Node temp=A[i].link;
                        Node n2=new Node(j);
                        A[i].link=n2;
                        n2.link=temp;
                    }
                }
            }

            for(int i=0;i<m;i++)
            {
                int x=Reader.nextInt();
                int y=Reader.nextInt();

                Node temp=A[x].link;
                Node n2=new Node(y,l);
                A[x].link=n2;
                n2.link=temp;

                Node temp2=A[y].link;
                Node n3=new Node(x,l);
                A[y].link=n3;
                n3.link=temp2;
            }

        }
    }
}
class Node
{
    int x;
    int y;
    Node link;
    int w;
    int v;

    Node(int s)
    {
        int v=s;
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