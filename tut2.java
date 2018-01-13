// tut2.java
import java.lang.*;
import java.util.*;
import java.io.*;

public class tut2
{
	int[] stack;
	int cap,top;
	public tut2(int cap)
	{
		this.cap=cap;
		stack=new int[cap];
		top=-1;
	}
	public int push(int p)
	{
		if(top<cap-1)
		{
			top++;
			System.out.print("push ");
			return stack[top]=p;
		}
		else
		{
			System.out.print("push: Stack Overflow ");
			return -1;
		}
	}
	public int pop()
	{
		if(top>-1)
		{
			top--;
			System.out.print("pop ");
			return stack[top+1];
		}
		else
		{
			System.out.print("pop: Empty Stack ");
			return -1;
		}
	}
	public int peek()
	{
		if(top>-1)
		{
			System.out.print("peek ");
			return stack[top];
		}
		else
		{
			System.out.print("peek: Empty Stack ");
			return -1;
		}
	}
	public static void main(String[] args)
	{
		tut2 s1=new tut2(4);
		System.out.println(s1.peek());
		System.out.println(s1.pop());
		System.out.println(s1.push(2));
		System.out.println(s1.peek());
		System.out.println(s1.push(4));
		System.out.println(s1.push(3));
		System.out.println(s1.push(1));
		System.out.println(s1.push(1));
		System.out.println(s1.pop());
		System.out.println(s1.peek());
		System.out.println(s1.pop());
		System.out.println(s1.peek());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.peek());
	}

}