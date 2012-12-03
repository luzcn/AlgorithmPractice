package ProgrammingPearls;
/**
 * Rotate a one-dimensional array of N elements left by I position.
 * For instance, withN = 8 and I = 3, the vector ABCDEFG
 * is rotated to DEFGABC. (Programming Pearls, Column 2.1B)
 * @author Zheng Lu
 *
 */
public class Reverse
{
	public static void main(String[] args)
	{
		Reverse test = new Reverse();
		
		int[] array = new int[]{1,2,3,4,5,6,7,8,9};
		int x = 3;
		test.reverse(array, 0, x-1);
		test.reverse(array, x, array.length - 1);
		test.reverse(array, 0, array.length - 1);
		for (int i = 0;i<array.length;i++)
		{
			System.out.print(array[i]);
		}
	}
	
	private void reverse (int[] array, int startPoint, int endPoint)
	{
		int temp = 0;
		for (int i = 0;i<=(endPoint-startPoint)/2; i++)
		{
			temp = array[startPoint + i];
			array[startPoint + i] = array[endPoint -i];
			array[endPoint -i] = temp;
		}
	}
}
