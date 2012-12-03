package CareerCup.StackQueue;
import java.util.Stack;
/**
 * I assume each element in the stack is integer
 * @author Zheng Lu
 *
 */
public class StackWithMin
{
	private Node top;
	private Stack<Integer> minStack;
	
	public StackWithMin()
	{
		this.top = null;
		minStack = new Stack<Integer>();
	}
	
	public boolean isEmpty()
	{
		return this.top == null;
	}
	
	public void push(int data)
	{
		Node newNode = new Node(data);
		if (isEmpty()) 
		{
			top = newNode;
			minStack.push(newNode.data);
		}
		else
		{
			if (newNode.data<min()) 
				minStack.push(newNode.data);
			
			newNode.next = top;
			top = newNode;
		}
			
	}
	
	public int pop()
	{
		if (isEmpty()) return -1;
		int data = top.data;
		top = top.next;
		
		if (min() == data)
			minStack.pop();
		
		return data;
	}
	
	public int min()
	{
		if (!minStack.isEmpty())
			return minStack.peek();
		else
			return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args)
	{
		StackWithMin s = new StackWithMin();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(-2);
		
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
	}
/**************************************************/
	private	class Node
	{
		public int data;
		public Node next;
		
		public Node()
		{
			this.data = 0;
			this.next = null;
		}
		
		public Node(int d)
		{
			this();
			this.data = d;
		}
	}
}
