import java.util.*;
import java.io.*;
import java.lang.*;

public class Stack3
{
    String[] S;
    int top=-1;
    Stack3()
    {
        S=new String[100000];
    }
    // Stack3(int cap)
    // {
    //     S=new String[cap];
    // }
    void push(String d)
    {
        top++;
        S[top]=d;
    }
    String pop()
    {
        if(isEmpty()) return "e";
        int r=top;
        top--;
        return S[r];
    }
    String peek()
    {
        if(isEmpty()) return "e";
        return S[top];
    }
    boolean isEmpty()
    {
        if(top==-1) return true;
        else return false;
    }
    int priority(String t,String z)
    {
        if(t.equals("(")) return 1;
        else if(t.equals("-") && z.equals("(")) return 2;
        else if(t.equals("/") || t.equals("*")) return 3;
        else if(t.equals("-") || t.equals("+")) return 4;
        else if(t.equals("e")) return 10;
        return 10;
    }
    public static void main(String[] args) throws IOException
	{
        Reader.init(System.in);
        int psh=0;
        int n=Reader.nextInt();
        String[] in=new String[n];
        for(int i=0;i<n;i++)
        {
           in[i]=Reader.next();
           if(in[i].equals("+")) in[i]="*";
           else if(in[i].equals("-")) in[i]="+";
           else if(in[i].equals("*")) in[i]="/";
           else if(in[i].equals("/")) in[i]="-";
        }
        Stack3 S1=new Stack3();

        String pf="";
        for(int i=0;i<n;i++)
        {
            String uc="l";
            if(i>0) uc=in[i-1];

            if(!(in[i].equals("(") || in[i].equals("/") || in[i].equals("+") || in[i].equals("-") || in[i].equals(")") || in[i].equals("*")))
            {   
                pf=pf+in[i]+" ";
                if(S1.peek().equals("~"))
                {
                    pf=pf+S1.pop()+" ";
                }
            }
            
            else if(in[i].equals("("))
            {   
                S1.push(in[i]);
            }

            else if((S1.isEmpty() || S1.peek().equals("(")) && !(in[i].equals(")")))
            {   
                if(in[i].equals("-") && uc.equals("("))
                {
                    S1.push("~");    
                }
                else
                {
                    S1.push(in[i]);
                }
            }

            else if(in[i].equals(")"))
            {
                while(!(S1.peek().equals("(")))
                {
                    pf=pf+S1.pop()+" ";
                }
                S1.pop();
            }

            else if(S1.priority(in[i],uc)<S1.priority(S1.peek(),uc)) //higher precendence incoming
            {
                if(S1.priority(in[i],uc)==2)
                {
                    S1.push("~");    
                }
                else
                {
                    S1.push(in[i]);
                }
            }

            else if(S1.priority(in[i],uc)>=S1.priority(S1.peek(),uc))  //lower precendence incoming
            {
                pf=pf+S1.pop()+" ";
                i--;
                psh=1;
                continue;
            }
        }
        while(!(S1.isEmpty()))
        {
            pf=pf+S1.pop()+" ";    
            // System.out.println("ada");        
        }
        char[] fa=pf.toCharArray();
        for(int j=0;j<fa.length;j++)
        {
           if(fa[j]=='*') fa[j]='+';
           else if(fa[j]=='+') fa[j]='-';
           else if(fa[j]=='/') fa[j]='*';
           else if(fa[j]=='-') fa[j]='/';
        }
        for(int j=0;j<fa.length;j++)
        {
           System.out.print(fa[j]);
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