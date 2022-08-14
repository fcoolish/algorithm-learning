//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 👍 445 👎 0

package leetcode.editor.cn;
public class ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args){
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0){
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0,right = col - 1,top = 0,bottom = row- 1;
        int[] ans = new int[row * col];
        int index = 0;
        while(left <= right && top <= bottom){
            for(int i = left;i <= right;i++){
                ans[index++] = matrix[top][i];
            }
            for(int i = top + 1 ;i <= bottom;i++){
                ans[index++] = matrix[i][right];
            }
            if(left < right && top < bottom){
                for(int i = right - 1;i >= left ;i--){
                    ans[index++] = matrix[bottom][i];
                }
                for(int i = bottom - 1;i > top;i--){
                    ans[index++] = matrix[i][left];
                }
            }
            right--;
            top++;
            bottom--;
            left++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}