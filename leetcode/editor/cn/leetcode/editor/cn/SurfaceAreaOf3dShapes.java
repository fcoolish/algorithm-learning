//给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单
//元格 (i, j) 上。 
//
// 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。 
//
// 请你返回最终这些形体的总表面积。 
//
// 注意：每个形体的底面也需要计入表面积中。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,2],[3,4]]
//输出：34
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//输出：32
// 
//
// 示例 3： 
//
// 
//输入：grid = [[2,2,2],[2,1,2],[2,2,2]]
//输出：46
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 50 
// 0 <= grid[i][j] <= 50 
// 
// Related Topics 几何 数组 数学 矩阵 
// 👍 160 👎 0

package leetcode.editor.cn;
public class SurfaceAreaOf3dShapes{
    public static void main(String[] args){
        Solution solution = new SurfaceAreaOf3dShapes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int surfaceArea(int[][] grid) {
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};
        int n = grid.length;
        int ans = 0;
        for(int i = 0;i < n;i++){
            for(int j =0;j < n;j++){
                if(grid[i][j] >0)ans = ans+2;
                 for(int k=0;k < 4;k++){
                     int tx = i + dx[k];
                     int ty = j + dy[k];
                     if(tx <0 || tx >=n || ty <0 || ty >=n){
                         ans += grid[i][j];
                     }else{
                         ans = ans + Math.max(grid[i][j] - grid[tx][ty],0);
                     }
                 }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}