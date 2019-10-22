
// Java program to print top 
// view of binary tree 
import java.util.*; 
class solution 
{ 

// structure of binary tree 
static class Node { 
	Node left; 
	Node right; 
	int data; 
}; 

// structure of pair 
static class Pair { 
	Node first; 
	int second; 
	Pair(Node n,int a) 
	{ 
		first=n; 
		second=a; 
	} 
}; 

// function to create a new node 
static Node newNode(int key) 
{ 
	Node node = new Node(); 
	node.left = node.right = null; 
	node.data = key; 
	return node; 
} 

// function should print the topView of 
// the binary tree 
static void topView( Node root) 
{ 
	// Base case 
	if (root == null) { 
		return; 
	} 

	// Take a temporary node 
	Node temp = null; 

	// Queue to do BFS 
	Queue<Pair > q = new LinkedList<Pair>(); 

	// map to store node at each vartical distance 
	Map<Integer, Integer> mp = new TreeMap<Integer, Integer>(); 

	q.add(new Pair( root, 0 )); 

	// BFS 
	while (q.size()>0) { 

		temp = q.peek().first; 
		int d = q.peek().second; 
		q.remove(); 

		// If any node is not at that vertical distance 
		// just insert that node in map and print it 
		if (mp.get(d) == null) {mp.put(d, temp.data); 
		} 

		// Continue for left node 
		if (temp.left!=null) { 
			q.add(new Pair( temp.left, d - 1 )); 
		} 

		// Continue for right node 
		if (temp.right!=null) { 
			q.add(new Pair( temp.right, d + 1 )); 
		} 
	} 
	for(Integer data:mp.values()){ 
	System.out.print( data + " "); 
	} 
} 

// Driver Program to test above functions 
public static void main(String args[]) 
{ 
	/* Create following Binary Tree 
		1 
		/ \ 
		2 3 
		\ 
		4 
		\ 
		5 
			\ 
			6*/
	Node root = newNode(1); 
	root.left = newNode(2); 
	root.right = newNode(3); 
	root.left.right = newNode(4); 
	root.left.right.right = newNode(5); 
	root.left.right.right.right = newNode(6); 
	System.out.println( "Following are nodes in top view of Binary Tree\n"); 
	topView(root); 
} 
} 
//contributed by Arnab Kundu 
