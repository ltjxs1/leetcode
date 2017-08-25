package cn.jzp.leetcode.q109;

import cn.jzp.leetcode.common.annotation.Finish;
import cn.jzp.leetcode.common.struct.ListNode;
import cn.jzp.leetcode.common.struct.TreeNode;

/**
 * Created by jiangzhipeng1 on 2017/2/27.
 */

@Finish
public class Solution {
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        int len = count(head);
        TreeNode treeNodeBone = lenToBSTBone(len);
        fillBSTBone(treeNodeBone,head);
        return treeNodeBone;
    }
    private int count(ListNode listNode){
        if(listNode == null){
            return 0;
        }
        int i = 0;
        for(;;){
            if(listNode == null){
                return i;
            }else{
                i++;
                listNode = listNode.next;
            }
        }
    }

    private TreeNode lenToBSTBone(int len){
        if(len == 0){
            return null;
        }
        int root = (len - 1) >> 1;
        TreeNode rootNode = new TreeNode(-1);
        if(root>0) {
            rootNode.left = lenToBSTBone(root);
        }
        if(root < len) {
            rootNode.right = lenToBSTBone(len - root - 1);
        }
        return rootNode;
    }

    private ListNode fillBSTBone(TreeNode bstBone,ListNode listNode){
        if(bstBone.left!= null) {
            listNode = fillBSTBone(bstBone.left, listNode);
        }
        bstBone.val = listNode.val;
        listNode = listNode.next;
        if(bstBone.right != null)
        listNode = fillBSTBone(bstBone.right, listNode);
        return listNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sortedListToBST(
                new ListNode(new int[]{1,2,3,4,5,6})
        ));
        System.out.println(solution.sortedListToBST(
                new ListNode(new int[]{1,2,3,4,5,6,7,8,9,10,11})
        ));
        System.out.println(solution.sortedListToBST(
                new ListNode(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17})
        ));

    }
}