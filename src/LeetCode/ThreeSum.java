package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ²
 * b ² c) The solution set must not contain duplicate triplets. For example,
 * given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * @author annie
 * 
 * @date Dec 13, 2012
 */
public class ThreeSum
{
	public ArrayList<ArrayList<Integer>> threeSum(int[] num)
	{
		int size = num.length;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (size == 0)
			return result;
		
		Arrays.sort(num);
		for (int i = 0;i<size-2;i++)
		{
			int j = i+1;
			int k = size-1;
			int target = 0 - num[i];
			
			while(j<k)
			{
				if (num[j] + num[k] == target)
				{
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[j]);
					list.add(num[k]);
					result.add(list);
					j++;
					k--;
				}
				else if (num[j] + num[k] > target)
					k--;
				else 
					j++;
			}
		}
		return result;
	}
	
	public ArrayList<ArrayList<Integer>> threeSumWithHashMap(int[] num)
	{
		int size = num.length;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		if (size == 0)
			return result;

		for (int i = 0; i < size; i++)
			map.put(num[i], i);

		for (int i = 0; i < size - 2; i++)
		{
			int a = num[i];
			int target = 0 - num[i];

			// now it is two sum
			for (int j = i + 1; j < size - 1; j++)
			{
				if (map.containsKey(target - num[j])
						&& map.get(target - num[j]) != j
						&& map.get(target - num[j]) != i)
				{
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[j]);
					list.add(target - num[j]);

					Collections.sort(list);
					if (!result.contains(list))
						result.add(list);
				}
			}
		}
		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
