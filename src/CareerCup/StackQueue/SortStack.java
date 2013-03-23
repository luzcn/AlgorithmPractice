package CareerCup.StackQueue;

import java.util.Stack;

/**
 * sort a stack from top to bottom in ascending order
 * 
 * @author Zheng Lu
 * 
 */
public class SortStack
{
	public void sort(Stack<Integer> s)
	{
		Stack<Integer> compareStack = new Stack<Integer>();
		Stack<Integer> tempStack = new Stack<Integer>();
		
		if (s.isEmpty())
			System.out.println("Empty Stack");
		else
		{
			while (!s.isEmpty())
			{
				// no element to compare
				if (compareStack.isEmpty())
				{
					// put s.pop() directly to compareStack
					compareStack.push(s.pop());
				}
				else
				{
					// move all elements which are > s.peek() out.
					while (!compareStack.isEmpty())
					{
						// and store these elements in a temporary stack
						if (s.peek() < compareStack.peek())
							tempStack.push(compareStack.pop());
						else
							break;
					}
					// now, we can put this element into the compareStack
					compareStack.push(s.pop());
					// put all the greater elements back to compareStack.
					while (!tempStack.isEmpty())
						compareStack.push(tempStack.pop());
				}
			}
		}
		while (!compareStack.isEmpty())
		{
			s.push(compareStack.pop());
		}
	}

	public static void main(String[] args)
	{
		Stack<Integer> s = new Stack<Integer>();

		s.push(123);
		s.push(2333);
		s.push(1);
		s.push(23);
		s.push(23);

		SortStack ss = new SortStack();
		ss.sort(s);

		while (!s.isEmpty())
			System.out.println(s.pop());

	}
}
