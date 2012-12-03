package LeetCode;

/**
 * Divide two integers without using multiplication, division and mod operator. 
 * 
 * @author Zheng Lu
 * Sep 30, 2012
 *
 */
public class DivideTwoInteger
{
	public static int divide(int dividend, int divisor)
	{
		if (dividend == 0 || divisor == 1) return dividend;
		if (dividend == divisor) return 1;
		if (divisor == 2) return dividend >> 1;
		
		boolean sign=false;
		if ( (dividend<0 && divisor>0) || (dividend>0 && divisor<0))	//negative
			sign = true;
		
		if(dividend == Integer.MAX_VALUE && divisor == Integer.MIN_VALUE)
            return 0;
        
		long div1;
		long div2;
		
		/**
		 *  if we use Math.abs to compute the absolute value of Integer.MIN(-2147483648), 
		 *  we get -2147483648 again. So we should manually make it equal to Integer.MAX(2147483647)
		 */
		if (dividend == Integer.MIN_VALUE)
			div1 = Integer.MAX_VALUE;
		else
			div1 = Math.abs(dividend);
		
		if (divisor == Integer.MIN_VALUE)
			div2 = Integer.MAX_VALUE;
		else
			div2 = Math.abs(divisor);
		
		int result = (int) Math.floor(Math.pow(Math.E, (Math.log(div1) - Math.log(div2))));
        return sign ? -result : result;
		
	}
	
	public static void main(String[] args)
	{

	}

}
