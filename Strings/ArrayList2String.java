public class Solution { 
  
    public static String[] GetStringArray(ArrayList<String> arr) 
    { 
        String str[] = new String[arr.size()]; 
  
        for (int j = 0; j < arr.size(); j++) { 
            str[j] = arr.get(j); 
        } 
  
        return str; 
    } 
  
    public static void main(String[] args) 
    { 
        ArrayList<String> 
            a1 = new ArrayList<String>(); 
  
        a1.add("Nazeer"); 
        a1.add("for"); 
        a1.add("Ashraf"); 
  
        System.out.println("ArrayList: " + a1); 
  
        String[] str = GetStringArray(a1); 
  
        System.out.print("String Array[]: "
                         + Arrays.toString(str)); 
    } 
} 
