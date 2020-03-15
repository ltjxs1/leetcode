package cn.jzp.leetcode.q198;

public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums[1] < nums[0]){
            nums[1] = nums[0];
        }
        int maxNum = nums[1];
        for(int i = 2; i < nums.length; i++){
            int steal = nums[i - 2] + nums[i];
            int giveup = nums[i - 1];
            nums[i] = steal > giveup ? steal : giveup;
            if(nums[i] > maxNum){
                maxNum = nums[i];
            }
        }
        return maxNum;
    }
}