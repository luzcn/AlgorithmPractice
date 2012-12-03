package LeetCode;

import java.util.ArrayList;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * 
 * @author Zheng Lu
 * @date Oct 3, 2012
 * 
 */
public class JumpGame
{

	public static boolean canJump(int[] A)
	{
		int n = A.length;
		boolean[] rachable = new boolean[n];
		rachable[0] = true;
		int current = 0;

		while (current < n)
		{
			if (rachable[current])
			{
				for (int i = 0; i < A[current]; i++)
				{
					if (current + i >= n - 1)
						return true;
					rachable[current + i] = true;
				}
			}
			current++;
		}
		return false;
	}

	/***
	 * Greedy solution
	 * for each entry, we can find a jump range. From this range, we get the maximum
	 * number and continue in next entry.
	 * @param A
	 * @return
	 */
	public static int jump(int[] A)
	{
		int current = 0;
		int n = A.length;
		int jumps = 0;	//The total jumps
		int current_furtherest = 0;	//the furtherest steps can go from current position 
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		while(current<n)
		{
			current_furtherest = A[current]+current;
			if (current_furtherest - current == 0)
			{
				System.out.println("Unreachable");
				return -1;
			}
			if (current_furtherest > 0)
			{
				path.add(A[current]);
				jumps++;
			}
			if (current_furtherest >= n-1) 
			{
				System.out.println(path);
				return jumps;
			}
			
			int maxJumpInRange = 0;
			for (int i = current+1;i<=current_furtherest;i++)
			{
				if (A[i]+i > maxJumpInRange)
				{
					maxJumpInRange = A[i]+i;
					current = i;
				}
			}
		}
		return jumps;
	}

	public static void main(String[] args)
	{
		int[] A = {1};
		System.out.println(jump(A));
	}

}
