package com.dsa.striversa2z.step6_4.medium;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class MediumProblemsOnDLL {
    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 3, 4, 4};
        Node head = convertArrayIntoLinkedList(arr);
        System.out.println("Before deletion");
        traverseDLL(head);
        Node node = removeDuplicates(head);
        //System.out.println(findPairsWithGivenSum(34, head));
        System.out.println("After deletion");
        traverseDLL(node);
    }

    static void traverseDLL(Node head) {
        if (head == null) return;
        while (head != null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
    }

    static Node convertArrayIntoLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node currentNode = new Node(arr[i]);
            currentNode.prev = temp;
            temp.next = currentNode;
            temp = currentNode;
        }
        return head;
    }


    static Node deleteAllOccurOfX(Node head, int x) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) {
                if (temp == head) {
                    head = temp.next;
                }

                Node nextNode = temp.next;
                Node prevNode = temp.prev;
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }
                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }


    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSumBruteForce(int target, Node head) {
        if (head == null) return null;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Node temp1 = head;
        while (temp1 != null) {
            Node temp2 = temp1.next;
            while (temp2 != null) {
                int sum = temp1.data + temp2.data;
                if (sum == target) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(temp1.data);
                    pair.add(temp2.data);
                    list.add(pair);
                } else if (sum > target) {
                    break;
                }

                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return list;
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        if (head == null) return null;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Node tail = findTail(head);
        while (head.data < tail.data) {
            long sum = head.data + tail.data;
            if (sum == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(head.data);
                pair.add(tail.data);
                list.add(pair);
                head = head.next;
                tail = tail.prev;
            } else if (sum < target) {
                head = head.next;
            } else {
                tail = tail.prev;
            }
        }
        return list;
    }

    private static Node findTail(Node head) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    static Node removeDuplicates(Node head) {
        if (head == null) return null;
        Node temp = head;
        while (temp != null && temp.next != null) {
            Node nextNode = temp.next;
            while (nextNode != null && temp.data == nextNode.data) {
                nextNode = nextNode.next;
            }

            temp.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = temp;
            }
            temp = nextNode;
        }
        return head;
    }
}

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}
