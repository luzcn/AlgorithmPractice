package CareerCup.StackQueue;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks
{
	public static int Capacity = 3;
	
	public ArrayList<Stack<String>> stackList = new ArrayList<Stack<String>>();
	
	public SetOfStacks()
	{
		stackList.add(new Stack<String>());
	}

	public void push(String str)
	{
		Stack<String> s;
		if (stackList.size()<1) 
		{
			s = new Stack<String>();
			this.stackList.add(s);
		}
		else
			s = this.stackList.get(stackList.size() - 1);
		
		if (s.size()<Capacity)
			s.push(str);
		else
		{
			Stack<String> newStack = new Stack<String>();
			newStack.push(str);
			this.stackList.add(newStack);
		}
		
	}
	
	public String pop()
	{
		if (this.stackList.size()<1) return null;
		
		Stack<String> s = this.stackList.get(this.stackList.size()-1);
		
		if (s.size()<1) return null;
		else
		{
			String str = s.pop();
			if (s.size()<1)
				this.stackList.remove(s);
			
			return str;
		}
	}
	
	public String popAt(int index)
	{
		if (this.stackList.size()<1) return null;
		if (index>this.stackList.size()) return null;
		
		Stack<String> s = this.stackList.get(index-1);
		
		String str = s.pop();
		
		//TODO
		/** we need to roll over all the elements to this stack**/
		
		
		return str;
		
	}
	
	public static void main(String[] args)
	{
		SetOfStacks ss = new SetOfStacks();
		ss.push("1");
		ss.push("2");
		ss.push("3");
		
		ss.push("5");
		ss.push("6");
		ss.push("61");
		
		ss.push("123");
		
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		
		System.err.println(ss.stackList.size());
		
		ss.push("18");
		System.out.println(ss.pop());
	}
}
