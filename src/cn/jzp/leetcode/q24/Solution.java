package cn.jzp.leetcode.q24;

import cn.jzp.leetcode.common.annotation.Finish;

@Finish
public class Solution {
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    public ListNode swapPairs(ListNode head) {
        ListNode first = head;
        ListNode second;
        ListNode third;

        if(first == null){
            return first;
        }
        second = first.next;
        if(second == null){
            return first;
        }
        third = second.next;
        first.next = swapPairs(third);
        second.next = first;
        return second;
    }
}
