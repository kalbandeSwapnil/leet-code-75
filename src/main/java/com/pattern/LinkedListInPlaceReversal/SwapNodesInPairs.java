package com.pattern.LinkedListInPlaceReversal;

/*
24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

Example 1:

Input: head = [1,2,3,4]

Output: [2,1,4,3]

 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        while (current != null && current.next != null) {
            ListNode next = current.next;
            ListNode nextNext = next.next;

            if (previous != null) {
                previous.next = next;
            } else {
                head = next;
            }

            next.next = current;
            current.next = nextNext;

            previous = current;
            current = nextNext;
        }

        return head;
    }
}
