import java.util.*;
 
 public class Main {
 
 	 // TreeNode class for a node of a Binary Search Tree
 	 public static class TreeNode {
 	 	 int val;
 	 	 TreeNode left;
 	 	 TreeNode right;
 
 	 	 TreeNode(int x) {
 	 	 	 val = x;
 	 	 }
 	 }
 
 	 static class pair {
 	 	 int min = (int) 1e6;
 	 	 int max = (int) -1e6;
 	 	 boolean bst = true;
 
 	 	 pair(int min, int max, boolean bst) {
 	 	 	 this.min = min;
 	 	 	 this.max = max;
 	 	 	 this.bst = bst;
 	 	 }
 
 	 	 pair() {
 
 	 	 }
 	 }
 
 	 // This is a functional problem. You have to complete this function.
 	 // It takes as input the root node of the given tree. It should return 
 	 // true if it is a bst, else should return false.
 	 public static boolean isBST(TreeNode root) {
 	 	 return isBST_(root).bst;
 	 }
 
 	 public static pair isBST_(TreeNode root) {
 	 	 if (root == null)
 	 	 	 return new pair();
 	 	 if (root.left == null && root.right == null)
 	 	 	 return new pair(root.val, root.val, true);
 
 	 	 pair left = isBST_(root.left);
 	 	 pair right = isBST_(root.right);
 
 	 	 int min = Math.min(left.min, Math.min(right.min, root.val));
 	 	 int max = Math.max(left.max, Math.max(right.max, root.val));
 
 	 	 if (left.bst && right.bst && right.min > root.val && left.max < root.val) {
 	 	 	 return new pair(min, max, true);
 	 	 }
 
 	 	 return new pair(min, max, false);
 
 	 }
 
 	 public static void main(String[] args) {
 	 	 Scanner sc = new Scanner(System.in);
 	 	 String input = sc.nextLine().trim();
 
 	 	 Integer[] treeArr = inputSplitSpace(input);
 	 	 TreeNode root = createTree(treeArr);
 
 	 	 if(isBST(root)){
 	 	 	 System.out.println("Yes");
 	 	 } else {
 	 	 	 System.out.println("No");
 	 	 }
 
 
 	 }
 	 
 	 // utility function to display a binary tree.
 	 public static void display(TreeNode node) {
 	 	 if (node == null) {
 	 	 	 return;
 	 	 }
 
 	 	 String str = "";
 
 	 	 str += node.left == null ? "." : node.left.val;
 	 	 str += " <= " + node.val + " => ";
 	 	 str += node.right == null ? "." : node.right.val;
 
 	 	 System.out.println(str);
 
 	 	 display(node.left);
 	 	 display(node.right);
 	 }
 
 	 // utility function, don't change its code
 	 public static Integer[] inputSplitSpace(String str) {
 	 	 String[] sArr = str.split(" ");
 	 	 Integer[] arr = new Integer[sArr.length];
 	 	 for (int i = 0; i < arr.length; i++) {
 	 	 	 arr[i] = sArr[i].equals("null") ? null : Integer.parseInt(sArr[i]);
 	 	 }
 	 	 return arr;
 	 }
 
 	 // utility function to create a tree, don't change its code.
 	 public static TreeNode createTree(Integer[] arr) {
 	 	 ArrayDeque<TreeNode> que = new ArrayDeque<>();
 	 	 TreeNode root = new TreeNode(arr[0]);
 	 	 que.addLast(root);
 	 	 int i = 1;
 	 	 while (!que.isEmpty() && i < arr.length) {
 	 	 	 TreeNode nn = que.removeFirst();
 
 	 	 	 if (i < arr.length && arr[i] != null) {
 	 	 	 	 TreeNode n = new TreeNode(arr[i]);
 	 	 	 	 nn.left = n;
 	 	 	 	 que.addLast(n);
 	 	 	 }
 	 	 	 i++;
 
 	 	 	 if (i < arr.length && arr[i] != null) {
 	 	 	 	 TreeNode n = new TreeNode(arr[i]);
 	 	 	 	 nn.right = n;
 	 	 	 	 que.addLast(n);
 	 	 	 }
 	 	 	 i++;
 	 	 }
 
 	 	 return root;
 	 }
 
 
 }
