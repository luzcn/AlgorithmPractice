package CareerCup.StackQueue;

import java.util.Stack;


public class QueueBy2Stack
{
	Stack<Integer> s1;
	Stack<Integer> s2;
	
	public QueueBy2Stack()
	{
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}
	
	public void push(Integer item)
	{
		s1.push(item);
	}
	
	public Integer pop()
	{
		while(!s1.isEmpty())
		{
			s2.push(s1.pop());
		}
		return s2.pop();
	}
	
	public boolean isEmpty()
	{
		return s1.isEmpty();
	}
	
	public static void main(String[] args)
	{
		QueueBy2Stack q = new QueueBy2Stack();
		q.push(1);
		q.push(2);
		q.push(3);
		
		System.out.println(q.pop());
		System.out.println(q.pop());
	}

}
