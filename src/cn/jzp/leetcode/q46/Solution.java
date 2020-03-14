package cn.jzp.leetcode.q46;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutes = new LinkedList<>();
        for(int i = 0; i < nums.length ; i++){
            permutes = permute0(permutes,nums[i]);
        }
        return permutes;
    }

    private List<List<Integer>> permute0(List<List<Integer>> prePermutes, int nextAdd){
        List<List<Integer>> newPermutes = new LinkedList<>();
        if(prePermutes.size() == 0){
            List<Integer> onePermute = new LinkedList<>();
            onePermute.add(nextAdd);
            newPermutes.add(onePermute);
        }
        else{
            for(int i = 0; i < prePermutes.size() ; i++){
                List<Integer> prePermute = prePermutes.get(i);
                for(int j = 0; j <= prePermute.size() ; j++){
                    List<Integer> onePermute = new LinkedList<>();
                    onePermute.addAll(prePermute);
                    onePermute.add(j,nextAdd);
                    newPermutes.add(onePermute);
                }
            }
        }
        return newPermutes;
    }
}