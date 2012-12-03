package AlgorithmDataStructure;

public class TreeNode<T>
{
	public T key;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode<T> parent;
	
	public TreeNode()
	{
		this.key = null;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	public TreeNode(T key)
	{
		this();
		this.key = key;
	}
	
	public boolean isEmpty()
	{
		return (this.key == null)?true:false;
	}
	
	public void addLeftChild(TreeNode<T> child)
	{
		this.left = child;
		child.parent = this;
	}
	
	public void addRightChild(TreeNode<T> child)
	{
		this.right = child;
		child.parent = this;
	}
}
