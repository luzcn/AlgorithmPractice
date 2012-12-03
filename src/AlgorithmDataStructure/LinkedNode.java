package AlgorithmDataStructure;

public class LinkedNode<T>
{
	public LinkedNode<T> next;
	public T data;
	
	public LinkedNode()
	{
		this.next = null;
		this.data = null;
	}
	
	public LinkedNode(T data)
	{
		this.next = null;
		this.data = data;
	}
}
