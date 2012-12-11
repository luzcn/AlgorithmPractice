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
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int levels = triangle.size();
		result.add(new ArrayList<Integer>(triangle.get(0)));

		for (int i = 1; i < levels; i++)
		{
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(result.get(i - 1).get(0) + triangle.get(i).get(0));

			for (int j = 1; j < triangle.get(i).size() - 1; j++)
			{
				int n1 = result.get(i - 1).get(j) + triangle.get(i).get(j);
				int n2 = result.get(i - 1).get(j - 1) + triangle.get(i).get(j);

				list.add(Math.min(n1, n2));
			}
			list.add(result.get(i - 1).get(result.get(i - 1).size() - 1)
					+ triangle.get(i).get(triangle.get(i).size() - 1));
			result.add(list);
		}

		ArrayList<Integer> list = result.get(result.size() - 1);
		int min = Integer.MAX_VALUE;
		for (int n : list)
		{
			if (n < min)
				min = n;
		}
		return min;
	}

	public int minimumTotalDP(ArrayList<ArrayList<Integer>> triangle)
	{
		int rows = triangle.size();
		if (rows == 0) return 0;
		int[] minSums = new int[rows];
		int[] temp = new int[rows];
		
		for (int r = 0;r<rows;r++)
		{
			ArrayList<Integer> rowList = triangle.get(r);
			if (rowList.size() != r + 1)
				return 0;
			temp[0] = rowList.get(0) + (r>0?minSums[0]:0);
			
			for (int i = 1;i<r;i++)	//r + 1 is the size of current list
			{
				temp[i] =  rowList.get(i) + Math.min(minSums[i-1], minSums[i]);
			}
			if (r>0)
				temp[r] = rowList.get(r) + minSums[r-1];
			
			minSums = temp;
			temp = new int[rows];
		}
		int min = minSums[0];
		for (int i = 1;i<minSums.length;i++)
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
