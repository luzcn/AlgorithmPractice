package LeetCode;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * @author Zheng Lu
 * @date Oct 31, 2012
 * 
 */
public class RemoveNthNodeFromEndofList
{
	public static ListNode removeNthFromEnd(ListNode head, int n)
	{
		if (head == null)
			return null;

		ListNode p1 = head;
		ListNode p2 = head;

		for (int i = 0; i < n; i++)
			p2 = p2.next;

		if (p2 == null)
			head = head.next;
		else
		{
			while (p2.next != null)
			{
				p1 = p1.next;
				p2 = p2.next;
			}
			p1.next = p1.next.next;
		}
		return head;
	}

	public static void main(String[] args)
	{
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
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

		removeNthFromEnd(n1, 2);

	}

}
