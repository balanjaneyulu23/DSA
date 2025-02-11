package com.dsa.striversa2z.step6_1.linkedlist1D;

public class ArrayToLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = constructLL(arr);
        //traverseLinkedList(head);
        System.out.println(searchInLL(head,4));

    }

    static Node constructLL(int arr[]) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node currentNode = head;

        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            currentNode.setNext(node);
            currentNode = node;
        }
        return head;
    }

    static void traverseLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }

    }

    static int SizeofLinkedList(Node head) {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            temp = temp.getNext();
            cnt++;
        }
        return cnt;
    }

    static boolean searchInLL(Node head, int val) {
        Node node = head;
        while (node != null) {
            if (node.getData() == val) return true;
            node = node.getNext();
        }
        return false;
    }
}


