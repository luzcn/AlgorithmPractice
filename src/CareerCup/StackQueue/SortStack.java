package CareerCup.StackQueue;

import java.util.Stack;

/**
 * sort a stack from top to bottom in ascending order
 * @author Zheng Lu
 *
 */
public class SortStack
{
	public void sort(Stack<Integer> s)
	{
		Stack<Integer> compareStack = new Stack<Integer>();
		Stack<Integer> tempStack = new Stack<Integer>();
		if (s.isEmpty()) System.out.println("Empty Stack");
		else
		{
			while(!s.isEmpty())
			{
				if (compareStack.isEmpty())						//no element to compare 
				{
					compareStack.push(s.pop());					//put s.pop() directly to compareStack
				}
				else
				{
					while (!compareStack.isEmpty())				//move all elements which are > s.peek() out.
					{
						if (s.peek()<compareStack.peek())
							tempStack.push(compareStack.pop());	//and store these elements in a temporary stack
						else break;	
					}
					compareStack.push(s.pop());					//now, we can put this element into the compareStack
					while(!tempStack.isEmpty())
						compareStack.push(tempStack.pop());		//put all the greater elements back to compareStack.
				}
			}
		}
		while(!compareStack.isEmpty())
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
		
		while(!s.isEmpty())
			System.out.println(s.pop());
		
	}
}
