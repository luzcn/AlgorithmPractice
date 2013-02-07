package CareerCup.LinkedList;

import java.util.ArrayList;
import AlgorithmDataStructure.ListNode;

/**
 * Given a singly linked list and set of nodes; remove these nodes from the
 * list.
 * 
 * If the linked list has no circle, the solution is simple.
 * 
 * @author annie
 * 
 * @date Feb 4, 2013
 */
public class RemoveNodesFromList
{
	public ListNode removeNodes(ListNode head, ArrayList<Integer> list)
	{
		if (head == null || list == null || list.size() == 0)
			return head;
		while (head != null && list.contains(head.val))
			head = head.next;

		if (head == null)
			return null;

		ListNode p = head;
		while (p.next != null)
		{
			if (list.contains(p.next.val))
				p.next = p.next.next;
			else
				p = p.next;
		}

		return head;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
