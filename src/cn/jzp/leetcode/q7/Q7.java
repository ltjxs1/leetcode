package cn.jzp.leetcode.q7;

import cn.jzp.leetcode.common.annotation.Finish;

/**
 * Created by jiangzhipeng1 on 2017/2/16.
 */
@Finish
public class Q7 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(1234));
        System.out.println(solution.reverse(-1234));
        System.out.println(solution.reverse(1234567891));
        System.out.println(solution.reverse(-1234567891));
        System.out.println(solution.reverse(2134567899));
        System.out.println(solution.reverse(-2134567899));
        System.out.println(solution.reverse(1234567809));
        System.out.println(solution.reverse(Integer.MAX_VALUE));
        System.out.println(solution.reverse(Integer.MIN_VALUE));
    }
}
class Solution {
    public int reverse(int x) {
        boolean isBiggerOrEqualThanZero = true;
        if(x<0){
            isBiggerOrEqualThanZero = false;
            if(x == Integer.MIN_VALUE){
                return 0; // overflow
            }
            x = -x;
        }
        long result = 0;
        for(;x != 0;){
            int mod = x%10;
            x = x/10;
            result *= 10;
            result +=mod;
            if(isBiggerOrEqualThanZero){
                if(result > Integer.MAX_VALUE) {
                    return 0;
                }
            }else{
                if(-result < Integer.MIN_VALUE){
                    return 0;
                }
            }
        }
        if(!isBiggerOrEqualThanZero){
            result = -result;
        }
        return (int)result;
    }
}