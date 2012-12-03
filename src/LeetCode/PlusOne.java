package LeetCode;

/**
 * @author Zheng Lu
 * @date Oct 16, 2012
 * 
 */
public class PlusOne
{
	public int[] plusOne(int[] digits)
	{
		if (digits.length == 0)
			return digits;

		boolean isDone = false;
		for (int i = digits.length - 1; i >= 0; i--)
		{
			if (digits[i] != 9)
			{
				digits[i]++;
				isDone = true;
				break;
			}
			else
			{
				digits[i]=0;
			}
		}

		if (isDone)
			return digits;
		else
		{
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			return result;
		}
	}

	public int[] plusOne2(int[] digits)
	{
		int n = digits.length;
		int[] result = new int[n + 1];

		for (int i = 0; i < n; i++)
		{
			result[i + 1] = digits[i];
		}

		int carry = 0;
		int plus = result[n] + 1;
		if (plus == 10)
		{
			carry = 1;
			result[n] = 0;
		} else
		{
			carry = 0;
			result[n] = plus;
		}

		for (int i = n - 1; i >= 0; i--)
		{
			plus = result[i] + carry;

			if (plus == 10)
			{
				carry = 1;
				result[i] = 0;
			} else
			{
				carry = 0;
				result[i] = plus;
			}
		}

		if (result[0] > 0)
			return result;
		else
		{
			int[] newresult = new int[n];
			for (int i = 0; i < n; i++)
				newresult[i] = result[i + 1];

			return newresult;
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
