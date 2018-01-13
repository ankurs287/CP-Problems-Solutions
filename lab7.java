import java.util.*;
import java.io.*;
import java.lang.*;

public class lab7
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        int sav=1;
        Stack n1=new Stack();
        n1.push(1);
        Stack r=new Stack();
        long carry=0;
        String res="";
        for(long i=1;i<=n;i++)
        {
            carry=0;
            res="";
            while(!(n1.isEmpty()))
            {
                // if(i==n) System.out.println(i+" "+n1.peek()+" "+n1.size()+" "+carry);
                long calcpop=n1.pop()*i+carry;
                r.push((calcpop)%10);                
                carry=(calcpop)/10; //if(i==n) System.out.println(carry);
            }
            if(carry!=0) r.push(carry);
            
            while(!r.isEmpty())
            {
                res=res+""+r.pop();
            }
            for(int k=0;k<res.length();k++)
            {   
                int u=(int)res.charAt(k)-48;
                n1.push(u);
            }
        }
        System.out.println(res);
    }
}

class Stack
{
    long[] S;
    int top=-1;
    Stack()
    {
        S=new long[1000000];
    }
    Stack(int cap)
    {
        S=new long[cap];
    }
    void push(long d)
    {
        top++;
        S[top]=d;
    }
    long pop()
    {
        // if(isEmpty()) return "e";
        int r=top;
        top--;
        return S[r];
    }
    long peek()
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
        // if(isEmpty()) return "e";
        return top+1;
    }
}
