package AlgorithmDataStructure;

public class Stack<T>
{
	private Node<T> top;
	
	public Stack()
	{
		this.top = null;
	}
	
	public void push(T data)
	{
		Node<T> newNode = new Node<T>(data);
		if (isEmpty()) 
		{
			top = newNode;
		}
		else
		{
			newNode.next = top;
			top = newNode;
		}
		
	}
	
	public T pop()
	{
		if (isEmpty()) 
			return null;
		
		T data = top.data;
		top = top.next;
		return data;
		
	}
	
	public boolean isEmpty()
	{
		return top == null;
	}
	
	public static void main(String[] args)
	{
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
	}
	
/*************************************************************/	
	private	class Node<T>
	{
		public T data;
		public Node<T> next;
		
		public Node()
		{
			this.data = null;
			this.next = null;
		}
		
		public Node(T d)
		{
			this();
			this.data = d;
		}
	}
}

