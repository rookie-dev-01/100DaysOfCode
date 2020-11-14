package Day7;


/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */


public class IncreasingOrderSearchTree{
	class TreeNode {
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
	}
	
	public static void main(String[] args) {
		IncreasingOrderSearchTree obj = new IncreasingOrderSearchTree();

		TreeNode root = obj.new TreeNode(5);
		System.out.println(obj.increasingBST(root));
	}
    
    TreeNode resultNode = null; 
    	TreeNode currNode = null;
    public TreeNode increasingBST(TreeNode root) {
        if(root==null) return null;
        if(root.left!=null) increasingBST(root.left);
        if(currNode==null){
            currNode = resultNode = root; resultNode.left=null;
        }else{
            currNode.right=root; currNode.left=null; currNode=currNode.right;
        }
        
        System.out.println(root.val);
        if(root.right!=null) increasingBST(root.right);
        return resultNode; 
    }
}
