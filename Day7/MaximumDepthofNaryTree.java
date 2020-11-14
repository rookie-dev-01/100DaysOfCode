package Day7;

import java.util.List;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */


public class MaximumDepthofNaryTree{
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	public static void main(String[] args) {
		MaximumDepthofNaryTree obj = new MaximumDepthofNaryTree();

		Node root = obj.new Node(5);
		System.out.println(obj.maxDepth(root));
	}
    
    	public int maxDepth(Node root) {
            if(root==null) return 0;
            else if(root.children == null || root.children.isEmpty()) return 1;
            int globalMax = 0;
            for(Node node:root.children){
                 globalMax =  Math.max(globalMax, maxDepth(node));
            }
            return globalMax+1;
        }
}
