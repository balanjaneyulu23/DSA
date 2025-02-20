package com.dsa.striversa2z.step6_1.linkedlist1D;

public class ArrayToLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(constructLL(arr));
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


}


