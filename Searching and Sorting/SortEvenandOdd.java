import java.util.Arrays; 
import java.util.Collections; 
  
public class GFG { 
   
    static void twoWaySort(Integer arr[], int n) 
    { 
        
        int l = 0, r = n - 1; 
  
       
        int k = 0; 
  
        while (l < r) { 
           
            while (arr[l] % 2 != 0) { 
                l++; 
                k++; 
            } 
  
            
            while (arr[r] % 2 == 0 && l < r) 
                r--; 
  
            
            
            if (l < r) { 
               
                int temp = arr[l]; 
                arr[l] = arr[r]; 
                arr[r] = temp; 
            } 
        } 
  
        // Sort odd number in descending order 
        Arrays.sort(arr, 0, k, Collections.reverseOrder()); 
  
        // Sort even number in ascending order 
        Arrays.sort(arr, k, n); 
    } 
  
    // Driver Method 
    public static void main(String[] args) 
    { 
        Integer arr[] = { 1, 3, 2, 7, 5, 4 }; 
  
        twoWaySort(arr, arr.length); 
  
        System.out.println(Arrays.toString(arr)); 
    } 
} 
