package CareerCup.String;

import java.util.Stack;

/**
 * @author annie
 * 
 * @date Jan 9, 2013
 */
public class CalculateExpression
{

	/**
	 * input a calculation expression without parentheses
	 * 
	 * for example: 12+3*2-1
	 * 
	 * @param s
	 * @return
	 */
	public int calculate(String s)
	{
		if (s.length() == 0 || s == null)
			return 0;

		String postExpr = changeToPostOrder(s);
		System.out.println(postExpr);
		
		return calculatePostOrderExpr(postExpr);
	}

	private int calculatePostOrderExpr(String postExpr)
	{
		int num = 0;
		Stack<Integer> numStack = new Stack<Integer>();

		if (postExpr == null || postExpr.isEmpty())
			return 0;
		int i = 0;

		while (i < postExpr.length())
		{
			char c = postExpr.charAt(i);
			if (Character.isDigit(c))
			{
				i = getNumber(postExpr, i, numStack);
			}
			else
			{
				if (isOperator(c))
				{
					int operation1 = 0;
					int operation2 = 0;

					if (!numStack.isEmpty())
						operation2 = numStack.pop();
					else
						throw new RuntimeException("invalid input");

					if (!numStack.isEmpty())
						operation1 = numStack.pop();
					else
						throw new RuntimeException("invalid input");

					num = computeExpression(operation1, operation2, c);
					numStack.push(num);
				}
				i++;
			}
		}
		num = numStack.peek();
		// System.out.println(numStack);
		return num;
	}

	private int computeExpression(int op1, int op2, char operator)
	{
		if (operator == '+')
			return op1 + op2;
		else if (operator == '-')
			return op1 - op2;
		else if (operator == '*')
			return op1 * op2;
		else
			return op1 / op2;
	}

	/**
	 * change the inorder expression to post order
	 * 
	 * @param s
	 * @return
	 */
	private String changeToPostOrder(String s)
	{
		Stack<Character> stack = new Stack<Character>();
		String postStr = "";
		int i = 0;
		while (i < s.length())
		{
			if (Character.isDigit(s.charAt(i)))
			{
				postStr += s.charAt(i);
			}
			else if (isOperator(s.charAt(i)))
			{
				postStr += " ";
				while (!stack.isEmpty()
						&& isPriorityLower(s.charAt(i), stack.peek()))
					postStr += stack.pop();

				stack.push(s.charAt(i));
			}
			i++;
		}
		while (!stack.isEmpty())
			postStr += stack.pop();
		return postStr;
	}

	private boolean isOperator(char c)
	{
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	/**
	 * compare the priority level of two operators
	 * 
	 * @param op1
	 * @param op2
	 * @return true if op1 is lower than or equal op2
	 */
	private boolean isPriorityLower(char op1, char op2)
	{
		if (op1 == '+' || op1 == '-')
			return true;
		else
			return false;
	}

	/**
	 * Get all the single numbers from the expression string
	 * 
	 * @param s
	 * @param i
	 *            start position
	 * @return the end position of the number in the string
	 */
	private int getNumber(String s, int i, Stack<Integer> numStack)
	{
		if (s.length() == 0 || s == null)
			return 0;
		int num = 0;

		int j = i;
		for (j = i; j < s.length(); j++)
		{
			if (Character.isDigit(s.charAt(j)))
			{
				num = num * 10 + Character.getNumericValue(s.charAt(j));
			}
			else
				break;
		}

		numStack.push(num);
		return j;
	}

	public static void main(String[] args)
	{
		CalculateExpression ce = new CalculateExpression();
		System.out.println(ce.calculate("22+ 3   *   6*4"));
	}

}
