package CareerCup.Array;
import java.util.Enumeration;
import java.util.Hashtable;
public class RemoveDuplicate
{
	
	public void removeDuplicate(int[] a)
	{
		//use hash table
		Hashtable<Integer, Integer> ht = new Hashtable<Integer,Integer>();
		for (int i = 0;i<a.length;i++)
		{
			if (ht.get(a[i])== null)
				ht.put(a[i], 1);
			else
				ht.put(a[i], (Integer) ht.get(a[i]) + 1);
		}
		
		Enumeration<Integer> enu = ht.keys();
		while(enu.hasMoreElements())
		{
			int x = enu.nextElement();
			if (ht.get(x) == 1)
				System.out.println(x);
		}
	}
	
	public static void main(String[] args)
	{
		int[] a = {12,34,555,555,555,66,2,454,12};
		
		RemoveDuplicate rd = new RemoveDuplicate();
		rd.removeDuplicate(a);
	}
}
