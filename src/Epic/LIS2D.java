package Epic;

/**
 * find longest increasing sub sequence in 2d array
 * @author Zheng Lu
 * @date   Oct 3, 2012
 *
 */
public class LIS2D
{
	
	public static void findLISin2D(int[][] m)
	{
		int[][] dp = new int[m.length][m.length];
		int current= 0;

		for (int i = 0;i<m.length;i++)
		{
			for (int j = 0;j<m.length;j++)
			{
				current = m[i][j];
				int up = 0, left = 0, right = 0, down = 0;
				int updp = 0, leftdp = 0, rightdp = 0, downdp = 0;
				
				if (i>0)
					left = m[i-1][j];
				if (j>0)
					up = m[i][j-1];
				if (i<m.length-1)
					right = m[i+1][j];
				if (j<m.length-1)
					down = m[i][j+1];
				
				if (current == left+1)
					leftdp = dp[i-1][j]+1;
				if (current == right+1)
					rightdp = dp[i+1][j]+1;
				if (current == up + 1)
					updp = dp[i][j-1]+1;
				if (current == down+1)
					downdp = dp[i][j+1]+1;
				
				dp[i][j]=Math.max(Math.max(leftdp, rightdp), Math.max(updp, downdp));
				
			}
		}
		
		printMatrix(dp);
		
	}
	
	private static void printMatrix(int[][] m)
	{
		for (int i = 0;i<m.length;i++)
		{
			for (int j = 0;j<m.length;j++)
				System.out.print(m[i][j] + "\t");
			System.out.println();
		}		
	}
	public static void main(String[] args)
	{
		int[][] matrix = {{2,3,4,5}, {4,5,10,11},{20,6,9,12},{6,7,8,40}};	
		printMatrix(matrix);
		System.out.println("------------------------------------");
		findLISin2D(matrix);
	}
	
}
