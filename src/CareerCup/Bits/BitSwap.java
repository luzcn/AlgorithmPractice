package CareerCup.Bits;

public class BitSwap
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		BitSwap bs = new BitSwap();
//		System.out.println(bs.bitSwap(-31, -14));
		System.out.print(bs.findMaximun(-31, 2));
	}
	
	private int bitSwap(int a, int b)
	{
		int count = 0;
		for (int c = a^b; c!=0;c = c>>1 )
		{
			count += c & 1;
		}
		
		return count;
	}
	
	private int findMaximun(int a, int b)
	{
		int c = a - b;
		//if a is smaller , c becomes negative. 
		//thus when right shifting by 31 bits , c becomes 1 and k becomes 1.
		int k = (c>>31) & 0x1;	

		
		return a-k*c;
	}
}
