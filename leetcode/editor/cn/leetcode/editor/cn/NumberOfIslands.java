//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ['1','1','1','1','0'],
//  ['1','1','0','1','0'],
//  ['1','1','0','0','0'],
//  ['0','0','0','0','0']
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ['1','1','0','0','0'],
//  ['1','1','0','0','0'],
//  ['0','0','1','0','0'],
//  ['0','0','0','1','1']
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2166 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        solution.numIslands(grid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //深度优先
        public int numIslands(char[][] grid) {
            int res = 0;
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '0') {
                        continue;
                    }
                    res++;
                    dfs(grid,i,j);
                }
            }
            return res;
        }

        private void dfs(char[][] grid,int r,int c){
            if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0'){
                return;
            }
            grid[r][c] = '0';
            dfs(grid,r,c - 1);
            dfs(grid,r,c + 1);
            dfs(grid,r - 1,c);
            dfs(grid,r + 1,c);
        }

        //迭代法
        public int numIslands1(char[][] grid) {
            int res = 0;
            int[] dx = new int[]{0, 0, -1, 1};
            int[] dy = new int[]{1, -1, 0, 0};
            int m = grid.length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '0') {
                        continue;
                    }
                    res++;
                    Queue<String> queue = new ArrayDeque<>();
                    queue.offer(getKey(i,j));
                    grid[i][j] = '0';
                    while (!queue.isEmpty()){
                        String[] strA = queue.poll().split("_");
                        for (int k = 0; k < 4; k++) {
                            int tx = Integer.valueOf(strA[0]) + dx[k] ;
                            int ty = Integer.valueOf(strA[1]) + dy[k];
                            if (tx < 0 || tx >= m || ty < 0 || ty >= grid[i].length || grid[tx][ty] == '0') {
                                continue;
                            }
                            grid[tx][ty] = '0';
                            queue.offer(getKey(tx,ty));
                        }
                    }
                }
            }
            return res;
        }

        private String getKey(int x,int y){
            StringBuilder sb = new StringBuilder();
            return sb.append(x).append("_").append(y).toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}