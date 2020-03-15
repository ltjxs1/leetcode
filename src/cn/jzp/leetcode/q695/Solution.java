package cn.jzp.leetcode.q695;

import cn.jzp.leetcode.common.annotation.Finish;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

@Finish
public class Solution {
    Set<String> visitSet = new HashSet<>();
    public int maxAreaOfIsland(int[][] grid) {
        int maxdepth = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length;j++){
                if(grid[i][j] == 1){
                    int landLength = islandLengthOfHead(grid, i,j);
                    if(maxdepth < landLength){
                        maxdepth = landLength;
                    }
                }
            }
        return maxdepth;
    }

    private int islandLengthOfHead(int[][] grid, int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        int length = 1;
        grid[x][y] = 0;
        for(int x0,y0;!queue.isEmpty();){
            x0 = queue.poll();
            y0 = queue.poll();
            if(x0!=0 && grid[x0-1][y0] == 1){
                queue.add(x0-1);
                queue.add(y0);
                grid[x0-1][y0] = 0;
                length ++;
            }
            if(x0 < grid.length - 1 && grid[x0+1][y0] == 1){
                queue.add(x0+1);
                queue.add(y0);
                grid[x0+1][y0] = 0;
                length ++;
            }
            if(y0!=0 && grid[x0][y0-1] == 1){
                queue.add(x0);
                queue.add(y0-1);
                grid[x0][y0-1] = 0;
                length ++;
            }
            if(y0 < grid[x0].length - 1 && grid[x0][y0+1] == 1){
                queue.add(x0);
                queue.add(y0+1);
                grid[x0][y0+1] = 0;
                length ++;
            }
        }
        return length;
    }
}