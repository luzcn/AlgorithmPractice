package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * @author Zheng Lu
 * @date Oct 22, 2012
 * 
 */
public class MergeInterval
{

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals)
	{
		ArrayList<Interval> resultList = new ArrayList<Interval>();

		if (intervals.size() == 1)
			return intervals;

		Collections.sort(intervals, new Comparator<Interval>()
		{
			@Override
			public int compare(Interval o1, Interval o2)
			{
				return o1.start - o2.start;
			}
		});

		Interval temp = null;
		for (int i = 0; i < intervals.size(); i++)
		{
			if (temp == null)
				temp = intervals.get(i);
			else
			{
				Interval current = intervals.get(i);
				if (current.start <= temp.end)
					temp = new Interval(Math.min(current.start, temp.start),
							Math.max(current.end, temp.end));
				else
				{
					resultList.add(temp);
					temp = current;
				}
			}
		}
		if (temp != null)
			resultList.add(temp);

		return resultList;
	}

	public static void main(String[] args)
	{
		Interval i1 = new Interval(2, 4);
		Interval i2 = new Interval(1, 3);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);

		Collections.sort(intervals, new Comparator<Interval>()
		{
			@Override
			public int compare(Interval o1, Interval o2)
			{
				return o1.start - o2.start;
			}
		});

		for (Interval i : intervals)
		{
			System.out.println(i.start + "   " + i.end);
		}

	}

}
