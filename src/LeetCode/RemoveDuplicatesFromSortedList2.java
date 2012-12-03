package LeetCode;

/**
 * @author Zheng Lu
 * @date Oct 30, 2012
 * 
 */
public class RemoveDuplicatesFromSortedList2
{
	public static ListNode deleteDuplicates(ListNode head)
	{
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode start = head;
		ListNode end = head.next;
		ListNode prev = new ListNode(0);
		ListNode p = prev;

		while (end != null)
		{
			if (start.val < end.val)
			{
				p.next = start;
				p = p.next;
			}
			while (end != null && start.val == end.val)
			{
				end = end.next;
			}
			if (end == null)
			{
				p.next = null;
				break;
			}
			start = end;
			end = end.next;

			if (end == null)
				p.next = start;
		}

		return prev.next;
	}

	public static void main(String[] args)
	{
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(3);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;

		ListNode r = deleteDuplicates(n1);
		while (r != null)
		{
			System.out.print(r.val + "  ");
			r = r.next;
		}

	}

}
