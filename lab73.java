import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

class lab73
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        Stack one=new Stack();

        Stack[] result;
        result=new Stack[5];
        for(int i=0;i<5;i++)
        {
            result[i]=new Stack();
            result[i].push(1);
        }

        Stack[] temp;
        temp=new Stack[5];
        for(int i=0;i<5;i++)
        {
            temp[i]=new Stack();
        }

        long carry=0,a=0,b=0,m=0;
        String res="1";

        for(long i=1;i<=n;i++) //main
        {
            carry=0;
            String x=Long.toString(i);
            for(int k=0;k<x.length();k++) //i in stack
            {   
                int u=(int)x.charAt(k)-48;
                one.push(u);
            }
                
            int j=0,count1=0,count2=0;
            while(j<4) 
            { 
                int q=j;
                while(q-->0)
                {
                    temp[j].push(0);count2++;
                }
                j++;
            }
            if(i==n){System.out.println(count1+" "+count2);count1=0;System.out.println();}

            j=0;count2=0;count1=1;
            String t="";
            while(!one.isEmpty()) //calc
            {
                t="";
                a=one.pop();
                carry=0;
                while(!result[j].isEmpty())
                {
                    b=result[j].pop();
                    m=a*b+carry;
                    temp[j].push(m%10);
                    carry=m/10;count1++;
                }
                if(carry!=0) temp[j].push(carry);
                while(!temp[j].isEmpty())
                {
                    t=t+""+temp[j].pop();count2++;
                }
                for(int k=0;k<t.length();k++)
                {   
                    int u=(int)t.charAt(k)-48;//System.out.println(u );
                    temp[j].push(u);
                }
                j++;
            }
            if(i==n){System.out.println(count1+" "+count2);count1=0;System.out.println();}

            while(!result[0].isEmpty() || !result[1].isEmpty() || !result[2].isEmpty() || !result[3].isEmpty() || !result[4].isEmpty())
            {
                result[0].pop();result[1].pop();result[2].pop();result[3].pop();result[4].pop();
            }

            result[4]=add(temp[0],temp[1],temp[2],temp[3]);
            res="";
            String pp="";
            int flag=0;count1=0;count2=0;
            while(!result[4].isEmpty())
            {
                pp=""+result[4].pop();
                
                if(!pp.equals("0"))
                {
                    flag=1;
                }
                if(flag==0)
                {
                    // result[1].pop();
                }
                else
                {
                    res=res+""+pp;
                    result[0].push((Integer.parseInt(pp)));result[1].push((Integer.parseInt(pp)));
                    result[2].push((Integer.parseInt(pp)));result[3].push((Integer.parseInt(pp)));
                }
                count1++;
            }

            if(i==n){System.out.println(count1);System.out.println();}
             if(!fact(i).equals(res))
            {
                System.out.println(i);
            }
            // System.out.println(res);
        }
        // System.out.println(res);
        // System.out.println(res.length());
        // System.out.println(fact(n));
    }
    public static Stack add(Stack t1,Stack t2, Stack t3,Stack t4)
    {
        Stack sum=new Stack();
        long a=0,b=0,c=0,d=0,e=0,carry=0;        
        while(!t1.isEmpty() || !t2.isEmpty() || !t4.isEmpty() || !t3.isEmpty())
        {
            a=t1.pop();
            b=t2.pop();
            c=t3.pop();
            d=t4.pop();
            e=a+b+c+d+carry;
            sum.push(e%10);
            carry=e/10;
        }
        if(carry!=0)
        sum.push(carry);
        return sum;
    }
    public static String fact(long n)
    {
      BigInteger c =new BigInteger("1");
      BigInteger fact =new BigInteger("1");
      BigInteger nn=BigInteger.valueOf(n);
      if ( n < 0 )
         System.out.println("0");
      else
      {
         for ( ; c.compareTo(nn) <= 0; c=c.add(BigInteger.ONE) )
            fact = fact.multiply(c);
 
         // System.out.println(""+fact);
      }
      String y= ""+fact;
      return y;
   }
    }
class Stack
{
    long[] S;
    int top=-1;
    Stack()
    {
        S=new long[3000];
        top=-1;
        // for(int i=0;i<1000000;i++)
        // {
        //  S[i]=0;
        // }
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
        if(isEmpty()) return 0;
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
        return top+1;
    }
    void show()
    {
        for(int i=0;i<top+1;i++)
        {
            System.out.print(S[i]);
        }
        System.out.println();
    }
}
