package cn.jzp.leetcode.q200;

import cn.jzp.leetcode.common.annotation.Finish;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jiangzhipeng1 on 2017/4/6.
 */
@Finish
public class Q200 {

    public class Solution {
        public int numIslands(char[][] grid) {
            if(grid.length == 0){
                return 0;
            }
            boolean[][] isVisited = new boolean[grid.length][grid[0].length];
            int count = 0;
            for(int i = 0;i<grid.length;i++){
                for(int j = 0;j<grid[i].length;j++){
                    if(grid[i][j] == '1' && !isVisited[i][j]){
                        count++;
                        visitIslands(grid,isVisited,i,j);
                    }
                }
            }
            return count;
        }
        private void visitIslands(char[][] grid, boolean[][] isVisited, final int x, final int y){
            Queue<Point> queue = new LinkedList<>();
            Point start = new Point(x,y);
            queue.add(start);
            for(;!queue.isEmpty();) {
                Point p = queue.poll();

                if (p.x + 1 < grid.length) {
                    if (grid[p.x + 1][p.y] == '1' && !isVisited[p.x + 1][p.y]) {
                        isVisited[p.x + 1][p.y] = true;
                        queue.add(new Point(p.x + 1 ,p.y));
                    }
                }
                if (p.y + 1 < grid[p.x].length) {
                    if (grid[p.x][p.y + 1] == '1' && !isVisited[p.x][p.y + 1]) {
                        isVisited[p.x][p.y + 1] = true;
                        queue.add(new Point(p.x ,p.y + 1));

                    }
                }
            }
        }
        class Point{
            int x;
            int y;
            Point(int x,int y){
                this.x = x;
                this.y = y;
            }
        }
    }

    public static void main(String[] args) {

    }

}
