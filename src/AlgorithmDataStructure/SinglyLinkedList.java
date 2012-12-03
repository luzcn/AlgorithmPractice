package AlgorithmDataStructure;

public class SinglyLinkedList<T>
{
	public LinkedNode<T> head; 
	
	public SinglyLinkedList()
	{
		this.head = new LinkedNode<T>();
	}
	
	public SinglyLinkedList(T data)
	{
		this.head = new LinkedNode<T>(data);
	}
	/**
	 * isEmpty
	 * @return
	 */
	public boolean isEmpty()
	{
		return (this.head.data == null)?true:false;
	}
	
	public int size()
	{
		if (this.isEmpty()) return 0;
		int size = 0;
		LinkedNode<T> currentNode = this.head;
		while(currentNode != null)
		{
			currentNode = currentNode.next;
			size++;
		}
		return size;
	}
	/**
	 * insert 
	 * @param data
	 */
	public void insert(T data)
	{
		if (this.isEmpty())
		{
			this.head.data = data;
		}
		else
		{
			LinkedNode<T> newNode = new LinkedNode<T>(data);
			LinkedNode<T> currentNode = this.head;
			
			while(currentNode.next != null)
			{
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
	}
	
	public void printAll()
	{
		if (this.isEmpty()) 
			System.out.println("Empty List");
		else
		{
			LinkedNode<T> currentNode = this.head;
			while(currentNode != null)
			{
				System.out.print(currentNode.data + " ");
				currentNode = currentNode.next;
			}
			System.out.println();
		}
	}
	
	/**
	 * The delete function
	 * @param data
	 */
	public void delete(T data)
	{
		if (this.isEmpty()) 
			System.out.println("Empty List");
		else if(this.head.data == data)
			this.head.data = null;			//remove the head.data, but keep the head.
		else
		{
			LinkedNode<T> currentNode = this.head;
			while(currentNode.next != null)
			{
				if (currentNode.next.data == data)
				{
					//LinkedNode<T> temp = currentNode.next;
					currentNode.next = currentNode.next.next;
					break;				//assume distinct data in the list
				}
				else
					currentNode = currentNode.next;
			}
		}
	}
	
	/**
	 * reverse the whole linked list using a while loop
	 * @return
	 * reverse the linked list
	 */
	public SinglyLinkedList<T> reverse()
	{
		if (this.isEmpty()) return null;
		
		LinkedNode<T> currentNode = this.head;
		LinkedNode<T> prev = null;
		while(currentNode != null)
		{
			LinkedNode<T> temp = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = temp;
		}
		SinglyLinkedList<T> l = new SinglyLinkedList<T>();
		l.head = prev;
		return l;
	}
	
	
	public SinglyLinkedList<T> reverseInRecursive()
	{
		if (this.isEmpty()) return null;
		
		SinglyLinkedList<T> l = new SinglyLinkedList<T>();
		l.head = reverseInRecursive(this.head, null);
		return l;
	}
	/**
	 * reverse the whole linked list using recursive
	 * @param currentNode
	 * @param prev
	 * @return
	 */
	private LinkedNode<T> reverseInRecursive(LinkedNode<T> currentNode, LinkedNode<T> prev)
	{
		if (currentNode.next == null) 
		{
			currentNode.next = prev;
			return currentNode;
		}
		else
		{
			LinkedNode<T> temp = reverseInRecursive(currentNode.next, currentNode);
			currentNode.next = prev;
			return temp;
		}
	}
	
	public SinglyLinkedList<T> reverseLinkedListEveryKNode(int k)
	{
		if (this.isEmpty()) return null;
		
		SinglyLinkedList<T> l = new SinglyLinkedList<T>();
		l.head = reverseLinkedListEveryKNode(this.head, k);
		return l;
	}
	private LinkedNode<T> reverseLinkedListEveryKNode(LinkedNode<T> ptr, int k)
	{
		if (ptr == null)
			return null;
		else
		{
			int num = 0;
			LinkedNode<T> prev = null;
			LinkedNode<T> currentNode = ptr;		//we remember this record first.
			
			while(ptr !=null && num<k)
			{
				LinkedNode<T> temp = ptr.next;
				ptr.next = prev;
				prev = ptr;
				ptr = temp;
				num++;
			}
			currentNode.next = reverseLinkedListEveryKNode(ptr, k);
			return prev;
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		
		list.insert(4);
		list.insert(5);
		list.insert(6);
		
		list.insert(7);
		list.insert(8);
		list.insert(9);
		
		SinglyLinkedList<Integer> reversedList = list.reverseLinkedListEveryKNode(2);
		reversedList.printAll();
	}
}
