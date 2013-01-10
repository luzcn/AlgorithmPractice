package LeetCode;


/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition:
 * 
 * @author Zheng Lu
 * @date Oct 23, 2012
 * 
 */
public class ReverseLinkedListBetween
{
	public static ListNode reverseBetween(ListNode head, int m, int n)
	{
		ListNode prevNode = null;
		ListNode endNode = null;
		ListNode p = null;
		ListNode currentNode = null;

		for (int i = 0; i < n; i++)
		{
			if (i < m)
			{
				prevNode = p;
			}
			if (p == null)
				p = head;
			else
				p = p.next;
		}
		if (prevNode != null)
			currentNode = prevNode.next;
		else
			currentNode = head;

		if (p != null)
			endNode = p.next;

		ListNode prev = endNode;

		for (int i = m - 1; i < n; i++)
		{
			ListNode temp = currentNode;
			currentNode = currentNode.next;
			temp.next = prev;
			prev = temp;
		}
		if (prevNode != null)
			prevNode.next = prev;
		else
			head = prev;

		return head;
	}

	/**
	 * Take only ONE path
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverse(ListNode head, int m, int n)
	{

		if (head == null || head.next == null || m >= n)
			return head;

		int count1 = 1;
		int count2 = 1;
		ListNode p = head;
		ListNode q = head.next;
		ListNode prev_p = null;
		ListNode prev_q = null;

		while (p != null && q != null && count2 < n)
		{
			count2++;
			if (count1 < m)
			{
				prev_p = p;
				p = p.next;
				q = q.next;
				count1++;
			}
			else
			{
				prev_q = q;
				ListNode temp = q.next;
				q.next = p;
				p = q;
				q = temp;
			}
		}
		if (prev_p != null)
		{
			prev_p.next.next = q;
			prev_p.next = prev_q;
			return head;
		}
		else
		{
			head.next = q;
			return prev_q;
		}
	}

	public static void main(String[] args)
	{
		ListNode n1 = new ListNode(-1);
		ListNode n2 = new ListNode(-3);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		// n3.next = n4;
		// n4.next = n5;

		ListNode n = reverseBetween(n1, 1, 2);
		while (n != null)
		{
			System.out.println(n.val);
			n = n.next;
		}
	}

}
