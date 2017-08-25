package cn.jzp.leetcode.common.struct;

/**
 * Created by jiangzhipeng1 on 2017/2/28.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(int[] nums){
        ListNode current = null;
        boolean first = true;
        for(int i : nums){
            if(first){
                val = i;
                current = this;
                first = false;
            }else{
                ListNode next = new ListNode(i);
                current.next = next;
                current = next;
            }
        }
    }
}
