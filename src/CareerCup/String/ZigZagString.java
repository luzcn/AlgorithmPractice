package CareerCup.String;

public class ZigZagString
{
	/**
	 * The string "PAYPALISHIRING" is written in a zigzag pattern 
	 * on a given number of rows like this: 
	 * (you may want to display this pattern in a fixed font for better legibility) 
	 * P   A   H   N
	 * A P L S I I G
	 * Y   I   R
	 * @param args
	 */
	
	public String ZigZag(String s, int nRow)
	{
		if (s.length() == 0)	
			return "";
		if (nRow == 0 || nRow ==1)
			return s;
		
		int size = s.length();
		int col = (size/(2*nRow-2))*(nRow-1);  
		int remain = size%(2*nRow - 2);
		
		if (remain<nRow)
			col = col + 1;
		
		if (remain>= nRow)
			col = col + (remain%nRow)+1;
		return null;
	}
	
	public static void main(String[] args)
	{
		String s= "PAYPALISHIRING";
	}
}
