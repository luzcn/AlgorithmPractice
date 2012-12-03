package LeetCode;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 * 
 * @author Zheng Lu
 * @date Oct 18, 2012
 * 
 */
public class MaximalRectangle
{

	public int maximalRectangle(char[][] matrix)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] auxilary = new int[rows][columns];
		
		if (rows == 0 ) return 0;
		
		//copy matrix to auxilary
		for (int i = 0;i<rows;i++)
		{
			for (int j = 0;j<columns;j++)
			{
				auxilary[i][j]=Character.getNumericValue(matrix[i][j]);
			}
		}
		for (int i = 1;i<rows;i++)
		{
			for (int j = 0;j<columns;j++)
			{
				if (auxilary[i][j] == 1)
					auxilary[i][j]=auxilary[i-1][j]+1;
			}
		}
		int max = 0;
		for (int i = 0;i<rows;i++)
		{
			int maxInRow = largestRectangle(auxilary[i]);
			if (maxInRow>max)
				max = maxInRow;
		}
		return max;
	}

	private int largestRectangle(int[] h)
	{
		if (h.length == 0) return 0;
		int[] width = new int[h.length];
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0;i<h.length;i++)
		{
			while(!stack.isEmpty())
			{
				if (stack.peek()>=h[i])
					stack.pop();
				else
					break;
			}
			if (stack.isEmpty())
				width[i]=i;
			else
				width[i]=i-stack.peek()-1;
			
			stack.push(i);
		}
		
		stack.clear();
		for (int i = h.length-1;i>=0;i--)
		{
			while(!stack.isEmpty())
			{
				if (stack.peek()>=h[i])
					stack.pop();
				else
					break;
			}
			
			if (stack.isEmpty())
				width[i] += h.length - i + 1;
			else
				width[i] += stack.peek() - i + 1;
			
			stack.push(i);
		}
		for (int i = 0;i<h.length;i++)
		{
			int area = h[i]*(width[i]+1);
			if (area> max)
				max = area;
		}
		return max;
	}
	
	public static void main(String[] args)
	{

	}

}
