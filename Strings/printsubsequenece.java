class GFG  
{ 
  
    // str : Stores input string  
    // n : Length of str.  
    // curr : Stores current permutation  
    // index : Index in current permutation, curr  
    static void printSubSeqRec(String str, int n, 
                            int index, String curr)  
    { 
        // base case  
        if (index == n)  
        { 
            return; 
        } 
        System.out.println(curr); 
        for (int i = index + 1; i < n; i++)  
        { 
            curr += str.charAt(i); 
            printSubSeqRec(str, n, i, curr); 
  
            // backtracking  
            curr = curr.substring(0, curr.length() - 1); 
        } 
    } 
  
    // Generates power set in   
    // lexicographic order.  
    static void printSubSeq(String str)  
    { 
        int index = -1; 
        String curr = ""; 
  
        printSubSeqRec(str, str.length(), index, curr); 
    } 
  
    // Driver code  
    public static void main(String[] args)  
    { 
        String str = "cab"; 
        printSubSeq(str); 
    } 
} 
