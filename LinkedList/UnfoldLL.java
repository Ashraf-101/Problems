public class Solution { 
  
    private class Node { 
        int data; 
        Node next; 
    } 
  
    private Node head; 
  
    private Node tail; 
  
    public void display() 
    { 
        if (head == null) 
            return; 
        Node temp = head; 
  
        while (temp != null) { 
            System.out.print(temp.data + " "); 
            temp = temp.next; 
        } 
        System.out.println(); 
    } 
  
    public void push(int data) 
    { 
        Node nn = new Node(); 
        nn.data = data; 
        nn.next = null; 
  
        if (head == null) { 
            head = nn; 
        } 
        else { 
            Node temp = head; 
  
            while (temp.next != null) { 
                temp = temp.next; 
            } 
            temp.next = nn; 
        } 
    } 
  
    private void unfold(Node node) 
    { 
        if (node == null) 
            return; 
  
        if (node.next == null) { 
            head = tail = node; 
            return; 
        } 
  
        else if (node.next.next == null) { 
            head = node; 
            tail = node.next; 
            return; 
        } 
  
  
        unfold(node.next.next); 
  
        node.next = head; 
        head = node; 
  
        tail.next = temp; 
        tail = temp; 
        tail.next = null; 
    } 
  
    public static void main(String[] args) 
    { 
  
        Solution l = new Solution(); 
  
        l.push(1); 
        l.push(5); 
        l.push(2); 
        l.push(4); 
        l.push(3); 
  
        l.display(); 
        l.unfold(l.head); 
  
        l.display(); 
    } 
} 
