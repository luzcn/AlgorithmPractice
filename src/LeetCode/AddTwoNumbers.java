package LeetCode;

import AlgorithmDataStructure.ListNode;
import AlgorithmDataStructure.SinglyLinkedList;

/**
 * Add Two Numbers You are given two linked lists representing two non-negative
 * numbers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author Zheng Lu
 * 
 */
public class AddTwoNumbers
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null && l2 != null)
			return l2;
		if (l2 == null && l1 != null)
			return l1;

		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode result = new ListNode(-1);
		ListNode current = result;
		int carry = 0;

		while (p1 != null && p2 != null)
		{
			current.next = new ListNode(0);
			current = current.next;
			int sum = p1.val + p2.val + carry;
			if (sum > 9)
			{
				carry = 1;
				current.val = sum - 10;
			}
			else
			{
				carry = 0;
				current.val = sum;
			}
			p1 = p1.next;
			p2 = p2.next;

		}

		while (p1 != null)
		{
			current.next = new ListNode(0);
			current = current.next;
			int sum = p1.val + carry;
			if (sum > 9)
			{
				carry = 1;
				current.val = sum - 10;
			}
			else
			{
				carry = 0;
				current.val = sum;
			}
			p1 = p1.next;

		}
		while (p2 != null)
		{
			current.next = new ListNode(0);
			current = current.next;
			int sum = p2.val + carry;
			if (sum > 9)
			{
				carry = 1;
				current.val = sum - 10;
			}
			else
			{
				carry = 0;
				current.val = sum;
			}
			p2 = p2.next;
		}
		if (carry > 0)
		{
			current.next = new ListNode(1);
			current = current.next;
		}
		return result.next;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

	}

}
