//在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，输入这样的一个二
//维数组和一个整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
//
// Related Topics 数组 二分查找 分治 矩阵 👍 945 👎 0

package leetcode.editor.cn;
public class ErWeiShuZuZhongDeChaZhaoLcof{
    public static void main(String[] args){
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target){
        if(matrix.length == 0) return false;
        int m = matrix.length;
        int i = 0,j = matrix[0].length - 1;
        while (i < m && j >= 0){
            if (matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        for(int i = 0;i < matrix.length;i++){
            if(matrix[i].length == 0)continue;
            if(matrix[i][0] > target || matrix[i][matrix[i].length - 1] < target)continue;
            if(binarySearch(matrix[i],target)){
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[] nums,int target){
        if(nums.length == 0)return false;
        int l = 0,r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}