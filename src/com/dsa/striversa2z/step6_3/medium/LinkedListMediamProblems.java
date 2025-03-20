package com.dsa.striversa2z.step6_3.medium;

import java.util.*;

 class listNode {
    int val;
    listNode next;

    public listNode(int val) {
        this.val = val;
    }

    listNode() {
    }

    public listNode(int val, listNode next) {
        this.val = val;
        this.next = next;
    }

}

public class LinkedListMediamProblems {
    public static void main(String[] args) {

        int[] arr = {9, 9, 9};
        //  ListNode head = constructList(arr);
        // traverseLL(head);
        // System.out.println(" ");
        //  ListNode node = addOne(head);
        //  traverseLL(node);
       /* ListNode head = constructCycle();
        System.out.println(isPalindrome(head));*/

        //GFG

        Node headg = constructListGFG(arr);
        traverseLLG(headg);
        System.out.println(" ");
        Node node = addOne(headg);
        traverseLLG(node);


    }

    static listNode constructCycle() {
        listNode first = new listNode(1);
        listNode second = new listNode(2);
        listNode third = new listNode(1);
        listNode fourth = new listNode(1);
        listNode fifth = new listNode(5);
        fifth.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = third;
        return fifth;
    }


    static listNode constructList(int[] arr) {
        listNode head = new listNode(arr[0]);
        listNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            listNode currentNode = new listNode(arr[i], null);
            temp.next = currentNode;
            temp = currentNode;
        }
        return head;
    }

    static Node constructListGFG(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node currentNode = new Node(arr[i]);
            currentNode.next = null;
            temp.next = currentNode;
            temp = currentNode;
        }
        return head;
    }

    static void traverseLL(listNode head) {
        if (head == null) return;
        listNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }

    static void traverseLLG(Node head) {
        if (head == null) return;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    public static listNode middleNode(listNode head) {
        if (head == null || head.next == null) return head;
        int size = sizeOfList(head);
        int middle = (size / 2) + 1;
        listNode temp = head;
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

    static int sizeOfList(listNode head) {
        if (head == null) return 0;
        listNode temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    public static listNode middleNodeOptimal(listNode head) {
        if (head == null || head.next == null) return head;
        listNode slow = head;
        listNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static listNode reverseListBruteForce(listNode head) {
        Stack<Integer> stack = new Stack<>();
        // putting elements in stack
        listNode temp = head;
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

    public static listNode reverseListBetter(listNode head) {
        listNode currentNode = head;
        listNode prev = null;
        while (currentNode != null) {
            listNode next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }
        return prev;
    }

    public static listNode reverseListRecursion(listNode head) {

        //Base case
        if (head == null || head.next == null) return head;

        listNode newHead = reverseListRecursion(head.next);
        listNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static Node reverseListRecursionGFG(Node head) {

        //Base case
        if (head == null || head.next == null) return head;

        Node newHead = reverseListRecursionGFG(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static boolean hasCycleBruteForce(listNode head) {
        Map<listNode, Integer> map = new HashMap<>();
        listNode temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            }
            map.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }

    public static boolean hasCycleOptimal(listNode head) {
        if (head == null || head.next == null) return false;
        listNode fast = head;
        listNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static listNode detectCycleBruteForce(listNode head) {
        Map<listNode, Integer> map = new HashMap<>();
        listNode temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }
            map.put(temp, 1);
            temp = temp.next;
        }
        return null;
    }

    public static listNode detectCycleOptimal(listNode head) {
        if (head == null || head.next == null) return null;
        listNode slow = head;
        listNode fast = head;
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

    public static boolean isPalindrome(listNode head) {
        // finding the middle of the list
        listNode middleNode = findMiddleNodeOfLL(head);
        System.out.println("Middle" + middleNode.val);
        //reverse List from middle to end
        //compare first part and second part
        listNode second = reverseListRecursion(middleNode.next);
        System.out.println("NewHead" + second.val);
        listNode temp = second;
        listNode temNode1 = head;
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
    private static listNode findMiddleNodeOfLL(listNode head) {
        if (head == null || head.next == null) return head;
        listNode slow = head;
        listNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static listNode oddEvenListBruteForce(listNode head) {
        if (head == null || head.next == null) return head;
        List<listNode> list = new ArrayList<>();
        listNode temp = head;
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
            listNode first = list.get(i - 1);
            listNode second = list.get(i);
            second.next = null;
            first.next = second;
        }
        return head;

    }


    public static listNode oddEvenList(listNode head) {
        if (head == null || head.next == null) return head;

        listNode oddNode = head, evenNode = head.next, evenHead = head.next;

        while (evenNode != null && evenNode.next != null) {
            oddNode.next = oddNode.next.next;
            evenNode.next = evenNode.next.next;
            oddNode = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
        return head;
    }

    public static listNode removeNthFromEndBruteForce(listNode head, int n) {
        if (head == null || n <= 0) return head;

        if (head.next == null) return null;

        int size = sizeOfList(head);
        // we have to delete head
        if (size == n) {
            listNode newHead = head.next;
            head.next = null;
            return newHead;
        }

        Stack<listNode> stack = new Stack<>();

        listNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        int sizeStack = stack.size();
        listNode nodeBeforeDeleteNode = null;
        for (int i = 1; i <= sizeStack; i++) {
            nodeBeforeDeleteNode = stack.pop();
            if (i == n + 1) {
                break;
            }
        }

        if (nodeBeforeDeleteNode != null && nodeBeforeDeleteNode.next != null) {
            listNode nodeToBeDeleted = nodeBeforeDeleteNode.next;
            nodeBeforeDeleteNode.next = nodeToBeDeleted.next;
            nodeToBeDeleted.next = null;
        }
        return head;
    }

    public static listNode removeNthFromEndBetter(listNode head, int n) {
        if (head == null) return head;

        int sizeOfList = sizeOfList(head);
        int rest = sizeOfList - n;
        if (rest == 0) {
            listNode newHead = head.next;
            head.next = null;
            return newHead;
        }

        listNode temp = head;
        while (temp != null) {
            rest--;
            if (rest == 0) {
                listNode nodeToDelete = temp.next;
                temp.next = nodeToDelete.next;
                nodeToDelete.next = null;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

    public static listNode removeNthFromEndOptimal(listNode head, int n) {
        if (head == null || n == 0) return head;
        listNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) return head.next;

        listNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        listNode nodeToDelete = slow.next;
        slow.next = nodeToDelete.next;
        nodeToDelete.next = null;
        return head;
    }

    public static listNode deleteMiddleBrute(listNode head) {
        if (head == null || head.next == null) return null;
        int sizeOfLL = 0;
        listNode temp = head;
        while (temp != null) {
            sizeOfLL++;
            temp = temp.next;
        }

        temp = head;
        for (int i = 1; i < sizeOfLL / 2; i++) {
            temp = temp.next;
        }

        listNode nodeToDlete = temp.next;
        temp.next = nodeToDlete.next;
        nodeToDlete.next = null;
        return head;
    }

    public static listNode deleteMiddleOptimal(listNode head) {
        if (head == null || head.next == null) return null;

        listNode fast = head;
        listNode slow = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        listNode middleNode = slow.next;
        slow.next = middleNode.next;
        middleNode.next = null;
        return head;
    }

    public static listNode sortList(listNode head) {
        //If List is having single node or null then return head
        if (head == null || head.next == null) {
            return head;
        }
        listNode midNode = findMidNodeInList(head);
        listNode left = head, right = midNode.next;
        midNode.next = null;
        left = sortList(left);
        right = sortList(right);
        return mergeTwoLists(left, right);
    }

    private static listNode mergeTwoLists(listNode list1, listNode list2) {
        listNode dummy = new listNode(-1);
        listNode temp = dummy;
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

    private static listNode findMidNodeInList(listNode head) {
        listNode slow = head;
        listNode fast = head.next;
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

    public static listNode getIntersectionNode(listNode headA, listNode headB) {
        // If both the lists are zero nodes or any one is having null
        if (headA == null || headB == null) return headA;

        listNode temp1 = headA, temp2 = headB;
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

    public static Node addOneBruteForce(Node head) {
        if (head == null) return head;
        head = reverseListRecursionGFG(head);
        int carry = 1;
        Node temp = head;
        while (temp != null) {
            if (carry == 0) {
                break;
            }
            temp.data = temp.data + carry;
            if (temp.data < 10) {
                carry = 0;
            } else {
                temp.data = 0;
            }
            temp = temp.next;
        }
        head = reverseListRecursionGFG(head);
        if (carry == 1) {
            Node node = new Node(carry);
            node.next = head;
            return node;
        }
        return head;
    }

    public static Node addOne(Node head) {
        int carry = addoneHelper(head);
        if (carry == 1) {
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    private static int addoneHelper(Node head) {
        if (head == null) {
            return 1;
        }

        int carry = addoneHelper(head.next);
        head.data = head.data + carry;
        if (head.data < 10) {
            carry = 0;
        } else {
            head.data = 0;
        }
        return carry;
    }

    public static listNode addTwoNumbers(listNode l1, listNode l2) {
        listNode t1 = l1, t2 = l2, dummy = new listNode(-1);
        listNode currentNode = dummy;
        int carry = 0;
        while (t1 != null || t2 != null || carry == 1) {
            int sum = 0;
            if (t1 != null) sum += t1.val;
            if (t2 != null) sum += t2.val;
            sum += carry;
            carry = sum / 10;
            listNode newNode = new listNode(sum % 10);
            currentNode.next = newNode;
            currentNode = currentNode.next;

            if (t1 != null) t1 = t1.next;
            if (t2 != null) t2 = t2.next;
        }
        return dummy.next;
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



