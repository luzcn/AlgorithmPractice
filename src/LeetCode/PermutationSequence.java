package LeetCode;

import java.util.ArrayList;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * "123" "132" "213" "231" "312" "321"
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author Zheng Lu
 * @date Oct 25, 2012
 * 
 */
public class PermutationSequence
{

	public String getPermutation(int n, int k)
	{
		if (n == 0) return null;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++)
			list.add(i);
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		getPermsRec(list, solution, new ArrayList<Integer>(), 0);
		
		ArrayList<Integer> stringInK = solution.get(k-1);
		String s = "";
		for (int i = 0;i<stringInK.size();i++)
			s+=stringInK.get(i);
		
		System.out.println(solution);
		
		return s;
	}

	private ArrayList<ArrayList<Integer>> getPermsRec(ArrayList<Integer> list,
			ArrayList<ArrayList<Integer>> solution,
			ArrayList<Integer> currentSol, int index)
	{
		if (list.size() == 0)
		{
			solution.add(new ArrayList<Integer>(currentSol));
			return solution;
		}
		else
		{
			for (int i = index; i<list.size(); i++)
			{
				currentSol.add(list.get(i));
				list.remove(i);
				getPermsRec(list, solution, currentSol, index);
				list.add(i, currentSol.get(currentSol.size()-1));
				currentSol.remove(currentSol.size()-1);
			}
		}
		
		return solution;
	}

	public static void main(String[] args)
	{
		PermutationSequence ps = new PermutationSequence();
		String s = ps.getPermutation(3, 2);
		
		System.out.println(s);
	}

}
