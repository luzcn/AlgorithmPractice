package AlgorithmDataStructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


/**
 * The function shows how to iterate a hashmap by using Iterator and Entry
 * @author annie
 *
 * @date Dec 13, 2012
 */
public class HashMapIterate
{
	public void mapIteration(HashMap<Integer, Integer> map)
	{
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		
		while(it.hasNext())
		{
			Entry<Integer, Integer> pairs = it.next();
			
			System.out.println(pairs.getKey() + "  " + pairs.getValue());
		}
	}
	public static void main(String[] args)
	{

	}

}
