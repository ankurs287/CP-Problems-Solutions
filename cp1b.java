import java.io.*;
import java.lang.*;
import java.util.*;

class cp1a
{
    public static int d=0;
	public static void main(String[] args) throws IOException
	{
        Reader.init(System.in);

		int n=Reader.nextInt();

		Node root=new Node(Reader.nextInt());

		while(n-->1)
		{
			insert(root,Reader.nextInt());
		}

        // display(root);

        // st=new StringTokenizer(in.readLine());
        int a=Reader.nextInt();
        int b=Reader.nextInt();

        int n1=dist(root,a);
        // System.out.println(n1);
        d=0;

        int n2=dist(root,b);
        // System.out.println(n2);
        d=0;

        int cnd=commonNode(root,a,b).data;
        int n3=dist(root,cnd);
        // System.out.println(n3);
        d=0;

        int sum=n1+n2-(2*n3)+cnd;
        System.out.println(sum);

	}

    public static Node commonNode(Node root, int a, int b) 
    {
        if (root.data>a && root.data>b)
        {
            return commonNode(root.left,a,b);
        }
        if (root.data<a && root.data<b) 
        {
            return commonNode(root.right,a,b);
        }
        if (root==null)
        {
            return null;
        }
        return root;
    }

    public static int dist(Node root, int x)
    {
        if(root.data==x)
        {
            d=d+x;
            return d;
        }
        else if(root.data>x)
        {
            d=d+root.data+dist(root.left,x);
        }
        else if(root.data<x)
        {
            d=d+root.data+dist(root.right,x);
        }
        return d;
    }

	public static Node insert(Node root, int data) 
    {
        if (root == null)
        {
            root = new Node (data);
        }
        else 
        {
            if (data<root.data)
            {
                root.left=insert (root.left, data);
            }
            else
            {
               root.right=insert (root.right, data);
            }
        }
        return root;
    }

    public static void display (Node root) 
    {
        if (root!=null) 
        {
            System.out.print (root.data+" ");
            display (root.left);
            display (root.right);
        }
    }
}

class Node
{
	public int data; 
	public Node left;
    public Node right;
    Node()
    {
        left=null; 
        right=null;
    }
    Node(int inp)
    {
        data=inp; 
        left=null; 
        right=null;
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