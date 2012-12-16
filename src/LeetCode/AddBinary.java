package LeetCode;

/**
 * Given two binary strings, return their sum (also a binary string). For
 * example, a = "11" b = "1" Return "100".
 * 
 * @author Zheng Lu
 * 
 */
public class AddBinary
{
	public String addBinary(String a, String b)
	{
		int n1 = a.length();
		int n2 = b.length();

		if (n1 == 0)
			return b;
		if (n2 == 0)
			return a;

		int n = Math.max(n1, n2);
		while (a.length() < n)
			a = "0" + a;
		while (b.length() < n)
			b = "0" + b;

		int carry = 0;
		StringBuffer result = new StringBuffer();

		for (int i = n - 1; i >= 0; i--)
		{
			int d1 = Character.getNumericValue(a.charAt(i));
			int d2 = Character.getNumericValue(b.charAt(i));
			int d3 = d1 + d2 + carry;
			if (d3 == 0 || d3 == 1)
				carry = 0;
			else if (d3 == 2)
			{
				carry = 1;
				d3 = 0;
			}
			else if (d3 == 3)
			{
				carry = 1;
				d3 = 1;
			}
			result.append(d3);
		}
		if (carry > 0)
			result.append(1);

		return result.reverse().toString();
	}

	private String add(String s1, String s2)
	{
		int size = s1.length() >= s2.length() ? s1.length() : s2.length();
		int[] array1 = new int[size];
		int[] array2 = new int[size];
		int[] sumarray = new int[size + 1]; // always need 1 more space for ad
		int ad = 0;
		int sum = 0;
		String s = "";

		/** put the these two Strings to two arrays **/
		int n1 = size;
		for (int i = s1.length(); i > 0; i--)
		{
			String c = s1.substring(i - 1, i);
			array1[--n1] = Integer.parseInt(c);
		}
		int n2 = size;
		for (int i = s2.length(); i > 0; i--)
		{
			String c = s2.substring(i - 1, i);
			array2[--n2] = Integer.parseInt(c);
		}

		System.out.print("String 1 is: ");
		for (int i = 0; i < size; i++)
		{
			System.out.print(array1[i] + " ");
		}
		System.out.println();
		System.out.print("String 2 is: ");
		for (int i = 0; i < size; i++)
		{
			System.out.print(array2[i] + " ");
		}
		System.out.println();

		/** start to add **/
		int n = size - 1;
		int m = sumarray.length;
		while (n >= 0)
		{
			int a = array1[n];
			int b = array2[n];

			// the add up
			if ((a & b & ad) == 1) // three '1'
			{
				sum = 1;
				ad = 1;
			}
			else if ((a | b | ad) == 0) // three '0'
			{
				sum = 0;
				ad = 0;
			}
			else if ((a & b) == 1 || (a & ad) == 1 || (b & ad) == 1) // tow '1',
																		// one
																		// '0'
			{
				sum = 0;
				ad = 1;
			}
			else if ((a | b) == 0 || (a | ad) == 0 || (b | ad) == 0) // tow '0'
																		// one
																		// '1'
			{
				sum = 1;
				ad = 0;
			}
			sumarray[--m] = sum;
			n--;
		}
		sumarray[0] = ad;

		for (int k = 0; k < sumarray.length; k++)
		{
			s += sumarray[k];
		}
		return s;
	}

	public static void main(String[] args)
	{
		AddBinary ab = new AddBinary();
		System.out.println(ab.add("100", "1111"));
	}
}
