package LeetCode;

/**
 * @author Zheng Lu
 * @date   Oct 1, 2012
 *
 */


public class IntegerToRoman
{
	public static String intToRoman(int num)
	{
		StringBuffer result=new StringBuffer();
		String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		
		for (int i = 0;i<value.length;i++)
		{
			while (num>=value[i])
			{
				result.append(roman[i]);
				num -= value[i];
			}
		}
		return result.toString();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(intToRoman(5000));
	}

}
