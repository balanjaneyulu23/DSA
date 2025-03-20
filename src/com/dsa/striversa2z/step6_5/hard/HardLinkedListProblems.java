package com.dsa.striversa2z.step6_5.hard;

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

public class HardLinkedListProblems {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = constructList(arr);
        traverseLL(head);
        System.out.println(" ");
        ListNode node = rotateRight(head, 2);
        traverseLL(node);
       /* ListNode head = constructCycle();
        System.out.println(isPalindrome(head));*/


    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int listSize = 1;
        ListNode tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
            listSize++;
        }

        k = k % listSize;
        if (k == 0) {
            return head;
        }

        int end = listSize - k;
        tailNode.next = head;
        ListNode temp = head;
        while (temp != null) {
            end--;
            if (end == 0) {
                head = temp.next;
                temp.next = null;
                return head;
            }
            temp = temp.next;
        }
        return null;
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

    static ListNode reverseListRecursion(ListNode head) {

        //Base case
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseListRecursion(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, kthNode = null, nextNode = null, prevNode = null;
        while (temp != null) {
            kthNode = findKthNode(temp, k);
            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            reverseListRecursion(temp);
            if (temp == head) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;

        }
        return head;
    }

    private static ListNode findKthNode(ListNode head, int k) {
        ListNode temp = head;
        while (temp != null) {
            k--;
            if (k == 0) return temp;
            temp = temp.next;
        }
        return null;
    }


}


