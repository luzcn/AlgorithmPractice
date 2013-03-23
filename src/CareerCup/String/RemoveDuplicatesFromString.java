package CareerCup.String;

public class RemoveDuplicatesFromString
{
	public static void main(String[] args)
	{
		String s = "aaabbb";
		RemoveDuplicatesFromString rm = new RemoveDuplicatesFromString();
		System.out.println(rm.removeDuplicates(s));
	}

	/**
	 * Detect the duplicate character by using bit vector
	 * 
	 * @param s
	 * @return
	 */
	private String removeDuplicates(String s)
	{
		String ans = "";
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; i++)
			hit[i] = false;

		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (!hit[c])
			{
				ans += c; // s.substring(i, i + 1);
				hit[c] = true;
			}
		}
		return ans;
	}
}
