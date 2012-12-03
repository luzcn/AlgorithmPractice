package Epic;

/**
 * Find all the possible passwords, 
 * given the length of the password and that it is a well ordered number 
 * (159 is well-ordered as 1<5<9)
 * 
 * @author Zheng Lu
 * Sep 24, 2012
 *
 */
public class FindPassword
{

	public static void findWellOrder(int len)
	{
		int[] nums = {0,1,2,3,4,5,6,7,8,9};
		
		for (int i = 0;i<=nums.length-len;i++)
		{
			for (int j = i+1;j<=nums.length-(len-1);j++)
			{
				System.out.print(nums[i]);
				for (int k = 0;k<len-1;k++)
					System.out.print(nums[j+k]);
				
				System.out.println();
			}	
		}
	}
	public static void main(String[] args)
	{
		FindPassword.findWellOrder(5);
	}

}
