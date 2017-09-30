package cn.jzp.leetcode.q125;

import cn.jzp.leetcode.common.annotation.Finish;

/**
 * Created by jiangzhipeng1 on 2017/8/31.
 */
@Finish
public class Q125 {
    public static
    class Solution {
        public boolean isPalindrome(String s) {
            for(int i = 0, j = s.length() - 1;i < j;){
            
                char start = s.charAt(i);
                if(!isValid(start)){
                    i++;
                    continue;
                }
                char end = s.charAt(j);
                if(!isValid(end)){
                    j--;
                    continue;
                }
                if(Character.toLowerCase(s.charAt(i))
                        == Character.toLowerCase(s.charAt(j))){
                    i++;
                    j--;
                    continue;
                }else{
                    return false;
                }
            }
            return true;
        }
        private boolean isValid(char c){
            return Character.isLetterOrDigit(c);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("as##  #$dd#$#  $#@!@sa"));
        System.out.println(new Solution().isPalindrome("asdsaddasdsa"));
        System.out.println(new Solution().isPalindrome("asdadas"));
        System.out.println(new Solution().isPalindrome("asdadas"));
    }
}
