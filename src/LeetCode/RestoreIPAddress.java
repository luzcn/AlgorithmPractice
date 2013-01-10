package LeetCode;

import java.util.ArrayList;

/**
 * @author annie
 * 
 * @date Jan 7, 2013
 */
public class RestoreIPAddress
{
	public ArrayList<String> restoreIpAddresses(String s)
	{
		ArrayList<String> list = restoreIpAddressesHelper(s, "...");
		ArrayList<String> solution = new ArrayList<String>();

		for (String str : list)
		{
			if (isValid(str))
				solution.add(str);

		}
		return solution; // restoreIpAddressesHelper(s, "....");
	}

	private boolean isValid(String s)
	{
		String[] strs = s.split("[.]");

		for (int i = 0; i < strs.length; i++)
		{
			if (strs[i].length() > 3)
				return false;

			int num = Integer.parseInt(strs[i]);
			if (num > 255)
				return false;
		}
		return true;
	}

	private ArrayList<String> restoreIpAddressesHelper(String s, String t)
	{
		ArrayList<String> solution = new ArrayList<String>();
		if (s.length() == 0)
			solution.add(t);
		else if (t.length() == 0)
			solution.add(s);
		else
		{
			for (int i = 1; i < s.length(); i++)
			{
				char first = t.charAt(0);
				String left = s.substring(0, i);
				String right = s.substring(i);

				for (String str : restoreIpAddressesHelper(right,
						t.substring(1)))
				{
					solution.add(left + first + str);
				}
			}
		}
		return solution;
	}

	public static void main(String[] args)
	{
		String s = "25525511135";
		RestoreIPAddress ri = new RestoreIPAddress();
		ArrayList<String> sol = ri.restoreIpAddresses(s);

		for (String list : sol)
			System.out.println(list);
	}

}
