package CareerCup.Array;

import AlgorithmDataStructure.Sort;


public class FindPairs
{
	public static void main(String[] args)
	{
		int[] A = {9, 3, 6, 5, 7, -1, 13, 14, -2, 12, 0};
		int V = 10;
		
		Sort s= new Sort();
		s.quickSort(A);
		
		FindPairs fp = new FindPairs();
		fp.findPairs(A, V);
	}
	
	/**
	 * Design an algorithm to find all pairs of integers within an array which sum to a specified value.
	 * This question means with a given value V, for each element X in the array, 
	 * can we find any element Y in the array which satisfy  Y = V-X.
	 * @author Zheng Lu
	 *
	 */
	private void findPairs(int[] a, int v)
	{
		int first = 0;
		int last = a.length - 1;
		
		while(first <= last)
		{
			if (a[first]+a[last] == v)
			{
				System.out.println(a[first]+"  "+a[last]);
				first++;
			}
			else if(a[first]+a[last] < v)
			{
				first++;
			}
			else if(a[first]+a[last] > v)
			{
				last--;
			}
		}
	}	
}
