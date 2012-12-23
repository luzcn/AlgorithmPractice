package LeetCode;

import java.util.ArrayList;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0 01 - 1 11 - 3 10 - 2
 * 
 * The tricky part of this question is to recognize the recursive structure
 * here. For n = 0, sol = [0], that’s the base case. For recursive step, let’s
 * take n = 2 and n = 3 as examples. n = 2, sol = [0, 1, 3, 2]; n = 3, sol = [0,
 * 1, 3, 2, 6, 7, 5, 4]. Look at these two solutions, we see when n = 3, we add
 * 4 more elements [6, 7, 5, 4] and they are just [2+4, 3+4, 1+4, 0+4]. That is
 * sol(n+1) = sol(n) + [ reverse(sol(n)) + 2^(n) ].
 * 
 * @author annie
 * 
 * @date Dec 21, 2012
 */
public class GrayCode
{
	public ArrayList<Integer> grayCode(int n)
	{
		return grayCodeRec(n);
	}

	private ArrayList<Integer> grayCodeRec(int n)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (n == 0)
		{
			result.add(0);
			return result;
		}
		else
		{
			ArrayList<Integer> prev = grayCodeRec(n - 1);
			result.addAll(prev);

			for (int i = prev.size() - 1; i >= 0; i--)
				result.add(prev.get(i) + (int) Math.pow(2.0, n - 1));
			return result;
		}
	}

	public ArrayList<Integer> grayCodeBit(int n)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		int size = (int) Math.pow(2.0, n);

		for (int i = 0; i < size; i++)
			result.add((i >> 1) ^ i);
		return result;

	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
