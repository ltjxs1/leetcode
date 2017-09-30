package cn.jzp.leetcode.q135;

import cn.jzp.leetcode.common.annotation.Finish;

/**
 * Created by jiangzhipeng1 on 2017/9/30.
 */
@Finish
public class Q135 {
    
    class Solution {
        public int candy(int[] ratings) {
            if(ratings == null){
                return 0;
            }
            int sum = ratings.length;
            int[] candys = new int[ratings.length];
            for(int i = 1;i < ratings.length;i++){
                if(ratings[i] > ratings[i-1]){
                    candys[i] = candys[i-1]+1;
                }
            }
            for(int i = ratings.length - 2; i>=0;i--){
                if(ratings[i] > ratings[i+1]){
                    candys[i] = Math.max(candys[i],candys[i+1]+1);
                }
            }
            for(int i = 0; i < ratings.length;i++){
                sum+=candys[i];
            }
            return sum;
        }
    }
}
