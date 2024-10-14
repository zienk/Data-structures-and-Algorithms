
package com.zienk;

public class Main {
    public static void main(String[] args) {     
        MyLinkedList list = new MyLinkedList();
        
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        
        list.insertLast(99);
        
        list.insert(100, 3);
        
        list.display();
        
        System.out.println("Delete node " + list.deleteFirst());
        
        list.display();
        
        System.out.println(list.get(0).value);
        
        System.out.println("Delete node " + list.deleteLast());
        
        list.display();
        
        System.out.println("Delete node " + list.delete(2));
        
        list.display();
        
        
        
    }
}
