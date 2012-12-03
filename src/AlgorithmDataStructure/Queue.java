package AlgorithmDataStructure;

public class Queue<T>
{
	private Node<T> first;	//the first element;
	private Node<T> last;	//the last element;
	private int N;			//the size of the queue;
	
	public Queue()
	{
		first = null;
		last = null;
		N = 0;
	}

	public void push(T data)
	{
		if (isEmpty())
		{
			last = new Node<T>(data);
			first = last;
		}
		else
		{
			last.next = new Node<T>(data);
			last = last.next;
		}
		N++;
	}
	
	public T pop()
	{
		if (isEmpty()) return null;
		T data = first.data;
		first = first.next;
		N--;
		return data;
	}
	
	public int size()
	{
		return N;
	}
	
	public boolean isEmpty()
	{
		return N==0;
	}
	
	
	public static void main(String[] args)
	{
		Queue<Integer> q = new Queue<Integer>();
		q.push(2);
		q.push(3);
		q.push(4);
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.isEmpty());
	}

	/***********************************/
	class Node<T>
	{
		public T data;
		public Node<T> next;
		
		public Node()
		{
			this.data = null;
			this.next = null;
		}
		
		public Node(T d)
		{
			this();
			this.data = d;
		}
	}
}

