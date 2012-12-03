package LeetCode;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author Zheng Lu
 * @date Oct 30, 2012
 * 
 */
public class RemoveDuplicatesFromSortedList
{
	public ListNode deleteDuplicates(ListNode head)
	{
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode start = head;
		ListNode end = head.next;

		while (end != null)
		{
			if (start.val == end.val)
				end = end.next;
			else
			{
				start.next.val = end.val;
				start = start.next;
				end = end.next;
			}
		}
		start.next = null;
		return head;
	}

	public static void main(String[] args)
	{

	}

}
