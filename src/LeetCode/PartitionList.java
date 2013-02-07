package LeetCode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * @author Zheng Lu
 * @date Oct 28, 2012
 * 
 */
public class PartitionList
{
	public ListNode partitionInPlace(ListNode head, int x)
	{
		if (head == null || head.next == null)
			return head;

		ListNode tail = head;
		int size = 0;
		while (tail.next != null)
		{
			size++;
			tail = tail.next;
		}

		int count = 0;
		while (head != null && head.val >= x && count <= size)
		{
			ListNode temp = head.next;
			head.next = null;
			tail.next = head;
			tail = tail.next;
			head = temp;
			count++;
		}

		ListNode p = head;
		while (count < size)
		{
			if (p.next.val < x)
				p = p.next;
			else
			{
				ListNode temp = p.next;
				p.next = p.next.next;
				temp.next = null;
				tail.next = temp;
				tail = tail.next;
			}
			count++;
		}
		return head;
	}

	public ListNode partition(ListNode head, int x)
	{
		if (head == null)
			return null;

		ListNode h = head;
		ListNode small = new ListNode(0);
		ListNode p = small;
		ListNode great = new ListNode(0);
		ListNode q = great;

		while (h != null)
		{
			if (h.val < x)
			{
				p.next = new ListNode(h.val);
				p = p.next;
			}
			else
			{
				q.next = new ListNode(h.val);
				q = q.next;
			}
			h = h.next;
		}

		p.next = great.next;

		return small.next;
	}

	public static void main(String[] args)
	{
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(1);
		ListNode n6 = new ListNode(1);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;

		PartitionList pl = new PartitionList();
		ListNode r = pl.partitionInPlace(n1, 3);
		while (r != null)
		{
			System.out.print(r.val + "  ");
			r = r.next;
		}
	}

}
