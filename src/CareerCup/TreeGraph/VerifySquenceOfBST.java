package CareerCup.TreeGraph;

/**
 * 输入一个整数数组，判断该数组是不是某二元查找树的后序遍历的结果。如果是返回true，否则返回false。
 * 例如输入5、7、6、9、11、10、8，由于这一整数序列是如下树的后序遍历结果：
 * 
 * 因此返回true。
 * 
 * @author annie
 * 
 * @date Jan 9, 2013
 */
public class VerifySquenceOfBST
{

	public boolean verifySquenceOfBST(int[] nums)
	{
		if (nums.length == 0)
			return false;

		return verifySquenceOfBSTHelper(nums, 0, nums.length - 1);
	}

	private boolean verifySquenceOfBSTHelper(int[] A, int l, int r)
	{
		if (r < l || r > A.length - 1)
			return false;

		int root = A[r];

		int i = l;
		while (i < r)
		{
			if (A[i] > root)
				break;
			i++;
		}

		int j = i;
		while (j < r)
		{
			if (A[j] < root)
				return false;
			j++;
		}

		boolean left = true;
		boolean right = true;
		if (i > 0)
			left = verifySquenceOfBSTHelper(A, l, i - 1);
		if (j < r)
			right = verifySquenceOfBSTHelper(A, i, r);

		return left && right;
	}

	public static void main(String[] args)
	{
		int[] nums = { 5, 6, 4 };
		VerifySquenceOfBST vs = new VerifySquenceOfBST();
		System.out.println(vs.verifySquenceOfBST(nums));
	}

}
