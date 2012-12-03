package CareerCup.DynamicProgram;

/**
 * @author Zheng Lu
 * @date   Oct 2, 2012
 *
 */
public class SeedOfNumber
{

	public static void findSeed(int n)
	{
		for (int i=1;i<=n;i++)
		{
			int product = 1;
			int y = i;
			product *= y;
			while(y>0)
			{
				product = product*(y%10);
				y=y/10;
			}
			if (product==n)
				System.out.println(i);
		}
	}
	public static void main(String[] args)
	{
		findSeed(24);
	}

}
