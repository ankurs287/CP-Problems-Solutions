import java.io.*;
import java.lang.*;
import java.util.*;

class gpd
{
	public static Node[] A;
	public static int[] keys;
	public static String[] pa;
	public static int min=Integer.MAX_VALUE;
	public static int max=0;
	public static int k2=0;
	public static int yo=0;
	public static HashMap<String,Integer> trans=new HashMap<String,Integer>();
	public static Stack myStack  = new Stack(); 
    public static Set<Integer> mySet = new HashSet<Integer>();
	
	public static void main(String[] args) throws IOException
	{
		// try{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		int index=1;
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(in.readLine());


		trans.put(st.nextToken(),index++);

		int r=1;
		int key=Integer.parseInt(st.nextToken());

		A=new Node[300010];
		for(int i=0;i<300010;i++)
		{
			A[i]=new Node();
		}

		keys=new int[300010];
		for(int i=0;i<n-1;i++)
		{
			st=new StringTokenizer(in.readLine());
			// int u=Integer.parseInt(st.nextToken());
			// int v=Integer.parseInt(st.nextToken());
			
			int u=index;
			trans.put(st.nextToken(),index++); //trans u
			int v=trans.get(st.nextToken()); //new v

			Node temp=A[u].link;
			Node n2=new Node(v);
			A[u].link=n2;
			n2.link=temp;

			Node temp2=A[v].link;
			Node n3=new Node(u);
			A[v].link=n3;
			n3.link=temp2;

			int k=Integer.parseInt(st.nextToken());
			keys[u]=k;
		}
		keys[r]=key;

		int last_answer=0;
		for(int i=0;i<q;i++)
		{
			st=new StringTokenizer(in.readLine());
			int t=Integer.parseInt(st.nextToken());

    		t^=last_answer;

    		if(t==0)
    		{
    			int v=Integer.parseInt(st.nextToken()); //already exist
    			int u=Integer.parseInt(st.nextToken()); // new node
    			int k=Integer.parseInt(st.nextToken());

		        u^=last_answer;
		        v^=last_answer;
		        k^=last_answer;


		        trans.put((""+u),index++);
		        u=index-1;
		        v=trans.get(""+v);
		        
		        Node temp=A[u].link;
				Node n2=new Node(v);
				A[u].link=n2;
				n2.link=temp;

				Node temp2=A[v].link;
				Node n3=new Node(u);
				A[v].link=n3;
				n3.link=temp2;

				keys[u]=k;
		    }
		    else
		    {
		        int v=Integer.parseInt(st.nextToken());
		        k2=Integer.parseInt(st.nextToken());

		        v^=last_answer;
		        k2^=last_answer;

		        v=trans.get(""+v);

		        dfs(v,r);

		        System.out.println(min+" "+max);
		        
		        last_answer = min ^ max;
		        
		        min=Integer.MAX_VALUE;
		        max=0;
		        myStack.reset();
		        yo=0;
		        mySet = new HashSet<Integer>();
		    }
		}
		// }
		// catch(Exception e){
  //           return;
  //       }
	}
	public static void dfs(int v, int t) 
	{
        myStack.push(v);
        mySet.add(v);

        if(yo==1)
        {
        	return;
        }
        if (v==t) 
        {
        	yo=1;
        	int[] stk=myStack.show();
        	for(int i=0;i<myStack.top+1;i++)
	        {
	        	int tm=stk[i];

    			tm=keys[tm]^k2;
    			if(tm>max)
    			{
    				max=tm;
    			}
    			if(tm<min)
    			{
    				min=tm;
    			}
	        }
	        myStack.reset();
	    }
        else
        {
        	Node ptr=A[v].link;
	        while(ptr!=null)
	        {
	        	if (!mySet.contains(ptr.v)) 
	        	{
	        		dfs((int)ptr.v, t);
	        	}
	        	ptr=ptr.link;
	        }
        }

	        myStack.pop();
	        mySet.remove(v);
    }
}

class Node
{
	int v;
	Node link;

	Node()
	{
		link=null;
		// front=null;
	}
	Node(int y)
	{
		link=null;
		v=y;
	}
}

class Stack
{
    int[] S;
    int top=-1;
    Stack()
    {
        S=new int[10000000];
        top=-1;
    }
    Stack(int cap)
    {
        S=new int[cap];
    }
    void push(int d)
    {
        top++;
        S[top]=d;
    }
    int pop()
    {
        if(isEmpty()) return 0;
        int r=top;
        top--;
        return S[r];
    }
    int peek()
    {
        // if(isEmpty()) return "e";
        return S[top];
    }
    boolean isEmpty()
    {
        if(top==-1) return true;
        else return false;
    }
    int size()
    {
        return top+1;
    }
    int[] show()
    {
        // for(int i=0;i<top+1;i++)
        // {
        //     System.out.print(S[i]);
        // }
        // System.out.println();
        return S;
    }
    void reset()
    {
    	top=-1;
    }
}