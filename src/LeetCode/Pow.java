package LeetCode;

/**
 * Implement pow(x, n).
 * 
 * @author annie
 * 
 * @date Feb 4, 2013
 */
public class Pow
{
	public double pow(double x, int n)
	{
		boolean isNeg = (n < 0);
		n = (n ^ (n >> 31)) - (n >> 31);
		double odd = 1.0;

		while (n != 0)
		{
			if ((n & 1) != 0)
				odd *= x;
			x *= x;
			n = n >> 1;
		}
		if (isNeg)
			return 1 / odd;
		else
			return odd;
	}

	public static void main(String[] args)
	{
		Pow p = new Pow();
		System.out.println(p.pow(2, 1));
	}

}
