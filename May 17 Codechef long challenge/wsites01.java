import java.io.*;
import java.lang.*;
import java.util.*;

class wsites01
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(in.readLine());
		
		TrieNode root=new TrieNode((char)0);
		StringTokenizer st;
		char[] s=new char[n];
		String[] inp=new String[n];

		for(int i=0;i<n;i++)
		{
			st=new StringTokenizer(in.readLine());
			s[i]=st.nextToken().charAt(0);
			inp[i]=st.nextToken();

			if(s[i]=='+')
			{
				insert(inp[i],root);
			}
		}

		int j=0,count=0;
		String[] x=new String[n];
		for(int i=0;i<n;i++)
		{
			if(s[i]=='-')
			{
				// System.out.println(ans(inp[i], root)+" hurrya");
				String save=ans(inp[i], root);
				if(save.equals("-2"))
				{
					System.out.println("-1");
					return;
					// break;
				}
				else
				{
					x[j]=save;
					
					j++;
					// System.out.println(j);
				}
			}
		}

		Arrays.sort(x,0,j);
		String[] y=new String[j];

		for(int i=0;i<j;i++)
		{
			if(i>0 && x[i-1].equals(x[i]))
			{
				//ignre
			}
			else
			{
				y[count]=x[i];
				count++;
			}
		}

		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			System.out.println(y[i]);
		}
	}

	public static void insert(String site, TrieNode root)  
	{
        for(int j=0;j<site.length(); j++)
        {
            HashMap<Character,TrieNode> child=root.children;
            char ch = site.charAt(j);

            if(child.containsKey(ch))
                root = child.get(ch);
            else
            {
                TrieNode temp = new TrieNode(ch);
                child.put(ch,temp);
                root=temp;
            }
        }
 		root.end=true;
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
                    // System.out.println("String:"+s+" not found.");
                    return;
                }
            }
            // if (current.end)
            System.out.println("String:"+s+" found.");
        }
    }
    public static String ans(String input, TrieNode root)  
    {
        String result="";
        int j, el=0, len=input.length();
        for(j=0;j<len;j++)
        {
            char ch=input.charAt(j);
            HashMap<Character,TrieNode> child=root.children;

            if(child.containsKey(ch))
            {
               result += ch;
               root = child.get(ch);
            }
            else
            {
            	el=1;
            	result+=ch;
            	break;
          	}
        }

        if(!root.end && el==0)
        {
        	// System.out.println("ssd");
            return "-2";        
        }
        else if (root.end=false && el==1) 
        {
        	return result;	
        }
        else
        {
        	return result;
        }
    }
    printTrie(TrieNode node, int offset) {
     print(node, offset)
     // here you can play with the order of the children
     for(TrieNode child : node.children) {
          printTrie(child, offset + 2)
     } 
}
}

class TrieNode
{
    char d;
   	HashMap<Character,TrieNode> children;
    boolean end;
    TrieNode(char ch)
    {
        d = ch;
        children = new HashMap<>();
        end = false;
    }
}