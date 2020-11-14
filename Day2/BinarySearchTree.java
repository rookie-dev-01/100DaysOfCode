package Day2;

class Node{
	
	public Node(int item) {
		this.item = item;
		left = right = null;
	}
	
	int item;
	Node left;
	Node right;
}


public class BinarySearchTree {

	int counter = 0;
	
	enum Order{
		PREORDER,
		INORDER,
		POSTORDER
	}
	
	Node root;
	
	private int height(Node theNode) {
		if(theNode==null) {
			return 0;
		}else {
			int lheight = height(theNode.left);
			int rheight = height(theNode.right);

			if(lheight>rheight) return lheight+1;
			else return rheight+1;
		}
	}
	
	public void createNode(Node currNode, int currItem) {
		counter+=1;
		if(currNode==null) {
			root = new Node(currItem);
			return;
		}
		
		//left subtree
		if(currItem <= currNode.item) {
			if(currNode.left==null) {
				currNode.left = new Node(currItem);
			}else {
				createNode(currNode.left,currItem);
			}
		}
		
		//right subtree
		if(currItem > currNode.item) {
			if(currNode.right==null) {
				currNode.right = new Node(currItem);
			}else {
				createNode(currNode.right,currItem);
			}
		}
	}
	
	private void createBinarySearchTree(int[] theItemArr) {
		for(int item:theItemArr) {
			createNode(root,item);
		}
		
		printTree(Order.INORDER,root);
		System.out.println();
		printTree(Order.PREORDER,root);
		System.out.println();
		printTree(Order.POSTORDER,root);
		System.out.println();
		
		System.out.println("Height: "+height(root));
		
		System.out.println("Order O("+counter+")");
	}
	
	private void printTree(Order orderType,Node currNode) {
		switch(orderType) {
		//left, root, right
		case INORDER:
			if(currNode!=null) {
				printTree(orderType,currNode.left);
				System.out.print(currNode.item+" ");
				printTree(orderType,currNode.right);	
			}
			break;
		case PREORDER:
			if(currNode!=null) {
				System.out.print(currNode.item+" ");
				printTree(orderType,currNode.left);
				printTree(orderType,currNode.right);	
			}
			break;
		case POSTORDER:
			if(currNode!=null) {
				printTree(orderType,currNode.left);
				printTree(orderType,currNode.right);	
				System.out.print(currNode.item+" ");
			}
			break;
		}
	}
	
	public static void main(String args[]) {
		
		int[] theItemArr = {10,15,9,8,22,3,4,5,1};
		
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.createBinarySearchTree(theItemArr);
		
	}
	
}
