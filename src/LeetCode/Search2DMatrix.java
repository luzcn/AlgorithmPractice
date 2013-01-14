package LeetCode;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row.
 * 
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ]
 * 
 * Given target = 3, return true.
 * 
 * @author Zheng Lu
 * @date Nov 6, 2012
 * 
 */
public class Search2DMatrix
{

	public boolean searchMatrix(int[][] matrix, int target)
	{
		int m = matrix.length; // row
		int n = matrix[0].length; // column

		int i = m - 1;
		int j = 0;

		while (i >= 0 && j < n)
		{
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] < target)
				j++;
			else
				i--;

		}
		return false;
	}

	public boolean searchMatrixQuadPartation(int[][] matrix, int target)
	{
		int i = 0;
		int j = 0;
		int k = matrix.length - 1;
		int l = matrix[0].length - 1;

		return searchMatrixQuadPartationRec(matrix, target, i, j, k, l);
	}

	/**
	 * 
	 * @param matrix
	 * @param target
	 */
	private boolean searchMatrixQuadPartationRec(int[][] matrix, int target,
			int i, int j, int k, int l)
	{
		if (i > k || j > l)
			return false;

//		int midX = i + (k - i) / 2;
//		int midY = l + (j - l) / 2;
		int midX = (i + k)/2;
		int midY = (j + l)/2;

		if (target == matrix[midX][midY])
			return true;
		else if (i == k || j == l)
			return false;

		if (target < matrix[midX][midY])
			return searchMatrixQuadPartationRec(matrix, target, i, j, midX,
					midY);
		else
			return searchMatrixQuadPartationRec(matrix, target, midX + 1, j, k,
					midY)
					|| searchMatrixQuadPartationRec(matrix, target, i,
							midY + 1, midX, l)
					|| searchMatrixQuadPartationRec(matrix, target, midX + 1,
							midY + 1, k, l);
	}

	public static void main(String[] args)
	{
		int[][] M = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 },
				{ 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		Search2DMatrix sm = new Search2DMatrix();

		System.out.println(sm.searchMatrixQuadPartation(M, 21));
	}

}
