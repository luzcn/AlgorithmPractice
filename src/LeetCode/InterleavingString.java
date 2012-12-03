package LeetCode;

import java.util.ArrayList;

/**
 * @author Zheng Lu
 * @date Oct 1, 2012
 * 
 */
public class InterleavingString
{

	/*public static ArrayList<String> interleaving(String s, String t)
	{
		ArrayList<String> solution = new ArrayList<String>();
		if (t.isEmpty())
			solution.add(s);
		else if (s.isEmpty())
			solution.add(t);
		else
		{
			for (int i = 0;i<=s.length();i++)
			{
				char c = t.charAt(0);
				String left = s.substring(0,i);
				String right = s.substring(i);
				
				for (String str:interleaving(right, t.substring(1)))
					solution.add(left+c+str);
			}
		}
		
		return solution;
	}*/
	public static ArrayList<String> interleaving(String s, String t)
	{
		ArrayList<String> solution = new ArrayList<String>();
		if (s.isEmpty())
			solution.add(t);
		else if (t.isEmpty())
			solution.add(s);
		else
		{
			for (int i = 0;i<=s.length();i++)
			{
				char first = t.charAt(0);
				String left = s.substring(0,i);
				String right = s.substring(i);
				
				for (String str:interleaving(right, t.substring(1)))
					solution.add(left+first+str);
			}
		}
		return solution;
	}
	
	public static void main(String[] args)
	{
		String str1 = "12";
		String str2 = "ab";
		ArrayList<String> sol = interleaving(str1, str2);
			
		for (String list:sol)
			System.out.println(list);

	}

}
