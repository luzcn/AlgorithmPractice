package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * put all the head elements of the lists into a heap. 
 * Every time poll the smallest element from the heap and put the next element of this 
 * 
 * @author Zheng Lu
 * @date Oct 22, 2012
 * 
 */
public class MergeKSortedList
{
	public ListNode mergeKLists(ArrayList<ListNode> lists)
	{
		int k = lists.size();
		if (k == 0)
			return null;

		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(k,
				new comp());

		for (int i = 0; i < k; i++)
		{
			if (lists.get(i) != null)
				heap.add(lists.get(i));
		}

		if (heap.isEmpty())
			return null;

		ListNode result = heap.poll();
		ListNode current = result;

		if (current.next != null)
			heap.add(current.next);

		while (!heap.isEmpty())
		{
			current.next = heap.poll();
			current = current.next;
			if (current.next != null)
				heap.add(current.next);
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
	}

}

class comp implements Comparator<ListNode>
{

	@Override
	public int compare(ListNode o1, ListNode o2)
	{
		// TODO Auto-generated method stub
		return o1.val - o2.val;
	}
}