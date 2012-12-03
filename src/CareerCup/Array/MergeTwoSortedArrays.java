package CareerCup.Array;

/**
 * There are two sorted arrays A1 and A2. 
 * 
 * Array A1 is full where as array A2 is partially empty 
 * and number of empty slots are just enough to accommodate all elements of A1. 
 * 
 * Write a program to merge the two sorted arrays to fill the array A2. 
 * 
 * You cannot use any additional memory and expected run time is O(n). 
 * 
 * @author Zheng Lu
 *
 */
public class MergeTwoSortedArrays
{
	public static void main(String[] args)
	{
		int[] a1 = {6,7,10};
		int[] a2 = new int[7];
		a2[0] = 1;
		a2[1] = 3;
		a2[2] = 13;
		a2[3] = 20;
		
		MergeTwoSortedArrays msa = new MergeTwoSortedArrays();
		msa.mergeSortedArray(a1, a2);
		
		for (int i = 0;i<a2.length;i++)
		{
			System.out.println(a2[i]);
		}
		
	}

	/**
	 * Assumption: a2 has exact enough empty slots to hold a1
	 * @param a1	sorted array 1
	 * @param a2	sorted array 2
	 */
	public void mergeSortedArray(int[] a1, int[] a2)
	{
		int last_elem1 = a1.length - 1;;				//the last none empty element in array 1
		int last_elem2 = a2.length - a1.length -1;		//the last none empty element in array 2
		int last_pos_in_array2 = a2.length - 1;			//the last position int array2, last_pos > last_elem2
		
		while(last_elem1 >= 0)
		{
			if (a1[last_elem1] >= a2[last_elem2])
			{
				/**The last element in array1 is greater than in a2, 
				 * we need to move the last element of array1 to the last position in array2**/
				a2[last_pos_in_array2] = a1[last_elem1];
				last_pos_in_array2--;
				last_elem1--;
			}
			else 		//if (a1[last_elem1] < a2[last_elem2])
			{
				a2[last_pos_in_array2] = a2[last_elem2];
				last_pos_in_array2--;
				last_elem2--;
			}
		}
	}
}
