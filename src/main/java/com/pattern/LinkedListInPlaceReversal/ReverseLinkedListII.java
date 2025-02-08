package com.pattern.LinkedListInPlaceReversal;

/*
92. Reverse Linked List II

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;


        // Move the current pointer to the left position
        for (int i = 0; current != null && i < left - 1; i++) {
            previous = current;
            current = current.next;
        }

        // Save the left position node and the previous node
        ListNode leftNode = current;
        ListNode leftNodePrevious = previous;

        // Reverse the nodes from left to right
        for (int i = 0; current != null && i < right - left + 1; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // Connect the leftNodePrevious to the right node
        if (leftNodePrevious != null) {
            leftNodePrevious.next = previous;
        } else {
            head = previous;
        }

        // Connect the left node to the right node
        leftNode.next = current;

        return head;
    }

}
