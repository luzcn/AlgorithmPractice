package LeetCode;

import java.util.regex.*;
/**
 * Validate if a given string is numeric.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true Note: It is intended for the problem statement to be
 * ambiguous. You should gather all requirements up front before implementing
 * one.
 * 
 * @author annie
 * 
 */
public class ValidNumber
{
	public boolean isNumber(String s)
	{
		if (s.length() == 0)
			return false;
		
		String pattern = "[+-]?(\\d+|\\d*[.]\\d+|\\d+[.]\\d*)(e[+-]?\\d+)?";
	
		Pattern r = Pattern.compile(pattern);
		
		Matcher m = r.matcher(s);
		return m.matches();
		
//		return false;
	}
	public static void main(String[] args)
	{
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber("1a"));
	}
}
