package LeetCode;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 * where each element of each row is either 1 or the sum of the two elements
 * right above it
 * 
 * @author annie
 * 
 * @date Jan 16, 2013
 */
public class PascalTriangle
{
	public ArrayList<ArrayList<Integer>> generate(int numRows)
	{
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> current = new ArrayList<Integer>();

		if (numRows <= 0)
			return solution;

		current.add(1);
		solution.add(new ArrayList<Integer>(current));
		if (numRows == 1)
			return solution;

		current = new ArrayList<Integer>();
		current.add(1);
		current.add(1);
		solution.add(new ArrayList<Integer>(current));
		if (numRows == 2)
			return solution;

		for (int i = 3; i <= numRows; i++)
		{
			current = new ArrayList<Integer>();
			current.add(1);
			ArrayList<Integer> preRowList = solution.get(solution.size() - 1);

			for (int j = 1; j < i - 1; j++)
			{
				current.add(preRowList.get(j - 1) + preRowList.get(j));
			}
			current.add(1);
			solution.add(new ArrayList<Integer>(current));
		}

		return solution;
	}

	public ArrayList<Integer> getRow(int rowIndex)
	{
		ArrayList<Integer> pre = new ArrayList<Integer>();
		ArrayList<Integer> current = new ArrayList<Integer>();
		if (rowIndex <= 0)
			return current;

		current.add(1);
		if (rowIndex == 1)
			return current;
		current.add(1);
		if (rowIndex == 2)
			return current;

		pre = current;
		for (int i = 3; i <= rowIndex; i++)
		{
			current = new ArrayList<Integer>();
			current.add(1);
			for (int j = 1; j < i - 1; j++)
			{
				current.add(pre.get(j) + pre.get(j - 1));
			}
			current.add(1);
			pre = current;
		}
		return current;
	}

	public static void main(String[] args)
	{
		PascalTriangle pt = new PascalTriangle();
		System.out.println(pt.generate(5));
		System.out.println(pt.getRow(5));
	}

}
