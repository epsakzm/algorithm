package leetcode.twopointers;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEnd {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0)
            return head;
        ListNode first, second, temp;
        first = second = temp = head;
        int len = 1;
        while (temp.next != null) {
            temp = temp.next;
            ++len;
        }
        if (len == n)
            return head.next;
        n %= len;
        for (int i = 0; i < len - n - 1; i++)
            first = first.next;
        second = first.next;
        first.next = second.next;
        return head;
    }
}
