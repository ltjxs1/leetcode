package cn.jzp.leetcode.q128;

import cn.jzp.leetcode.common.annotation.NotFinish;

import java.util.*;

/**
 * Created by jiangzhipeng1 on 2017/9/30.
 */
@NotFinish
public class Q128 {

    class Solution {

        public int longestConsecutive(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new TreeSet<>();
            int maxDepth = 1;
            for (int i : nums) {
                set.add(i);
            }
            for (int i : set) {
                if (!map.containsKey(i)) {
                    map.put(i, 1);
                }
                if (set.contains(i + 1)) {
                    int res = map.get(i) + 1;
                    map.put(i + 1, res);
                    if (res > maxDepth) {
                        maxDepth = res;
                    }
                }
            }
            return 0;
        }
    }
}
