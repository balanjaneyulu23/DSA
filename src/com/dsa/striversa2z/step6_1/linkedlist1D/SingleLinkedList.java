package com.dsa.striversa2z.step6_1.linkedlist1D;

public class SingleLinkedList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = constructLL(arr);
        System.out.println("Before deletion");
        traverseLinkedList(head);
        Node node = insertAtK(head, 5, 10);
        System.out.println("After deletion");
        traverseLinkedList(node);
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
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }

    }

    static int sizeofLinkedList(Node head) {
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

    static Node deleteHead(Node head) {
        if (head == null) return head;
        head = head.getNext();
        return head;
    }

    static Node deleteTail(Node head) {
        Node temp = head;
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        return head;
    }

    //delete kth element in LL
    static Node deleteK(Node head, int val) {
        if (head == null) return null;

        // If it's first element
        if (val == 1) {
            return deleteHead(head);
        }

        int sizeOfLL = sizeofLinkedList(head);
        if (val > sizeOfLL) {
            return null;
        }
        // If it's last element
        if (val == sizeOfLL) {
            return deleteTail(head);
        }

        int cunt = 0;
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            cunt++;
            if (val == cunt) {
                prev.setNext(prev.getNext().getNext());
                break;
            }
            prev = temp;
            temp = temp.getNext();
        }
        return head;
    }

    // inserting element at first place i.e at head
    static Node insertHead(Node head, int val) {
        if (head == null) return head;
        return new Node(val, head);
    }

    static Node insertLast(Node head, int val) {
        if (head == null) return null;
        Node temp = head;
        while (temp != null) {
            if (temp.getNext() == null) {
                temp.setNext(new Node(val));
                break;
            }
            temp = temp.getNext();
        }
        return head;
    }

    static Node insertAtK(Node head, int k, int val) {
        if (head == null) return head;
        // If k is 1 that means insertion at head
        if (k == 1) {
            return insertHead(head, val);
        }
        int size = sizeofLinkedList(head);
        if (k > size) {
            return null;
        }
        //If k=size of ll then insertion at last
        if (size == k) {
            return insertLast(head, val);
        }

        //insertion b/w head and tail
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            if (k - 1 == count) {
                Node node = new Node(val, temp.getNext());
                temp.setNext(node);
                break;
            }
            temp = temp.getNext();
        }
        return head;
    }

    //leetcode #237problem
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void deleteNode(ListNode node) {
        if (node==null) return;
      node.val=node.next.val;
      node.next=node.next.next;

    }
}
