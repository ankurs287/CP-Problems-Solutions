import java.util.*;
import java.io.*;
import java.lang.*;

public class CNode
{
	public int data; 
	public CNode link;
    CNode()
    {
        link=null; 
    }
    CNode(int inp)
    {
        data=inp; 
        link=null; 
    }
    CNode(int inp, CNode j)
    {
        data=inp;
        link=j;
    }

	public static void main(String[] args) throws IOException
	{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0)
        {
            int n=Reader.nextInt();
            CNode front=new CNode();
            CNode n1=front;
            for(int i=1;i<=n;i++)
            {
                CNode n2=new CNode(i,null);
                n1.link=n2;
                n1=n2;
            }
            n1.link=front.link;

            CNode ptr=front.link;

            // for(int i=0;i<2*n;i++)
            // {
            //     System.out.print(ptr.data+" ");
            //     ptr=ptr.link;
            // }
            // System.out.println();

            ptr=front.link;
            while(n-->1)
            {
                CNode temp=ptr.link.link;
                ptr.link=temp;
                ptr=ptr.link;
            }
            System.out.println(ptr.data);   
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