package com.dsa.striversa2z.step6_3.medium;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

public class LinkedListMediamProblems {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = constructList(arr);
        traverseLL(head);
        System.out.println(" ");
        ListNode node = reverseListRecursion(head);
        traverseLL(node);
    }

    static ListNode constructList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode currentNode = new ListNode(arr[i], null);
            temp.next = currentNode;
            temp = currentNode;
        }
        return head;
    }

    static void traverseLL(ListNode head) {
        if (head == null) return;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        int size = sizeOfList(head);
        int middle = (size / 2) + 1;
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (middle == cnt) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    static int sizeOfList(ListNode head) {
        if (head == null) return 0;
        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    public static ListNode middleNodeOptimal(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseListBruteForce(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        // putting elements in stack
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            temp.val = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    public static ListNode reverseListBetter(ListNode head) {
        ListNode currentNode = head;
        ListNode prev = null;
        while (currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }
        return prev;
    }

    public static ListNode reverseListRecursion(ListNode head) {

        //Base case
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseListRecursion(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}



