import java.util.*;
import java.io.*;
import java.lang.*;

public class Node
{
	public String data; 
	public Node link;
    Node()
    {
        data=null;
        link=null; 
    }
    Node(String inp)
    {
        data=inp; 
        link=null; 
    }
    Node(String inp, Node j)
    {
        data=inp;
        link=j;
    }

	public static void main(String[] args) throws IOException
	{
        Reader.init(System.in);
        int flag=1;
        int m=Reader.nextInt();
        int q=Reader.nextInt();

        Node front=new Node();
        Node n1=front;
		for(int i=0;i<m;i++)
		{
			String inp=Reader.next();
			Node n2=new Node(inp,null);
            n1.link=n2;
            n1=n2;
		}
    
        Node ptr=front.link;
        for(int j=0;j<q;j++)
        {
            int c=Reader.nextInt();
            if(c==1)
            {
                String d=Reader.next();
                int p=Reader.nextInt();
                Node n2=new Node(d,null);
                if(p==1)
                {
                    Node temp=front.link;
                    front.link=n2;
                    n2.link=temp;
                    m++;
                    continue;
                }
                ptr=front.link;
                for(int i=1;i<=m;i++)
                {
                    if(i==p-1)
                    {
                        Node temp=ptr.link;
                        ptr.link=n2;
                        n2.link=temp;
                        m++;
                        break;
                    }
                    ptr=ptr.link;
                }
            }
            else if(c==2)
            {
                int p=Reader.nextInt();
                if(p==1)
                {
                    Node temp=front.link.link;
                    front.link=temp;
                    m--;
                    continue;
                }
                ptr=front.link;
                for(int i=1;i<=m;i++)
                {
                    if(i==p-1)
                    {
                        Node temp=ptr.link.link;
                        ptr.link=temp;
                        m--;
                        break;
                    }
                    ptr=ptr.link;
                }
            }
            else if(c==3)
            {
                ptr=front.link;
                for(int i=0;i<m;i++)
                {
                    System.out.print(ptr.data+" ");
                    ptr=ptr.link;
                }
                System.out.println();
            }
            else if(c==4)
            {
                // System.out.println("m="+m);
                int k=Reader.nextInt();

                Node front2=new Node();
               	Node k1=front2;
                for(int i=0;i<k;i++)
                {
                    String inp=Reader.next();
                    Node k2=new Node(inp,null);
                    k1.link=k2;
                    k1=k2;
                }
                if(m!=k)
                {
                    System.out.println("0");
                    continue;
                }
                ptr=front.link;
                Node ptr2=front2.link;
                for(int i=0;i<m;i++)
                {
                	flag=1;
                	if(!(ptr.data.equals(ptr2.data)))
                   	{
                      	System.out.println("0");
                       	flag=0;
                       	break;
                   	}
                   	ptr=ptr.link;
                   	ptr2=ptr2.link;
                }
                if(flag==1)
                {
                    System.out.println("1");
                }
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