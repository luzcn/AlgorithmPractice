package Microsoft;

/**
 * Write a function that when given a string will return the position of the
 * starting point of the largest reoccurring character. (ie. given:"AAABBCCCCD"
 * would return 5 (starting point of C)) Test your code.
 * 
 * @author annie
 * 
 * @date Dec 18, 2012
 */
public class FindLargestReoccuring
{

	public int findLargestReoccringPosition(String s)
	{
		if (s == null)
			return -1;
		
		if (s.length() < 2)
			return 0;
		
		int start = 0;
		int end = 1;
		int count = 1;
		int max = 1;
		int position = 0;
		
		while(end < s.length())
		{
			char startChar = s.charAt(start);
			char endChar = s.charAt(end);
			
			if (startChar == endChar)
			{
				count++;
				end++;
			}
			else
			{
				if (count > max)
				{
					max = count;
					position = start;
				}
				count = 1;
				start = end;
				end++;
			}
		}
		
		if (count > max)
		{
			max = count;
			position = start;
		}
		
		return position;
		
	}
	public static void main(String[] args)
	{
	}

}
