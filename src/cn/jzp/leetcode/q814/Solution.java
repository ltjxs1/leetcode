package cn.jzp.leetcode.q814;

import cn.jzp.leetcode.common.struct.TreeNode;

public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null && root.val != 1){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val != 1){
            return null;
        }
        return root;
    }

}