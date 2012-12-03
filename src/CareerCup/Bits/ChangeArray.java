package CareerCup.Bits;
/**
 * CareerCup 2.1
 * Suppose we have an array a1, a2, ..., an, b1, b2, ..., bn. 
 * Implement an algorithm to change this array to a1, b1, a2, b2, ..., an, bn.
 * @author Zheng Lu
 *
 */


public class ChangeArray
{
	public static void main(String[] args)
	{
		String[] A = {"a1","a2","a3","a4", "b1", "b2", "b3","b4"};
		
		ChangeArray ca = new ChangeArray();
		
		ca.changeArray(A, 0, A.length-1);
		
		for(int i = 0;i<A.length;i++)
		{
			System.out.println(A[i]);
		}
	}
	
	public void changeArray(String[]a, int l, int r)
	{
		int left = l;
		int right = r;
		if (left == right) return;
		//divide
		int middle = (left + right)/2;
		//exchange a[(left+middle)/2...middle] with a[middle+1...(middle+right)/2]
		for (int i = 0; i<=(middle-left)/2; i++)
		{
			String temp = a[(left+middle)/2 + i];
			a[(left+middle)/2 + i] = a[middle+1+i];
			a[middle+1+i] = temp;
		}
		changeArray(a, left, middle);
		changeArray(a, middle+1, right);
	}
}
