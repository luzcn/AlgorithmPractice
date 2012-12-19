package LeetCode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST
 * 
 * @author annie
 * 
 * @date Dec 17, 2012
 */
public class ConvertSortedArrayToBST
{

	public TreeNode sortedArrayToBST(int[] num)
	{
		if (num.length == 0)
			return null;
		return sortedArrayToBSTRec(num, 0, num.length - 1);
	}

	private TreeNode sortedArrayToBSTRec(int[] arr, int start, int end)
	{
		if (start > end)
			return null;

		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = sortedArrayToBSTRec(arr, start, mid - 1);
		root.right = sortedArrayToBSTRec(arr, mid + 1, end);

		return root;
	}

	public static void main(String[] args)
	{

	}

}
