package cn.jzp.leetcode.q3;

import cn.jzp.leetcode.common.annotation.Finish;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangzhipeng1 on 2017/2/17.
 */
@Finish
public class Q3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.lengthOfLongestSubstring("ohomm"));
//        System.out.println(solution.lengthOfLongestSubstring("ovcosdfv"));
//        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
//        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("4351654531546"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> characterMap = new HashMap<Character, Integer>();
        int maxLength = 1;
        int left = 0;
        characterMap.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            if (characterMap.containsKey(s.charAt(i))) {
                left = Math.max(characterMap.get(s.charAt(i)) + 1,left);
            }
            maxLength = Math.max(i - left + 1, maxLength);
            characterMap.put(s.charAt(i),i);
        }
        return maxLength;
    }
}