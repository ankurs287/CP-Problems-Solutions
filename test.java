import java.io.*;
import java.util.*;
 
class test
{
    public static void main(String[] args)
    {
       // A a=new A1();
       // A b=new A1();
       // a.met();
       // System.out.println(a instanceof A1);
       // if(a instanceof A)
       // {
       //      System.out.println("true");
       // }
        int i=10;
        assert i != 10: "yolo";
        System.out.println("ds");
    }
}

class A
{
    int a;
    public A()
    {
        // System.out.println(a);
    }
    public void met()
    {
        System.out.println("met A");
    }
}

class A1 extends A
{
    public A1()
    {
        super();
    }

    public void met()
    {
        System.out.println("met A1");
    }
}
 
// /** Class for buffered reading int and double values */
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
//     static long nextLong() throws IOException {
//         return Long.parseLong( next() );
//     }
    
//     static double nextDouble() throws IOException {
//         return Double.parseDouble( next() );
//     }
// } 

