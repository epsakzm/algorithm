package leetcode.twopointers;

// https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfTheLinkedList {
    public class ListNode {
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

    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        temp = head;
        for (int i = 0; i < len / 2; ++i)
            temp = temp.next;
        return temp;
    }
}
