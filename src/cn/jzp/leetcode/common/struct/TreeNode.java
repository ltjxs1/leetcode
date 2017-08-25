package cn.jzp.leetcode.common.struct;

/**
 * Created by jiangzhipeng1 on 2017/2/28.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        if(left == null &&right == null){
            return val+"";
        }
        return "{"+val+" - "+left+" , "+right +" }";
    }
}
