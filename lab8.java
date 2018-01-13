import java.util.*;
import java.io.*;
import java.lang.*;

class lab8
{
    public static int current =0;
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int n=Reader.nextInt();
        int q=Reader.nextInt();

        int r=Reader.nextInt();
        Node root=new Node(r);

        for(int i=1;i<n;i++)
        {
            int t=Reader.nextInt();
            insert(root,t);
        }

        // display(root);
        while(q-->0)
        {
            int c=Reader.nextInt();
            if(c==1) //delete
            {
                int d=Reader.nextInt();
                root=delete(root,d);
                // System.out.println();
                // display(root);
            }
            else if(c==2) //rprofile
            {
                current=0;
                rProfile(root,1);System.out.println();
            }
        }

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

    public static Node delete (Node root, int data)
    {
        if (root == null)
        {
            return null;
        }

        if (root.data>data)
        {
            root.left = delete (root.left, data);
        }

        else if (root.data<data)
        {
            root.right = delete (root.right, data);
        }
        else
        {
            if (root.left != null && root.right != null)
            {
                Node temp = root;
                Node temp2 = mini(temp.right);
                root.data = temp2.data;
                root.right=delete (root.right, temp2.data);
            }
            else if (root.left != null)
            {
                root = root.left;
            }
            else if (root.right != null)
            {
                root = root.right;
            }
            else
            {
                root = null;
            }
        }
        return root;
    }
    public static Node mini(Node root) 
    {
        if (root.left == null)
            return root;
        else
            return mini (root.left);
    }

    public static void rProfile(Node root, int rcount)
    {
        if(root==null) 
        {    
            return;
        }

        if(current<rcount)
        {
            System.out.print(root.data+" ");
            current=rcount;
        }
        rProfile(root.right,rcount+1);
        rProfile(root.left,rcount+1);
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