package AlgorithmDataStructure;

public class Queue
{
	private ListNode first;
	private ListNode last;
	private int size;

	public Queue()
	{
		first = null;
		last = null;
		size = 0;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public void add(int n)
	{
		if (isEmpty())
		{
			first = new ListNode(n);
			last = first;
			size++;
		}
		else
		{
			ListNode newNode = new ListNode(n);
			last.next = newNode;
			last = newNode;
			size++;
		}
	}

	public int poll()
	{
		int n = peek();
		first = first.next;
		size--;

		return n;
	}

	public int peek()
	{
		if (isEmpty())
			throw new RuntimeException("Queue Empty");
		else
			return first.val;
	}

	public int dequeueMax()
	{
		int max = max();
		if (isEmpty())
			throw new RuntimeException("Queue Empty");

		if (first.val == max)
		{
			first = first.next;
			size--;
		}
		else
		{
			ListNode p = first;
			while (p != null)
			{
				if (p.next != null && p.next.val == max)
				{
					p.next = p.next.next;
					break;
				}
				p = p.next;
			}
			if (p.next == null)
				last = p;

			size--;
		}

		return max;
	}

	public int max()
	{
		if (isEmpty())
			return Integer.MIN_VALUE;

		int max = first.val;

		ListNode p = first.next;
		while (p != null)
		{
			if (p.val > max)
				max = p.val;
			p = p.next;
		}
		return max;
	}

	private void printAll()
	{
		if (isEmpty())
			return;
		ListNode p = first;
		while (p != null)
		{
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		Queue q = new Queue();
		q.add(1);
		q.add(2);
		q.add(123);
		q.add(12);
		q.add(21);
		q.add(2233);

		q.printAll();
		// System.out.println(q.max());

		q.dequeueMax();
		System.out.println(q.max());

		q.add(123123);
		q.printAll();
	}

}
