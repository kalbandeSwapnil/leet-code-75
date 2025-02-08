package com.pattern.LinkedListInPlaceReversal;

/*
206. Reverse Linked List
Given the head of a singly linked list, reverse the list, and return the reversed list.


Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:
Input: head = [1,2]

 */


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next; // Save the next node
            current.next = previous; // Reverse the link
            previous = current; // Move previous one step forward
            current = next; // Move current one step forward
        }
        head = previous; // Update the head to the last node
        return head;

    }

}
