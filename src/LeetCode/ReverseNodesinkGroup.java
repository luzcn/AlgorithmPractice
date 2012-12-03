package LeetCode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @author Zheng Lu
 * @date Nov 5, 2012
 * 
 */
public class ReverseNodesinkGroup
{
	public ListNode reverseKGroup(ListNode head, int k)
	{
		if (head == null)
			return null;

		ListNode p = head;
		int size = 0;
		while (p != null)
		{
			size++;
			p = p.next;
		}
		if (size < k)
			return head;

		return reverseKGroupRec(head, k, size);
	}

	private ListNode reverseKGroupRec(ListNode ptr, int k, int size)
	{
		if (ptr == null)
			return null;
		else if (size < k)
			return ptr;
		else
		{
			ListNode prev = null;
			ListNode current = ptr;
			int count = 0;

			while (ptr != null && count < k)
			{
				ListNode temp = ptr.next;
				ptr.next = prev;
				prev = ptr;
				ptr = temp;
				count++;
			}
			current.next = reverseKGroupRec(ptr, k, size - k);

			return prev;
		}
	}

	public static void main(String[] args)
	{
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		ReverseNodesinkGroup rnk = new ReverseNodesinkGroup();
		ListNode n = rnk.reverseKGroup(n1, 3);
		while (n != null)
		{
			System.out.println(n.val);
			n = n.next;
		}

	}

}
