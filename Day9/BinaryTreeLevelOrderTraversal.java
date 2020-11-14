package day9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @author amjain
 *
 */
public class BinaryTreeLevelOrderTraversal {
	
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
	}
	   public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> result = new ArrayList<>();
	        if(root==null) return result;
	        Queue<TreeNode> que = new LinkedList<>();
	        que.add(root);
	        while(!que.isEmpty()){
	            
	            List<Integer> intresult = new ArrayList<>();    
	            Queue<TreeNode> newque = new LinkedList<>();
	            Iterator iterator = que.iterator();            
	            while(iterator.hasNext()){
	                TreeNode node = que.poll();
	                if(node.left!=null) { newque.add(node.left); }
	                if(node.right!=null){ newque.add(node.right); }
	                intresult.add(node.val);
	            }
	            result.add(intresult);
	            que = newque;
	        }
	     return result;
	    }
	
	public static void printQueye(Queue<Integer> queue) {
		for(Integer ele:queue) {
			System.out.print(ele);
		}
		System.out.println("");
	}
	
	public static void removeWhileIterating(Queue<Integer> queue) {
		Iterator iterator = queue.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
//			System.out.println(queue.poll());
		}
		
//		iterator = queue.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
//			System.out.println(queue.poll());
		}
	}
	
	public static void main(String[] args) {
		Queue<Integer> quess = new LinkedList<>();
		quess.add(1);
		quess.add(2);
		quess.add(3);
		quess.add(4);
		printQueye(quess);
		
		System.out.println("peek : "+quess.peek());
		System.out.println("peek : "+quess.peek());
		printQueye(quess);
		
//		System.out.println("poll : "+quess.poll());
//		printQueye(quess);
//		
//		System.out.println("remove : "+quess.remove());
//		printQueye(quess);
		
		removeWhileIterating(quess);
		printQueye(quess);
		
		if(quess.isEmpty()) {
			System.out.println("empty");
		}
	}
	
}
