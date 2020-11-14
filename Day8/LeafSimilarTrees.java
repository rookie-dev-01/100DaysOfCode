package day8;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

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

	public void findLeaves(TreeNode root,List<Integer> leavesList){
        if(root==null) return;
        if(root.left!=null) findLeaves(root.left,leavesList);
        if(root.right!=null) findLeaves(root.right,leavesList);
        if(root.left==null && root.right==null) leavesList.add(root.val);
        return;
        
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null || root2 == null) return false;
        List<Integer> root1Leaves = new ArrayList<>();
        List<Integer> root2Leaves = new ArrayList<>();
        findLeaves(root1,root1Leaves);
        findLeaves(root2,root2Leaves);
        System.out.println("root1 "+root1Leaves+" root2 "+root2Leaves);
        if(root1Leaves.equals(root2Leaves)) return true;
        return false;
    }
	
	public static void main(String[] args) {
		LeafSimilarTrees obj = new LeafSimilarTrees();

		TreeNode root1 = obj.new TreeNode(5);
		TreeNode root2 = obj.new TreeNode(5);
		System.out.println(obj.leafSimilar(root1,root2));
	}
}
