package LeetCode;

import java.util.LinkedList;

import AlgorithmDataStructure.Sort;

public class Sum
{
	/***
	 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
	 * Find all unique triplets in the array which gives the sum of zero.
	 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b<= c)
	 * The solution set must not contain duplicate triplets.
	 *  For example, given array S = {-1 0 1 2 -1 -4},
	 *  A solution set is:
	 *  (-1, 0, 1)
	 *  (-1, -1, 2)
	 *  
	 *  From leetcode.com
	 *
	 */
	private void sum3(int[] s)
	{
		int n = s.length;
		
		/**
		 * The array starts from 0 to n-1;
		 * index i starts from 0 to n-3
		 * index j starts from 1 t0 n-2
		 * index k starts from n-1 to k
		 */
		for (int i = 0;i<n-2;i++)
		{
			int j = i+1;
			int k = n-1;
			
			while(j<k)
			{
				if (s[i]+s[j]+s[k] == 0)
				{
					System.out.println("(" +s[i] +" "+s[j]+" " +s[k] +" "+ ")");
					break;
				}
				else if (s[i]+s[j]+s[k] > 0)
					k--;
				else
					j++;
			}
		}
	}
	
	public void sum3Closet(int[] s, int target)
	{
		int n = s.length;
		int closet = Integer.MAX_VALUE;
		LinkedList<Triple> list = new LinkedList<Triple>();
		
		for (int i = 0;i<n-2;i++)	//starts from 0 to n-3
		{
			int j = i+1;
			int k = n-1;
			
			while(j<k)
			{
				if (s[i]+s[j]+s[k] == target)		//if equal, it is the closet one
				{
					System.out.println("(" +s[i] +" "+s[j]+" " +s[k] +" "+ ")");
					break;
				}
				else if (s[i]+s[j]+s[k] > target)
				{
					if (Math.abs(s[i]+s[j]+s[k] - target) < Math.abs(closet))
					{
						Triple t = new Triple(s[i], s[j], s[k]);
						closet = Math.abs(s[i]+s[j]+s[k] - target);
						list.clear();
						list.add(t);
					}
					else if (Math.abs(s[i]+s[j]+s[k] - target) == Math.abs(closet))
					{
						Triple t = new Triple(s[i], s[j], s[k]);
						closet = Math.abs(s[i]+s[j]+s[k] - target);
						list.add(t);
					}
					k--;
				}
				else
				{
					if (Math.abs(s[i]+s[j]+s[k] - target) < Math.abs(closet))
					{
						Triple t = new Triple(s[i], s[j], s[k]);
						closet = Math.abs(s[i]+s[j]+s[k] - target);
						list.clear();
						list.add(t);
					}
					else if (Math.abs(s[i]+s[j]+s[k] - target) == Math.abs(closet))
					{
						Triple t = new Triple(s[i], s[j], s[k]);
						closet = Math.abs(s[i]+s[j]+s[k] - target);
						list.add(t);
					}
					j++;
				}
			}
		}//end for
		for(Triple t : list)
		{
			System.out.println(t.num1 + " "+t.num2 +" " + t.num3);
		}	
	}
	
	
	public static void main(String[] args)
	{
		Sum sum = new Sum();
		Sort s = new Sort();
		
		int[] num = {-1, 2, 1, -4};
		s.quickSort(num);
//		sum.sum3(num);
		sum.sum3Closet(num, 1);
	}

}

class Triple
{
	int num1;
	int num2;
	int num3;
	
	public Triple(int a, int b, int c)
	{
		num1 = a; num2 = b; num3 = c;
	}
}