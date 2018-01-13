import java.util.*;
import java.io.*;
import java.lang.*;

 class cp1h2
{
    public static String dectobin(int x)
    {
        String a="";
        int k=0;
        for (int c = 30; c >= 0; c--)
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

    public static boolean delete(TrieNode current, String s, int index) 
    {
        if (index == s.length()) 
        {
            if (!current.end) 
            {
                return false;
            }
            current.end= false;
            
            if(current.children[0]==null && current.children[1]==null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        char ch = s.charAt(index);
        int c=Character.getNumericValue(ch);

        TrieNode node = current.children[c];
        if (node == null)
        {
            return false;
        }

        if (delete(node, s, index + 1)) 
        {
            current.children[c]=null;

            if(current.children[0]==null && current.children[1]==null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);

        int t=Reader.nextInt();

        TrieNode root=new TrieNode();
        root.insert(dectobin(0));
        HashMap<Integer,Integer> count=new HashMap<>();
        while(t-->0)
        {
            String q=Reader.next();
            int x=Reader.nextInt();

            if(q.equals("+"))
            {
                String a=dectobin(x);
                root.insert(a);

                if(!count.containsKey(x))
                {
                    count.put(x, 1); 
                }
                else
                {
                    int d=count.get(x) + 1;
                    count.put(x, d);
                }
            }
            else if(q.equals("-"))
            {
                String a=dectobin(x);
                if(count.get(x)==1)
                {
                    delete(root, a,0);
                    count.put(x, 0);
                }
                else
                {
                    count.put(x, count.get(x) - 1);
                }
                
            }
            else if(q.equals("?"))
            {
                String a=dectobin(x);
                System.out.println(Integer.parseInt(xor(root,a), 2));
            }
            else
            {
                String a=dectobin(x);
                System.out.println( root.search(a));
            }

        }
    }
    public static String xor(TrieNode root, String s)
    {
        String a="";
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            int c=Character.getNumericValue(ch);

            int x=1-c;
            int n=0;
            if(root.children[x]!=null)
            {
                n=1;
                a=a+"1";
                root=root.children[x];
            }
            else
            {
                n=0;
                a=a+"0";
                root=root.children[1-x];
            }
            // System.out.println(ch+" "+x+" "+n);
        }
        return a;
    }

}

class TrieNode
{
    TrieNode[] children;
    boolean end;

    TrieNode()
    {
        children=new TrieNode[2];
        end=false;
    }

    public void insert(String s)  
    {
        if(s.length()==0)
        {
            end=true;
            return;
        }
        
        char ch = s.charAt(0);
        int c=Character.getNumericValue(ch);

        if(children[c]==null)
        {
            children[c]=new TrieNode();
        }

        children[c].insert(s.substring(1));
    }

    public boolean search(String s)
    {
        if(s.length()==0)
        {
            return end;
        }

        char ch = s.charAt(0);
        int c=Character.getNumericValue(ch);

        if(children[c]==null)
        {
            return false;
        }       

        return children[c].search(s.substring(1));
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

