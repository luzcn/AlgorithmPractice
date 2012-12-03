package AlgorithmDataStructure;

public class BinaryNode
{
	public int key;
	public BinaryNode left;
	public BinaryNode right;
	
	public BinaryNode()
	{
		this.key = 0;
		this.left = null;
		this.right = null;
	}
	
	public BinaryNode(int key)
	{
		this();
		this.key = key;
	}
}