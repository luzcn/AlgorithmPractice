package CareerCup.String;

public class StringReplace
{
	public String replace(String s, char c, String newChar)
	{
		String newString = "";
		for (int i = 0;i<s.length();i++)
		{
			if (s.charAt(i) != c)
				newString = newString + s.charAt(i);
			else
				newString = newString + newChar;
		}
		
		return newString;
	}
	public static void main(String[] args)
	{
		String s = "dsf df fdf fdsfffffffffff fd ";
		
		StringReplace sr = new StringReplace();
		System.out.println(sr.replace(s, ' ', "%20"));
	}
}
