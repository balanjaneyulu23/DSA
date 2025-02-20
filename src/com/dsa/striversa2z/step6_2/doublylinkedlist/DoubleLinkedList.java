package com.dsa.striversa2z.step6_2.doublylinkedlist;


import javax.sound.midi.MidiFileFormat;
import java.util.IllegalFormatCodePointException;

class Node {
    int data;
    Node next;
    Node back;

    public Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class DoubleLinkedList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = convertArrayIntoLinkedList(arr);
        traverseDLL(head);
        System.out.println("Before deletion");
        Node node = reverseDLL(head);
        System.out.println("After deletion");
        traverseDLL(node);
    }

    static Node convertArrayIntoLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node currentNode = new Node(arr[i], null, temp);
            temp.next = currentNode;
            temp = currentNode;
        }
        return head;
    }

    static void traverseDLL(Node head) {
        if (head == null) return;
        while (head != null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
    }

    static int sizeOfDLL(Node head) {
        if (head == null) return 0;
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    static Node deleteHead(Node head) {
        //If head is null Or head is the  only element in  the list
        if (head == null || head.next == null) return null;
        Node temp = head;
        head = head.next;
        head.back = null;
        temp.next = null;
        return head;
    }

    static Node deleteLast(Node head) {
        if (head == null || head.next == null) return null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        Node tail = temp.back;
        tail.next = null;
        temp.back = null;
        return head;
    }

    static Node deleteAtK(Node head, int k) {
        if (head == null || head.next == null) return null;
        //deletion is at  head
        if (k == 1) {
            return deleteHead(head);
        }
        int size = sizeOfDLL(head);
        //If k is greater than list
        if (size < k) {
            return null;
        }

        // deletion is at tail
        if (k == size) {
            return deleteLast(head);
        }

        Node temp = head;
        int cnt = 0;
        //finding  node to be delete
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                break;
            }
            temp = temp.next;
        }

        if (temp == null) return null;
        Node removalNode = temp;
        removalNode.back.next = removalNode.next;
        removalNode.next.back = removalNode.back;
        removalNode.next = null;
        removalNode.back = null;
        return head;
    }

    static Node insertAtHead(Node head, int val) {
        if (head == null) return null;
        Node node = new Node(val);
        node.next = head;
        return node;
    }

    static Node insertLast(Node head, int val) {
        if (head == null) return head;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node tail = new Node(val);
        tail.next = null;
        tail.back = temp;
        temp.next = tail;
        return head;
    }

    static Node insertAtK(Node head, int k, int val) {
        if (k == 1) {
            return insertAtHead(head, val);
        }
        int size = sizeOfDLL(head);
        if (k > size + 1) return null;
        if (k == size + 1) return insertLast(head, val);
        Node temp = head;
        int count = 0;
        while (temp.next != null) {
            count++;
            if (count == k) {
                break;
            }
            temp = temp.next;
        }

        Node insertionNode = new Node(val);
        temp.back.next = insertionNode;
        insertionNode.back = temp.back;
        insertionNode.next = temp;
        temp.back = insertionNode;
        return head;
    }

    static Node reverseDLL(Node head) {
        if (head == null || head.next == null) return head;
        Node currentNode = head;
        Node back=null;
        while (currentNode!= null) {
            back = currentNode.back;
            currentNode.back = currentNode.next;
            currentNode.next = back;
            currentNode = currentNode.back;
        }
        return back.back;
    }

}
