package day8;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author amjain
 *
 */
public class ConvertSortedArraytoBinarySearchTree {

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

	public TreeNode createTree(int[] nums,int start,int end){
        
        if(start==end) return new TreeNode(nums[start]);
        if(start < end){
            int mid = (end+start)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = createTree(nums,start,mid-1);
            root.right = createTree(nums,mid+1,end);
            return root;
        }
        return null;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return createTree(nums,0,nums.length-1);
    }
	
	public static void main(String[] args) {
		ConvertSortedArraytoBinarySearchTree obj = new ConvertSortedArraytoBinarySearchTree();

		System.out.println(obj.sortedArrayToBST(new int[] {1,2,3,4,5,6,7,8}));
	}
}
