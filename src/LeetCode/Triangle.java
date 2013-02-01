/**
 * 
 */
package LeetCode;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 * 
 * @author Zheng Lu
 * 
 */
public class Triangle
{
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle)
	{
		if (triangle == null)
			return 0;
		if (triangle.size() == 0)
			return 0;
		 return minimumTotalRec(triangle, 0, 0);
	}

	private int minimumTotalRec(ArrayList<ArrayList<Integer>> triangle,
			int level, int index)
	{
		if (level == triangle.size())
			return 0;

		return triangle.get(level).get(index)
				+ Math.min(minimumTotalRec(triangle, level + 1, index),
						minimumTotalRec(triangle, level + 1, index + 1));
	}

	public int minimumTotalDP(ArrayList<ArrayList<Integer>> triangle)
	{
		int rows = triangle.size();
		if (rows == 0)
			return 0;
		int[] minSums = new int[rows];
		int[] temp = new int[rows];

		for (int r = 0; r < rows; r++)
		{
			ArrayList<Integer> rowList = triangle.get(r);
			if (rowList.size() != r + 1)
				return 0;
			temp[0] = rowList.get(0) + (r > 0 ? minSums[0] : 0);

			for (int i = 1; i < r; i++) // r + 1 is the size of current list
			{
				temp[i] = rowList.get(i) + Math.min(minSums[i - 1], minSums[i]);
			}
			if (r > 0)
				temp[r] = rowList.get(r) + minSums[r - 1];

			minSums = temp;
			temp = new int[rows];
		}
		int min = minSums[0];
		for (int i = 1; i < minSums.length; i++)
		{
			if (minSums[i] < min)
				min = minSums[i];
		}
		return min;
	}

	public static void main(String[] args)
	{
		Triangle t = new Triangle();
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(-1);

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(3);

		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(1);
		list3.add(-1);
		list3.add(-3);

		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);

		System.out.println(t.minimumTotal(triangle));
		System.out.println(t.minimumTotalDP(triangle));
	}
}
