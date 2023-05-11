//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 633 👎 0

package leetcode.editor.cn;
public class JiQiRenDeYunDongFanWeiLcof{
    public static void main(String[] args){
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        solution.movingCount(16,8,4);
        int[][] grid = new int[2][3];

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int ans = 0;
    public int movingCount(int m, int n, int k) {
        int[][] grid = new int[m][n];
        dfs(grid,m,n,0,0,k);
        return ans;
    }

    public void dfs(int[][] grid,int m,int n,int x,int y,int k){
        if(x < 0 || x >= m || y < 0 || y >= n || !isMatch(grid,x,y,k)){
            return;
        }
        ans++;
        grid[x][y] = k + 1;
        dfs(grid,m,n,x + 1,y,k);
        dfs(grid,m,n,x,y + 1,k);
    }

    public boolean isMatch(int[][] grid,int x,int y,int k){
        if(grid[x][y] > k) return false;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(x).append(y);
        for(int i =0;i < sb.length();i++){
            sum =sum +  sb.charAt(i) - '0';
        }
        return sum <= k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}