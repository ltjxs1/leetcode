package cn.jzp.leetcode.q47;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutes = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length ; i++){
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            for(int j = i; j< nums.length ; j++){
                if(nums[i] == nums[j]){
                    permutes = permute0(permutes,nums[i]);
                }
            }
        }
        Set<List<Integer>> unique = new HashSet<>();
        unique.addAll(permutes);
        List<List<Integer>> permutesUnique = new LinkedList<>();
        permutesUnique.addAll(unique);
        return permutesUnique;
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
                    boolean duplicate = false;
                    if(j != prePermute.size()){
                        duplicate = nextAdd == prePermute.get(j);
                    }

                    List<Integer> onePermute = new LinkedList<>();
                    if(!duplicate){
                        onePermute.addAll(prePermute);
                        onePermute.add(j,nextAdd);
                        newPermutes.add(onePermute);
                    }
                }
            }
        }
        return newPermutes;
    }
}