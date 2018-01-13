import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class testlab7
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
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
                r.push(calcpop%10);
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
            if(res.equals(fact(i)) && i==n)
            {

            	System.out.println("true "+i);
            }
            else if(i==n)
            {
            	// System.out.println(res+" "+fact(i));
            	System.out.println("false "+i);
            }
           // System.out.println(res+" "+fact(i));
        }

        // System.out.println(res);
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


//     /** Class for buffered reading int and double values */
// class Reader {
//     static BufferedReader reader;
//     static StringTokenizer tokenizer;

//     /** call this method to initialize reader for InputStream */
//     static void init(InputStream input) {
//         reader = new BufferedReader(
//                      new InputStreamReader(input) );
//         tokenizer = new StringTokenizer("");
//     }

//     /** get next word */
//     static String next() throws IOException {
//         while ( ! tokenizer.hasMoreTokens() ) {
//             //TODO add check for eof if necessary
//             tokenizer = new StringTokenizer(
//                    reader.readLine() );
//         }
//         return tokenizer.nextToken();
//     }

//     static int nextInt() throws IOException {
//         return Integer.parseInt( next() );
//     }
    
//     static double nextDouble() throws IOException {
//         return Double.parseDouble( next() );
//     }
// }