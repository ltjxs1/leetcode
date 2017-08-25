package cn.jzp.leetcode.q108;

/**
 * Created by jiangzhipeng1 on 2017/2/27.
 */

import cn.jzp.leetcode.common.annotation.Finish;
import cn.jzp.leetcode.common.struct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Finish
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int num: nums){
            list.add(num);
        }
        return sortedArrayToBST(list);

    }
    public TreeNode sortedArrayToBST(List<Integer> list){
        if(list == null || list.size() == 0){
            return null;
        }
        int root = (list.size() - 1) >> 1;
        TreeNode rootNode = new TreeNode(list.get(root));
        if(root>0) {
            rootNode.left = sortedArrayToBST(list.subList(0, root));
        }
        if(root<list.size()) {
            rootNode.right = sortedArrayToBST(list.subList(root + 1, list.size()));
        }
        return rootNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sortedArrayToBST(new int[]{1,2,3,4,5,6}));
        System.out.println(solution.sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9,10,11}));
        System.out.println(solution.sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17}));
    }
}