package AlgorithmDataStructure;

/**
 * Implement a queue using a circular data structure. Provide put and get
 * functions
 * 
 * @author annie
 * 
 * @date Jan 9, 2013
 */
public class CircularBuffer
{
	private ListNode head = null;
	private ListNode tail = null;
	private int size = 0;
	
	public boolean isEmpty()
	{
		return size == 0;
	}

	public void add(int n)
	{
		if (isEmpty())
		{
			this.head = new ListNode(n);
			head.next = head;
			tail = head;
		}
		else
		{

			ListNode node = new ListNode(n);
			node.next = head;
			tail.next = node;
			tail = node;
		}
		size++;
	}

	public int poll()
	{
		int n = peek();
		head = head.next;
		tail.next = head;
		size--;
		return n;
	}

	public int peek()
	{
		if (isEmpty())
			throw new RuntimeException("Empty buffer");
		return head.val;
	}

	public void printAll()
	{
		if (isEmpty())
			return;
		
		ListNode p = head;
		while(p != tail)
		{
			System.out.println(p.val);
			p = p.next;
		}
		System.out.println(p.val);
	}
	public static void main(String[] args)
	{
		CircularBuffer cb = new CircularBuffer();
		cb.add(2);
		cb.add(3);
		cb.add(4);
		cb.poll();
		
		cb.printAll();
	}

}
