package LeetCode;
import AlgorithmDataStructure.LinkedNode;
import AlgorithmDataStructure.SinglyLinkedList;

/**
 * Add Two Numbers
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * @author Zheng Lu
 *
 */
public class AddTwoNumbers
{

	public SinglyLinkedList<Integer> addTwoNumbers(SinglyLinkedList<Integer> list1, SinglyLinkedList<Integer> list2)
	{
		SinglyLinkedList<Integer> sum = new SinglyLinkedList<Integer>();
		int ad = 0;
		int size = (list1.size()>=list2.size())?list1.size():list2.size();
		
		while(list1.size()<size)
			list1.insert(0);
		while(list2.size()<size)
			list2.insert(0);
		
		LinkedNode<Integer> p1 = list1.head;
		LinkedNode<Integer> p2 = list2.head;
		
		while(p1!=null && p2!=null)
		{
			int s = p1.data + p2.data + ad;
			if (s>=10)
			{
				ad = 1;
				sum.insert(s-10);
			}
			else
			{
				ad = 0;
				sum.insert(s);
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return sum;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
		list1.insert(2);
		list1.insert(4);
		list1.insert(3);
		
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
		list2.insert(5);
		list2.insert(6);
		list2.insert(4);
		list2.insert(7);
		
		AddTwoNumbers atn = new AddTwoNumbers();
		list1.printAll();
		list2.printAll();
		
		atn.addTwoNumbers(list1, list2).printAll();
	}

}
