package AlgorithmDataStructure;

/**
 * Implement a Max-heap in O(n)
 * 
 * @author Zheng Lu
 * @date Oct 19, 2012
 * 
 */
public class Heap
{
	public static final int defaultSize = 100;

	private int[] array;
	public int size;

	public Heap()
	{
		array = new int[defaultSize];
		size = 0;
	}

	public Heap(int capacility)
	{
		assert capacility > 0;
		array = new int[capacility];
		size = 0;
	}

	public boolean isEmpty()
	{
		return this.size == 0;
	}
	
	public int max()
	{
		if (isEmpty())
			throw new RuntimeException("The heap is empty");
		return array[0];
	}
	
	public int removeMax()
	{
		if (isEmpty())
			throw new RuntimeException("The heap is empty");
		
		int max = array[0];
		array[0] = array[size-1];
		size--;
		
		siftDown(0);
		
		return max;
		
	}
	
	public void add(int value)
	{
		if (size == array.length)
			throw new RuntimeException("The heap is full");
		
		array[size]=value;
		siftUp(size);
		size++;
	}
	
	
	/**
	 * Sift up to make sure the heap property is not broken. This method is used
	 * when a new element is added to the heap and we need to make sure that it
	 * is at the right spot.
	 */
	private void siftUp(int index)
	{
		if (index > 0)
		{
			int parent = PARENT(index);
			if (array[parent] < array[index])
			{
				exchange(parent, index);
				siftUp(parent);
			}
		}
	}

	/**
	 * Sift down to make sure that the heap property is not broken This method
	 * is used when removing the min element, and we need to make sure that the
	 * replacing element is at the right spot.
	 */
	private void siftDown(int i)
	{
		int l = LEFT(i); // left child of i
		int r = RIGHT(i); // right child of i
		int largest = i;

		if (l <= this.size && array[l] > array[i]) // the left child is larger
			largest = l;

		if (r <= this.size && array[r] > array[largest])
			largest = r;

		if (largest != i) // violating the max heap property
		{
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			siftDown(largest);
		}
	}

	private void exchange(int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	private int PARENT(int i)
	{
		assert i > 0;
		return (i - 1) / 2;
	}

	private int LEFT(int i)
	{
		assert i < size;
		return i * 2 + 1;
	}

	private int RIGHT(int i)
	{
		assert i < size;
		return i * 2 + 2;
	}

	public static void main(String[] args)
	{
		Heap h = new Heap();
		h.add(12);
		h.add(23);
		h.add(232);
		
		
		System.out.println(h.removeMax());
		
		System.out.println(h.removeMax());
		System.out.println(h.removeMax());
//		System.out.println(h.removeMax());
	}

}
