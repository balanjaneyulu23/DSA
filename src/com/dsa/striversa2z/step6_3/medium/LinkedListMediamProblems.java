package com.dsa.striversa2z.step6_3.medium;

import java.util.*;

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

        int[] arr = {1, 2, 2, 1, 2, 0, 2, 2};
        ListNode head = constructList(arr);
        traverseLL(head);
        System.out.println(" ");
        ListNode node = sortList(head);
        traverseLL(node);
       /* ListNode head = constructCycle();
        System.out.println(isPalindrome(head));*/


    }

    static ListNode constructCycle() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(1);
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

    public static boolean isPalindrome(ListNode head) {
        // finding the middle of the list
        ListNode middleNode = findMiddleNodeOfLL(head);
        System.out.println("Middle" + middleNode.val);
        //reverse List from middle to end
        //compare first part and second part
        ListNode second = reverseListRecursion(middleNode.next);
        System.out.println("NewHead" + second.val);
        ListNode temp = second;
        ListNode temNode1 = head;
        while (temp != null) {
            if (temp.val != temNode1.val) {
                reverseListRecursion(second);
                return false;
            }
            temp = temp.next;
            temNode1 = temNode1.next;
        }
        return true;
    }

    // this method return lower middle node
    private static ListNode findMiddleNodeOfLL(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode oddEvenListBruteForce(ListNode head) {
        if (head == null || head.next == null) return head;
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            if (temp.next != null) {
                temp = temp.next.next;
            } else {
                temp = null;
            }

        }
        temp = head.next;
        while (temp != null) {
            list.add(temp);
            if (temp.next != null) {
                temp = temp.next.next;
            } else {
                temp = null;
            }
        }

        System.out.println(list.size());
        for (int i = 1; i < list.size(); i++) {
            ListNode first = list.get(i - 1);
            ListNode second = list.get(i);
            second.next = null;
            first.next = second;
        }
        return head;

    }


    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode oddNode = head, evenNode = head.next, evenHead = head.next;

        while (evenNode != null && evenNode.next != null) {
            oddNode.next = oddNode.next.next;
            evenNode.next = evenNode.next.next;
            oddNode = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
        return head;
    }

    public static ListNode removeNthFromEndBruteForce(ListNode head, int n) {
        if (head == null || n <= 0) return head;

        if (head.next == null) return null;

        int size = sizeOfList(head);
        // we have to delete head
        if (size == n) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        int sizeStack = stack.size();
        ListNode nodeBeforeDeleteNode = null;
        for (int i = 1; i <= sizeStack; i++) {
            nodeBeforeDeleteNode = stack.pop();
            if (i == n + 1) {
                break;
            }
        }

        if (nodeBeforeDeleteNode != null && nodeBeforeDeleteNode.next != null) {
            ListNode nodeToBeDeleted = nodeBeforeDeleteNode.next;
            nodeBeforeDeleteNode.next = nodeToBeDeleted.next;
            nodeToBeDeleted.next = null;
        }
        return head;
    }

    public static ListNode removeNthFromEndBetter(ListNode head, int n) {
        if (head == null) return head;

        int sizeOfList = sizeOfList(head);
        int rest = sizeOfList - n;
        if (rest == 0) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }

        ListNode temp = head;
        while (temp != null) {
            rest--;
            if (rest == 0) {
                ListNode nodeToDelete = temp.next;
                temp.next = nodeToDelete.next;
                nodeToDelete.next = null;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

    public static ListNode removeNthFromEndOptimal(ListNode head, int n) {
        if (head == null || n == 0) return head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) return head.next;

        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode nodeToDelete = slow.next;
        slow.next = nodeToDelete.next;
        nodeToDelete.next = null;
        return head;
    }

    public static ListNode deleteMiddleBrute(ListNode head) {
        if (head == null || head.next == null) return null;
        int sizeOfLL = 0;
        ListNode temp = head;
        while (temp != null) {
            sizeOfLL++;
            temp = temp.next;
        }

        temp = head;
        for (int i = 1; i < sizeOfLL / 2; i++) {
            temp = temp.next;
        }

        ListNode nodeToDlete = temp.next;
        temp.next = nodeToDlete.next;
        nodeToDlete.next = null;
        return head;
    }

    public static ListNode deleteMiddleOptimal(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middleNode = slow.next;
        slow.next = middleNode.next;
        middleNode.next = null;
        return head;
    }

    public static ListNode sortList(ListNode head) {
        //If List is having single node or null then return head
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = findMidNodeInList(head);
        ListNode left = head, right = midNode.next;
        midNode.next = null;
        left = sortList(left);
        right = sortList(right);
        return mergeTwoLists(left, right);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummy.next;
    }

    private static ListNode findMidNodeInList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node segregate(Node head) {
        // If there is no list or single list then return head
        if (head == null || head.next == null) return head;
        //calculate count of 0's ,1's and 2's
        int count0 = 0, count1 = 0, count2 = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                count0++;
            } else if (temp.data == 1) {
                count1++;
            } else {
                count2++;
            }
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (count0 != 0) {
                temp.data = 0;
                count0--;
            } else if (count1 != 0) {
                temp.data = 1;
                count1--;
            } else {
                temp.data = 2;
                count2--;
            }

            temp = temp.next;
        }

        return head;
    }

    static Node segregateOptimal(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node zerosHead = new Node(-1);
        Node zero = zerosHead;
        Node onesHead = new Node(-1);
        Node one = onesHead;
        Node twosHead = new Node(-1);
        Node two = twosHead;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }

            temp = temp.next;
        }
        zero.next = onesHead.next != null ? onesHead.next : twosHead.next;
        one.next = twosHead.next;
        two.next = null;
        return zerosHead.next;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If both the lists are zero nodes or any one is having null
        if (headA == null || headB == null) return headA;

        ListNode temp1 = headA, temp2 = headB;
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            if (temp1 == temp2)
                return temp1; // If there is a intersection then both are equal or both are pointing last node.next i.e null
            if (temp1 == null)
                temp1 = headB;// temp1 reaches last node hence routing it to start from first node of opposite list
            if (temp2 == null)
                temp2 = headA; //temp1 reaches last node hence routing it to start from first node of opposite list
        }
        return temp1;// if two lists are same then return any one of the head
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



