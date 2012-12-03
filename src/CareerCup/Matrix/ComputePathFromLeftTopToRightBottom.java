package CareerCup.Matrix;

/**
 * Given a p*q matrix, How may unique path to move from the top left to the
 * right bottom. The movement can only move right or down.
 * 
 * @author Zheng Lu
 * @date Nov 19, 2012
 * 
 */
public class ComputePathFromLeftTopToRightBottom
{
	public int computePath(int p, int q)
	{
		if (p == 0)
			return 0;

		return computPathRec(p - 1, q - 1);
	}

	private int computPathRec(int i, int j)
	{
		if (i < 0 || j < 0)
			return 0;
		if (i == 0 || j == 0)
			return 1;

		return computPathRec(i - 1, j) + computPathRec(i, j - 1);
	}

	public int computePathDP(int p, int q)
	{
		if (p <= 0 || q <= 0)
			return 0;
		int[][] m = new int[p][q];
		for (int i = 0; i < p; i++)
			m[i][0] = 1;
		for (int j = 0; j < q; j++)
			m[0][j] = 1;

		for (int i = 1; i < p; i++)
		{
			for (int j = 1; j < q; j++)
				m[i][j] = m[i - 1][j] + m[i][j - 1];
		}

		return m[p - 1][q - 1];
	}

	public static void main(String[] args)
	{
		ComputePathFromLeftTopToRightBottom cp = new ComputePathFromLeftTopToRightBottom();

		// System.out.println(cp.computePath(15, 15));
		// System.out.println(cp.computePathDP(15, 15));

	}

}
