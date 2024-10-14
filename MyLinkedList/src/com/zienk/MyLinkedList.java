package com.zienk;

public class MyLinkedList {

    private Node head;
    private Node tail;

    private int size;

    public MyLinkedList() {
        this.size = 0;
    }

    //addFirst
    public void insertFirst(int value) {
        //Step 1: create a new node
        Node node = new Node(value);
        //Step 2: nối node đó vào head
        node.next = head;
        //Step 3: head always point to the first node
        head = node;

        //Nếu tail = null có nghĩa lúc này trong list mới có 1 node nên tail cũng trỏ node giống head
        if (tail == null) {
            tail = head;
        }

        size++;
    }

    public void insertLast(int value) {
        //Nếu tail = null có nghĩa là list isEmpty thì addLast cũng như addFirst thôi =))
        if (tail == null) {
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        tail = node;

        size++;
    }

    public void insert(int value, int index) {
        //TH1:Vị trí cần add có index là 0 thì giống insertFirst thoy ^^
        if (index == 0) {
            insertFirst(value);
            return;
        }
        //TH2:Vị trí cần add có index là cuối == size thì giống insertLast thoy ^^
        if (index == size) {
            insertLast(value);
            return;
        }
        //TH3:Cần duyệt qua list tới vị trí cần chèn/insert
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value, temp.next);
        temp.next = node;

        size++;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteLast() {
        if (size <= 1) {
            deleteFirst();
        }

        Node secondLast = get(size - 2);
        int value = tail.value;

        tail = secondLast;
        tail.next = null;

        return value;
    }

    public int deleteFirst() {
        int value = head.value;
        head = head.next;
        //TH: chỉ có duy nhất 1 node xóa xog thì list trống
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public int delete(int index) {
        if (index == 0) {
            deleteFirst();
        }
        if (index == size - 1) {
            deleteLast();
        }

        Node previous = get(index - 1);
        int value = previous.next.value;
        previous.next = previous.next.next;

        return value;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

}
