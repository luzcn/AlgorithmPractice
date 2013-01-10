package AlgorithmDataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * The function shows how to iterate a hashmap by using Iterator and Entry
 * 
 * @author annie
 * 
 * @date Dec 13, 2012
 */
public class HashMapIterate
{
	public void mapIteration(HashMap<Integer, Integer> map)
	{
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();

		while (it.hasNext())
		{
			Entry<Integer, Integer> pairs = it.next();

			System.out.println(pairs.getKey() + "  " + pairs.getValue());
		}
	}

	public void sortMap(HashMap<Integer, Integer> map)
	{
		ArrayList<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>();

		list.addAll(map.entrySet());

		Collections.sort(list, new myComp());

		for (Entry<Integer, Integer> p : list)
		{
			System.out.println(p.getKey() + " " + p.getValue());
		}
	}

	class myComp implements Comparator<Entry<Integer, Integer>>
	{
		@Override
		public int compare(Entry<Integer, Integer> o1,
				Entry<Integer, Integer> o2)
		{
			return o1.getValue() - o2.getValue();
		}
	}

	public static void main(String[] args)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		map.put(1, 123);
		map.put(2, 34);
		map.put(23, 323);

		HashMapIterate hmi = new HashMapIterate();
		// hmi.mapIteration(map);

		hmi.sortMap(map);
	}

}
