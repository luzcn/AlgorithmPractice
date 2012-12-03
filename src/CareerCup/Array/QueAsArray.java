package CareerCup.Array;

/**
 * Implement a queue using an Array. 
 * Make efficient use of the space in the array. 
 * @author Zheng Lu
 *
 */

public class QueAsArray
{
	private int head = 0;
	private int last = 0;
	private int size = 0;
	private int[] queueArray = new int[1<<10];
	
	public void push(int a)
	{
		queueArray[last] = a;
		last++;
		size++;
	}
	
	/**
	 * it is not efficient use of space
	 * since the head space is never used after pop
	 * @return
	 */
	public int pop()
	{
		size--;
		return queueArray[head++];
	}
	
	public boolean isEmpty()
	{
		return head==last;
	}
	
	public int size()
	{
		return this.size;
	}
	
	public static void main(String[] args)
	{
		QueAsArray que = new QueAsArray();
		que.push(1);
		que.push(2);
		System.out.println(que.pop());
		System.out.println(que.pop());
		System.out.println(que.isEmpty());
	}
}
