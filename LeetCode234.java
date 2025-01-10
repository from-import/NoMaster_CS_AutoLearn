package com.xxx;

import java.util.ArrayList;
import java.util.List;

public class LeetCode234 {
    // O(n) 空间复杂度
    public boolean isPalindrome1(ListNode head) {
        // 用数组存储链表的值
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        // 用双指针判断是否是回文
        int left = 0;
        int right = values.size() - 1;
        while (left < right) {
            if (!values.get(left).equals(values.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // O(n) 时间复杂度 + O(1) 空间复杂度
    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        slow = transListNode(slow);
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    // 翻转链表
    public ListNode transListNode(ListNode head) {
        ListNode pre = null;
        ListNode node = head;
        while (node != null) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }
}
