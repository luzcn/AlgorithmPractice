package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Insert Interval: Given a set of non-overlapping intervals, insert a new
 * interval into the intervals (merge if necessary). You may assume that the
 * intervals were initially sorted according to their start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author Zheng Lu Oct 1, 2012
 * 
 */
public class InsertInterval
{

	/**
	 * Case 1: It is smaller than all the intervals in the list. Case 2: It is
	 * greater than all the intervals in the list. Case 3: It overlaps some
	 * intervals in the list. Case 4: It does not overlap, but resides between
	 * two intervals.
	 * 
	 * Therefore, our solution goes as following: 1) Go through the list of
	 * intervals, find out the ones that are not overlapped to the new interval,
	 * put them into a new list
	 * 
	 * 2) Check if there are overlapped intervals 2.1) if true, then merger the
	 * overlapped intervals and the new interval into one 2.2) if false, then
	 * add the new interval into the list.
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public static ArrayList<Interval> insertInterval(
			ArrayList<Interval> intervals, Interval newInterval)
	{
		ArrayList<Interval> solution = new ArrayList<Interval>();
		Interval temp = newInterval;

		for (Interval I : intervals)
		{
			if (isOverLap(I, newInterval) == false)
				solution.add(I);
			else
			{
				// int start =
				// I.start>newInterval.start?newInterval.start:I.start;
				// int end = I.end>newInterval.end?I.end:newInterval.end;
				// newInterval.start = start;
				// newInterval.end = end;

				temp.start = Math.min(I.start, temp.start);
				temp.end = Math.max(I.end, temp.end);
			}
		}
		solution.add(temp);

		return solution;
	}

	public static boolean isOverLap(Interval l1, Interval l2)
	{
		if ((l2.start <= l1.end && l2.start >= l1.start)
				|| (l1.start <= l2.end && l1.start >= l2.start))
			return true;
		else
			return false;
		
		// if (l1.start<l2.start && l2.start<l1.end)
		// return true;
		// if (l1.start>l2.start && l1.start<l2.end)
		// return true;
		// if ((l1.start>l2.start && l1.end<l2.end) || (l2.start>l1.start &&
		// l2.end<l1.end))
		// return true;
		// return false;
	}

	public static void main(String[] args)
	{
		Interval newInterval = new Interval(4, 9);

		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));

		// System.err.println(isOverLap(new Interval(1,4), new Interval(6,9)));

		ArrayList<Interval> solution = insertInterval(intervals, newInterval);
		Collections.sort(solution, new customComparator());
		for (Interval i : solution)
		{
			System.out.println(i.start + "  " + i.end);
		}
	}
}

class customComparator implements Comparator<Interval>
{

	@Override
	public int compare(Interval l1, Interval l2)
	{
		return l1.start >= l2.start ? 1 : 0;
	}
}

class Interval
{
	int start;
	int end;

	Interval()
	{
		start = 0;
		end = 0;
	}

	Interval(int s, int e)
	{
		start = s;
		end = e;
	}
}
