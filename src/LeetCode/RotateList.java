package LeetCode;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * @author Zheng Lu
 * @date Nov 5, 2012
 * 
 */
public class RotateList
{
	public ListNode rotateRight(ListNode head, int n)
	{
		if (head == null)
			return head;

		int size = 1;
		ListNode p = head;
		while (p.next != null)
		{
			size++;
			p = p.next;
		}

		if (size == 1)
			return head;

		while (n >= size)
			n = n - size;

		if (n == 0)
			return head;

		ListNode p1 = head;
		ListNode p2 = head;
		ListNode prev = null;

		for (int i = 0; i < n - 1; i++)
			p2 = p2.next;

		while (p2.next != null)
		{
			prev = p1;
			p1 = p1.next;
			p2 = p2.next;
		}
		prev.next = null;
		p2.next = head;

		return p1;

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
		// n2.next = n3;
		// n3.next = n4;
		// n4.next = n5;
		// n5.next = n6;
		// n6.next = null;

		RotateList rl = new RotateList();
		ListNode r = rl.rotateRight(n1, 5);
		while (r != null)
		{
			System.out.print(r.val + "  ");
			r = r.next;
		}
	}

}
