// Java program to construct binary tree from 
// given array in level order fashion 

public class Tree { 
	Node root; 

	// Tree Node 
	static class Node { 
		int data; 
		Node left, right; 
		Node(int data) 
		{ 
			this.data = data; 
			this.left = null; 
			this.right = null; 
		} 
	} 

	// Function to insert nodes in level order 
	public Node insertLevelOrder(int[] arr, Node root, 
												int i) 
	{ 
		// Base case for recursion 
		if (i < arr.length) { 
			Node temp = new Node(arr[i]); 
			root = temp; 
            System.out.println(i);
			// insert left child 
			root.left = insertLevelOrder(arr, root.left, 
											2 * i + 1); 
            System.out.println(i);

			// insert right child 
			root.right = insertLevelOrder(arr, root.right, 
											2 * i + 2); 
		} 
		return root; 
	} 

	// Function to print tree nodes in InOrder fashion 
	public void inOrder(Node root) 
	{ 
		if (root != null) { 
			inOrder(root.left); 
			System.out.print(root.data + " "); 
			inOrder(root.right); 
		} 
	} 

    public boolean isValidBst(Node root){
       // return validate(root,null,null);
        return validate(root);
    }
    
    Integer prev = null;

    private boolean validate(Node root){
        if(root==null) return true;
        if(validate(root.left)==false) return false;
        if(prev!=null && root.data <=  prev ) return false;
        prev = root.data;
        return validate(root.right);
    }


    // private boolean validate(Node root, Integer low, Integer high ) {

    //     if(root==null) return true;

    //     if((low!=null && root.data <= low) ||(high!=null && root.data >= high)) return false;


    //     return validate(root.left,low,root.data) && validate(root.right,root.data,high);
    // }

    // Driver program to test above function
	public static void main(String args[]) 
	{ 
		Tree t2 = new Tree(); 
		int arr[] = { 2,1,3 }; 
		t2.root = t2.insertLevelOrder(arr, t2.root, 0); 
        t2.inOrder(t2.root); 
        System.out.println(t2.isValidBst(t2.root));
	} 
} 
