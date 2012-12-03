package LeetCode;

public class ContainerWithMostWater
{

	/** Brutal force **/
	public static int findContainer(int[] nums)
	{
		int max = 0;

		for (int i = 0; i < nums.length; i++)
		{
			for (int j = i + 1; j < nums.length; j++)
			{
				int area = (j - i) * Math.min(nums[i], nums[j]);
				if (area > max)
					max = area;
			}
		}

		return max;
	}

	public static int maxArea(int[] h) 
    {
       int max = 0;
       int i = 0;
       int j = h.length-1;
       
       while(i<j)
       {
          int height = Math.min(h[i],h[j]);
          int area = height*(j-i);
          if (area>max) max = area;
          
          if (h[i]>=h[j]) j--;
          else i++;
       }
       return max;
    }


	public static void main(String[] args)
	{
		int[] nums = { 6, 7, 2, 10, 5, 12 };

		System.out.println(findContainer(nums));
		System.out.println(maxArea(nums));
	}
}
