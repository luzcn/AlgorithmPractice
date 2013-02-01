package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 * @author Zheng Lu
 * @date Nov 6, 2012
 * 
 */
public class SameTree
{
	public boolean isSameTree(TreeNode p, TreeNode q)
	{
		if (p == null && q == null)
			return true;

		if ((p == null && q != null) || (p != null && q == null))
			return false;

		return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(
				p.right, q.right));

	}

	public boolean isSameTreeIterative(TreeNode p, TreeNode q) 
    {
        if (p == null && q == null)                
            return true;
        if (p != null && q == null || p == null && q != null)
            return false;
        
        Queue<TreeNode> que1 = new LinkedList<TreeNode>();
        Queue<TreeNode> que2 = new LinkedList<TreeNode>();
        
        que1.add(p);
        que2.add(q);
        
        while(!que1.isEmpty() && !que2.isEmpty())
        {
            TreeNode c1 = que1.poll();
            TreeNode c2 = que2.poll();
            
            if (c1 == null)
            {
                if (c2 == null)
                    continue;
                else
                    return false;
            }
            else if (c2 == null || c2.val != c1.val)
                return false;
            
            que1.add(c1.left);
            que1.add(c1.right);
            que2.add(c2.left);
            que2.add(c2.right);
        }
        return true;
    }
	public static void main(String[] args)
	{

	}

}
