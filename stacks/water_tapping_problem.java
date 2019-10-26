import java.util.*;
 
 class Main {
 
     public static int trap(int[] height) {
         int M = 1000000007;
         int[] nextGreaterRight = new int[height.length];
         int[] nextGreaterLeft = new int[height.length];
         Stack<Integer> stack = new Stack<>();
 
         //nextGreaterRight
         for (int i = 0; i < height.length; i++) {
             while (stack.size() != 0 && height[stack.peek()] < height[i]) {
                 nextGreaterRight[stack.pop()] = i;
             }
             stack.add(i);
         }
         while (stack.size() != 0) {
             nextGreaterRight[stack.pop()] = -1;
         }
 
         //nextGreaterLeft
         for (int i = 0; i < height.length; i++) {
             while (stack.size() != 0 && height[stack.peek()] < height[i]) {
                 stack.pop();
             }
 
             if (stack.size() == 0) {
                 nextGreaterLeft[i] = -1;
             } else {
                 nextGreaterLeft[i] = stack.peek();
             }
             stack.add(i);
         }
 
         //Calculating the water trapped 
         int l = 0;
         int ans = 0;
         while (l < height.length && nextGreaterRight[l] != -1) {
             for (int i = l + 1; i < nextGreaterRight[l]; i++) {
                 ans += (height[l] - height[i]) % M;
             }
             l = nextGreaterRight[l];
         }
         if (l <= height.length - 3) {
             int r = height.length - 1;
             while (r > l) {
                 for (int i = r - 1; i > nextGreaterLeft[r]; i--) {
                     ans += (height[r] - height[i]) % M;
                 }
                 r = nextGreaterLeft[r];
             }
         }
         return ans;
 
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int N = sc.nextInt();
         int[] height = new int[N];
         for (int i = 0; i < N; i++) {
             height[i] = sc.nextInt();
         }
         System.out.print(trap(height));
     }
 }
