//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1091 👎 0

package leetcode.editor.cn;

public class SpiralMatrixIi{
    public static void main(String[] args){
        Solution solution = new SpiralMatrixIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        if(n < 1)return null;
        int[][] grid = new int[n][n];
        int index = 1;
        int top = 0,bottom = n - 1,left = 0,right = n - 1;
        while (left <= right && top <= bottom){
            for(int i=  left;i <= right;i++){
                grid[top][i] = index;
                index++;
            }
            for(int i=  top + 1;i <= bottom;i++){
                grid[i][right] = index;
                index++;
            }
            if(left < right && top < bottom){
                for(int i=  right - 1;i >= left;i--){
                    grid[bottom][i] = index;
                    index++;
                }
                for(int i=  bottom - 1;i > top;i--){
                    grid[i][left] = index;
                    index++;
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return grid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}