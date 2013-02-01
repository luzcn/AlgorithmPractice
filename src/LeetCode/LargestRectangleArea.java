package LeetCode;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * @author Zheng Lu
 * @date Oct 5, 2012
 * 
 */
public class LargestRectangleArea
{

	/***
	 * O(n^2) solution
	 * 
	 * @param h
	 * @return
	 */
	public static int largestRectangleAreaBF(int[] h)
	{
		int maxarea = 0;
		int n = h.length;
		for (int i = 0; i < n; i++)
		{
			int lowest = h[i];
			for (int j = i; j < n; j++)
			{
				if (h[j] < lowest)
					lowest = h[j];
				int area = lowest * (j - i + 1);
				if (area > maxarea)
					maxarea = area;
			}
		}

		return maxarea;
	}

	/***
	 * The are area of each i can be computed as h[i]*(L+R+1), where L is the
	 * number of histograms that are greater than h[i] on the left side R is the
	 * number of histograms that are greater than h[i] on the right side
	 * 
	 * @param h
	 * @return
	 */
	public static int largestRectangleArea(int[] h)
	{
		if (h.length == 0)
			return 0;
		if (h.length == 1)
			return h[0];

		int maxarea = 0;
		Stack<Integer> s = new Stack<Integer>();
		int[] width = new int[h.length];

		// find the left bound
		for (int i = 0; i < h.length; i++)
		{
			while (!s.isEmpty())
			{
				if (h[s.peek()] >= h[i])
					s.pop();
				else
					break;
			}
			if (s.isEmpty())
				width[i] = i; // all the left side histograms are greater than
								// current
			else
				width[i] = i - s.peek() - 1;

			s.push(i);
		}

		// clear the stack
		s.clear();

		// find the right bound
		for (int i = h.length - 1; i >= 0; i--)
		{
			while (!s.isEmpty())
			{
				if (h[s.peek()] >= h[i])
					s.pop();
				else
					break;
			}

			if (s.isEmpty())
				width[i] += h.length - i - 1;
			else
				width[i] += s.peek() - i - 1;

			s.push(i);
		}

		for (int i = 0; i < h.length; i++)
		{
			int area = h[i] * (width[i] + 1);
			if (area > maxarea)
				maxarea = area;
		}
		return maxarea;
	}

	public static void main(String[] args)
	{
		System.out
				.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
	}

}
