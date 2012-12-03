package CareerCup.Recursion;

import java.util.ArrayList;

/**
 * compute all the sub set of a given set.
 * 
 * @author Zheng Lu Sep 20, 2012
 * 
 */
public class PowerSet
{

	/***
	 * The recursive solution
	 * 
	 * @param set
	 * @param index
	 */
	public ArrayList<ArrayList<Integer>> computePowerSet(
			ArrayList<Integer> set, int index)
	{
		ArrayList<ArrayList<Integer>> allsubset = null;
		/** base condition **/
		if (set.size() == index)
		{
			allsubset = new ArrayList<ArrayList<Integer>>();
			// add the empty set
			allsubset.add(new ArrayList<Integer>());
		} else
		{
			/** recursive **/
			allsubset = computePowerSet(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();

			for (ArrayList<Integer> subset : allsubset)
			{
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubset.addAll(moresubsets);
		}
		return allsubset;
	}

	public ArrayList<ArrayList<Integer>> computePowerSet2(
			ArrayList<Integer> set)
	{
		ArrayList<ArrayList<Integer>> allsubset = new ArrayList<ArrayList<Integer>>();
		int max = 1<<set.size();
		
		for (int i = 0;i<max; i++)
		{
			ArrayList<Integer> subset = new ArrayList<Integer>();
			int k = i;
			int index = 0;
			
			while(k>0)
			{
				if ((k&1)>0)
				{
					subset.add(set.get(index));
				}
				k = k>>1;
				index ++;
			}
			allsubset.add(subset);
		}
		return allsubset;
	}

	public static void main(String[] args)
	{
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		
		PowerSet ps = new PowerSet();
		ArrayList<ArrayList<Integer>> powerSet = ps.computePowerSet(set,0);
		System.out.println(powerSet);
		
//		for (ArrayList<Integer> sub:powerSet)
//		{
//			for (int i = 0;i<sub.size();i++)
//				System.out.print(sub.get(i)+"  ");
//			
//			System.out.println();
//		}
	}

}
