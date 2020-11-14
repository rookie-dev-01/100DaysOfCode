package Day7;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */


public class MaximumDepthofBinaryTree{
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) { this.val = val; }
		 TreeNode(int val, TreeNode left, TreeNode right) {
		     this.val = val;
		     this.left = left;
		     this.right = right;
		 }
		 };
	
	public static void main(String[] args) {
		MaximumDepthofBinaryTree obj = new MaximumDepthofBinaryTree();

		TreeNode root = obj.new TreeNode(5);
		System.out.println(obj.maxDepth(root));
	}
    
	 public int maxDepth(TreeNode root) {
	        if(root==null) return 0;
	        int maxDepth = 0;
	        if(root.left!=null) { maxDepth = Math.max(maxDepth,maxDepth(root.left)); }
	        if(root.right!=null) { maxDepth = Math.max(maxDepth,maxDepth(root.right)); }
	        return maxDepth+1;
	    }
}
