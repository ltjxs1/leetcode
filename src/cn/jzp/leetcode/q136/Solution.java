package cn.jzp.leetcode.q136;

import cn.jzp.leetcode.common.annotation.Finish;

@Finish
public class Solution {
    public int singleNumber(int[] nums) {
        for(int i = 1;i<nums.length;i++){
            nums[i] = nums[i] ^ nums[i - 1];
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{1,2,3,4,4,3,2,1,9,4,3,2,1}));
    }
}