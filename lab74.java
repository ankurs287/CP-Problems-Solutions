import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

class lab74
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        Stack result=new Stack(); result.push(1);
        Stack result2=new Stack();

        Stack[] temp;
        temp=new Stack[5];
        for(int i=0;i<5;i++)
        {
            temp[i]=new Stack();
        }

        int carry=0,a=0,b=0,m=0;
        String res="1";

        for(int i=1;i<=n;i++) //main
        {
            carry=0;
            int j=0;
            while(j<4)  //pushing 0s to temp (constant time)
            { 
                int q=j;
                temp[j].reset(-1);
                while(q-->0)
                {
                    temp[j].push(0);
                }
                j++;
            }

            String t="";
            j=0;
            int q=i;
            while(q!=0) //calc 
            {
                t="";
                a=q%10;
                carry=0;
                int front=-1;
                while(!result.isEmpty())
                {
                    b=result.pop();
                    m=a*b+carry;
                    temp[j].push(m%10);
                    carry=m/10;
                    front++;
                }
                result.reset(front);

                if(carry!=0) temp[j].push(carry);
                
                temp[j].reverse();  
                
                j++;
                q/=10;
            }

            result.reset(-1);result2.reset(-1);
            result2=add(temp[0],temp[1],temp[2],temp[3]);

            res="";
            String pp="";
            int flag=0;
            while(!result2.isEmpty())
            {
                pp=""+result2.pop();
                
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
                    result.push((Integer.parseInt(pp)));
                }
            }
            
            if(!fact(i).equals(res))
            {
                System.out.println(i);
            }
            // System.out.println(res);
        }
        System.out.println(res.length());

    }

    public static Stack add(Stack t1,Stack t2, Stack t3,Stack t4)
    {
        Stack sum=new Stack();
        int a=0,b=0,c=0,d=0,e=0,carry=0;        
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
    public static String fact(int n)
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
    int[] S;
    int top=-1;
    Stack()
    {
        S=new int[3000];
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
    void show()
    {
        for(int i=0;i<top+1;i++)
        {
            System.out.print(S[i]);
        }
        System.out.println();
    }
    void reset(int front)
    {
        top=front;
    }
    void reverse()
    {
        int j = top;
        int i = 0;
        while(i<j)
        {
           int temp = S[i];
           S[i] = S[j];
           S[j] = temp;
           i++;
           j--;
        }
    }
}
