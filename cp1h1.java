import java.util.*;
import java.io.*;
import java.lang.*;

class cp1h1
{
    public static String dectobin(int x)
    {
        String a="";
        int k=0;
        for (int c = 31; c >= 0; c--)
        {
            k = x >> c;
            int j=k&1;
            if (j >0)
                a=a+"1";

            else
                a=a+"0";
        }
        return a;
    }
    public static void insert(String site, TrieNode root)  
    {
        for(int j=0;j<site.length(); j++)
        {
            HashMap<Integer,TrieNode> child=root.children;
            char ch = site.charAt(j);
            int c=Character.getNumericValue(ch);

            if(child.containsKey(c))
                root = child.get(c);
            else
            {
                TrieNode temp = new TrieNode(c);
                child.put(c,temp);
                root=temp;
            }
        }
        root.end=true;
    }

    public static void delete(String s, TrieNode node) 
    {
        if (s.length()>0)
        {
            if (node != null) 
            {
                char ch = s.charAt(0);
                int c=Character.getNumericValue(ch);
                TrieNode childNode = node.children.get(c);
                delete(s.substring(1),childNode);
                HashMap<Integer, TrieNode> childNodes = node.children;
                if (childNodes == null || childNodes.keySet().size() == 0) 
                {
                    //delete current node only if there is no child nodes.
                    node= null; //nulling the reference.
                }
                // System.out.print(c);
            }
        }    
    }
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int t=Reader.nextInt();

        TrieNode root=new TrieNode(0);

        while(t-->0)
        {
            String q=Reader.next();
            int x=Reader.nextInt();

            if(q.equals("+"))
            {
                String a=dectobin(x);
                insert(a,root);
                System.out.println(a);
            }
            else if(q.equals("-"))
            {
                String a=dectobin(x);
                delete(a,root);
            }
            else if(q.equals("?"))
            {
                String a=dectobin(x);
                System.out.println(xor_max(a,root));
            }
            else
            {
                String a=dectobin(x);
                search(a,root);
            }

        }

    }
    public static String xor_max(String s, TrieNode root)
    {
        TrieNode current = root;
        String a="";
        if(current != null && s.length()>0) 
        {
            for (int i=0;i<s.length();i++)
            {
                char ch = s.charAt(i);
                int x=1-Character.getNumericValue(ch);

                HashMap<Integer,TrieNode> currchildren=current.children;

                System.out.println(currchildren.size());
                if(currchildren.containsKey(0))
                // {
                //     System.out.print("content"+0+" ");
                // }
                // if(currchildren.containsKey(1))
                // {
                //     System.out.print(1);
                // }
                System.out.println("--");

                char n=ch;

                if(currchildren.containsKey(x))
                {
                    n='1';
                    a=a+"1";
                    // System.out.println("if="+i);
                }
                else
                {
                    n='0';
                    a=a+"0";
                }

                // System.out.println(ch+" "+x+" "+n);
                TrieNode childNode=current.children.get(x);
                if(childNode != null) 
                {
                    current = childNode; // increment child node.
                }
            }
        }
        return a;  
    }
    public static void search(String s, TrieNode root) 
    {
        TrieNode current = root;
        if(current != null && s.length()>0) 
        {
            for (int i=0;i<s.length();i++)
            {
                char ch = s.charAt(i);
                int c=Character.getNumericValue(ch);
                TrieNode childNode = current.children.get(c);
                if (childNode != null) 
                {
                    current = childNode; // increment child node.
                } 
                else 
                {
                    System.out.println("String:"+s+" not found.");
                    return;
                }
            }
            if (current.end)
            {
                System.out.println("String:"+s+" found.");
            }
        }
    }
}

class TrieNode
{
    int d;
    HashMap<Integer,TrieNode> children;
    boolean end;
    TrieNode(int ch)
    {
        d = ch;
        children = new HashMap<>();
        end = false;
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

    // public static boolean delete(TrieNode root, String s, int level, int len)
    // {
    //     if(root!=null)
    //     {
    //         if(level==len)
    //         {
    //             if(root.end)
    //             {
    //                 root.end=true;

    //                 if(root.isItFreeNode())
    //                 {
    //                     return true;
    //                 }

    //                 return false;
    //             }
    //         }
    //         else
    //         {
    //             char ch = s.charAt(level);
    //             int c=Character.getNumericValue(ch);
                
    //             if(delete(root.children[c], s.substring(1), level+1, len))
    //             {
    //                 root.children[c]=null;
    //                 return (!root.end && root.isItFreeNode());
    //             }   
    //         }
    //     }
    //     return false;
    // }