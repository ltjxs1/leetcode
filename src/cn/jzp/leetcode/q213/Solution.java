package cn.jzp.leetcode.q213;

import cn.jzp.leetcode.common.annotation.Finish;

@Finish
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int robFirstRobCur = nums[0];
        int robFirstGiveupCur = nums[0];
        int giveupFirstRobCur = nums[1];
        int giveupFirstGiveupCur = 0;
        for(int i = 2; i < nums.length - 1; i++){
            int robFirstRobLast = robFirstRobCur;
            int robFirstGiveupLast = robFirstGiveupCur;
            int giveupFirstRobLast = giveupFirstRobCur;
            int giveupFirstGiveupLast = giveupFirstGiveupCur;
            robFirstRobCur = robFirstGiveupLast + nums[i];
            robFirstGiveupCur = robFirstRobLast;
            giveupFirstRobCur = giveupFirstGiveupLast + nums[i];
            giveupFirstGiveupCur = giveupFirstRobLast;

            if(robFirstGiveupCur > robFirstRobCur){
                robFirstRobCur = robFirstGiveupCur;
            }
            if(giveupFirstGiveupCur > giveupFirstRobCur){
                giveupFirstRobCur = giveupFirstGiveupCur;
            }
        }
        int maxnum = robFirstGiveupCur;
        if(robFirstRobCur > maxnum){
            maxnum = robFirstRobCur;
        }
        if(giveupFirstRobCur > maxnum){
            maxnum = giveupFirstRobCur;
        }
        if(giveupFirstGiveupCur + nums[nums.length - 1] > maxnum){
            maxnum = giveupFirstGiveupCur + nums[nums.length - 1];
        }
        return maxnum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rob(new int[]{2,7,9,3,1});
    }
}
