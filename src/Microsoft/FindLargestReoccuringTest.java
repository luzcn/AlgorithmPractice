package Microsoft;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindLargestReoccuringTest
{

	@Test
	public void test()
	{
		String input1 = "AAABBCCCCD";
        String input2 = "AAABBCCCCDDDDD";
        String input3 = "AAABBCCCCDDDD";
        String input4 = "AAABBCCCC AADDDD";
        String input5 = " ";
        String input6 = "";
        String input7 = null;
        
        FindLargestReoccuring flr = new FindLargestReoccuring();
        
        assertEquals(flr.findLargestReoccringPosition(input1), 5);
        assertEquals(flr.findLargestReoccringPosition(input2), 9);
        assertEquals(flr.findLargestReoccringPosition(input3), 5);
        assertEquals(flr.findLargestReoccringPosition(input4), 5);
        assertEquals(flr.findLargestReoccringPosition(input5), 0);
        assertEquals(flr.findLargestReoccringPosition(input6), 0);
        assertEquals(flr.findLargestReoccringPosition(input7), -1);
	}

}
