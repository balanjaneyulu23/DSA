package com.dsa.striversa2z.step6_3.medium;

import java.util.HashMap;
import java.util.Map;
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
      /*  ListNode head = constructList(arr);
        traverseLL(head);
        System.out.println(" ");
        ListNode node = reverseListRecursion(head);
        traverseLL(node);*/

        ListNode head = constructCycle();
        System.out.println(hasCycleOptimal(head));


    }

    static ListNode constructCycle() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        fifth.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = third;
        return fifth;
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

    public static boolean hasCycleBruteForce(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            }
            map.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }

    public static boolean hasCycleOptimal(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static ListNode detectCycleBruteForce(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }
            map.put(temp, 1);
            temp = temp.next;
        }
        return null;
    }

    public static ListNode detectCycleOptimal(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }


    public int countNodesinLoopBruteForce(Node head) {
        Map<Node, Integer> map = new HashMap<>();
        Node temp = head;
        int timer = 0;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return timer = map.get(timer);
            }
            map.put(temp, timer + 1);
        }
        return 0;
    }

    public int countNodesinLoopOptimal(Node head) {
        if (head == null || head.next == null) return 0;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // found there is a cycle existed
                int count = 1;
                fast = fast.next;
                while (fast != slow) {
                    count++;
                    fast = fast.next;
                }
                return count;
            }
        }
        return 0;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}



