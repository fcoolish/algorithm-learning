//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
// 
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 数组 动态规划 矩阵 👍 762 👎 0

package leetcode.editor.cn;
public class LongestIncreasingPathInAMatrix{
    public static void main(String[] args){
        Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
        int[][] gg = {{3,4,5},{3,2,6},{2,2,1}};
        solution.longestIncreasingPath(gg);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int rows, columns;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            rows = matrix.length;
            columns = matrix[0].length;
            int[][] memo = new int[rows][columns];
            int ans = 0;
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    ans = Math.max(ans, dfs(matrix, i, j, memo));
                }
            }
            return ans;
        }

        public int dfs(int[][] matrix, int row, int column, int[][] memo) {
            if (memo[row][column] != 0) {
                return memo[row][column];
            }
            ++memo[row][column];
            for (int[] dir : dirs) {
                int newRow = row + dir[0], newColumn = column + dir[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                    memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
                }
            }
            return memo[row][column];
        }

        int max = 0;
        int tol = 0;
        public int longestIncreasingPath1(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            tol = m * n;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(matrix,i,j,-1,0);
                }
            }
            return max;
        }

        private void dfs(int[][] grid,int r,int c,int pre,int res){
            if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] <= pre){
                return;
            }
            if(max >= tol)return;
            res++;
            max = Math.max(max,res);
            pre = grid[r][c];
            grid[r][c] = -1;
            dfs(grid,r,c - 1,pre,res);
            dfs(grid,r,c + 1,pre,res);
            dfs(grid,r - 1,c,pre,res);
            dfs(grid,r + 1,c,pre,res);
            grid[r][c] = pre;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}