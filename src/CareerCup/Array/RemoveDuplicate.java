package CareerCup.Array;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

public class RemoveDuplicate
{
	
	public void removeDuplicate(int[] a)
	{
		//use hash table
		Hashtable<Integer, Integer> ht = new Hashtable<Integer,Integer>();
		for (int i = 0;i<a.length;i++)
		{
			if (!ht.containsKey(a[i]))
				ht.put(a[i], 1);
			else
				ht.put(a[i], (Integer) ht.get(a[i]) + 1);
		}
		
		Iterator<Entry<Integer, Integer>> it = ht.entrySet().iterator();
		while(it.hasNext())
		{
			Entry<Integer, Integer> pairs = (Entry<Integer, Integer>) it.next();
			if (pairs.getValue() == 1)
				System.out.println(pairs.getKey());
		}
		
//		Enumeration<Integer> enu = ht.keys();
//		while(enu.hasMoreElements())
//		{
//			int x = enu.nextElement();
//			if (ht.get(x) == 1)
//				System.out.println(x);
//		}
	}
	
	public static void main(String[] args)
	{
		int[] a = {12,34,555,555,555,66,2,454,12};
		
		RemoveDuplicate rd = new RemoveDuplicate();
		rd.removeDuplicate(a);
	}
}
