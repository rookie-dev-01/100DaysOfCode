package day8;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/submissions/
 * @author amjain
 *
 */
public class BinaryTreePaths {

	//Definition for a binary tree node.
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

	//root->left->right
 public void preOrderTraversal(TreeNode root,String rootToleaf,List<String> result){
	 if(root==null) return;
	 if(root.left==null && root.right==null) {
		 rootToleaf +=root.val;
		 result.add(rootToleaf);
	 }else {
		 rootToleaf +=root.val+"->";
	 }
	 preOrderTraversal(root.left,rootToleaf,result);
	 preOrderTraversal(root.right,rootToleaf,result);

 }

 public List<String> binaryTreePaths(TreeNode root) {
	 List<String> result = new ArrayList<>();
	 preOrderTraversal(root,"",result);
	 return result;
 }
		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}
}
