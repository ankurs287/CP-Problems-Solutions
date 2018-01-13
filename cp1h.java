import java.util.*;
import java.io.*;
import java.lang.*;

class cp1h
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int q=Reader.nextInt();

        Node n=new Node();
        Node p=new Node(0);
        n.link=p;   
        Node ptr=new Node();

        int ans=0, j=0, ln=0,x=0;
        String newq="",lastq="";int redo=1,max=0;
        for(int i=0;i<q;i++)
        {
            newq=Reader.next();
            x=Reader.nextInt();
            if(newq.equals("+"))
            {
                Node p1=new Node(x);
                Node temp=n.link;
                n.link=p1;
                p1.link=temp;
                redo=1;
            }
            else if(newq.equals("-"))
            {
                if(x==max)
                {
                    redo=1;                    
                }
                Node prev=n;
                ptr=n.link;
                while(ptr!=null)
                {
                    if(ptr.d==x)
                    {
                        prev.link=ptr.link;
                        break;
                    }
                    ptr=ptr.link;
                    prev=prev.link;
                }
            }
            else if(newq.equals(lastq) && x==ln)
            {
                System.out.println(ans);
            }
            else
            {
                ans=0;
                ptr=n.link;
                int flag=0;
                while(ptr!=null)
                {

                    int y=x ^ (int)ptr.d;
                    if(y>ans)
                    {
                        max=ptr.d;
                        ans=y;
                    }
                    ptr=ptr.link;
                    flag=1;
                }
                System.out.println(ans);
                redo=0;
            }
            lastq=newq;
            ln=x;
        }
    }
}

class Node
{
    int d;
    Node link;
    Node()
    {
        link=null;  
    }
    Node(int a)
    {
        d=a;
        link=null;  
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

