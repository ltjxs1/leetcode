package cn.jzp.leetcode.q337;

import cn.jzp.leetcode.common.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<TreeNode, Integer> rootMap = new HashMap<>();
    Map<TreeNode, Integer> leafMap = new HashMap<>();
    public int rob(TreeNode root) {
        return robRoot(root);
    }
    private int robRoot(TreeNode root){
        if(root == null){
            return 0;
        }
        if(rootMap.containsKey(root)){
            return rootMap.get(root);
        }
        int leftLeaf = robLeaf(root.left);
        int rightLeaf = robLeaf(root.right);
        int leftRoot = robRoot(root.left);
        int rightRoot = robRoot(root.right);
        int leafCount = leftRoot + rightRoot;
        int rootCount = leftLeaf + rightLeaf + root.val;
        int max = leafCount > rootCount ? leafCount : rootCount;
        rootMap.put(root,max);
        return max;
    }

    private int robLeaf(TreeNode root){
        if(root == null){
            return 0;
        }
        if(leafMap.containsKey(root)){
            return leafMap.get(root);
        }
        int left = robRoot(root.left);
        int right = robRoot(root.right);
        int max = left + right;
        leafMap.put(root,max);
        return max;
    }
}