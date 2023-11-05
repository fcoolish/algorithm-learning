//给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 
//
// 请你统计并返回 grid 中 负数 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//输出：8
//解释：矩阵中共有 8 个负数。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[3,2],[1,0]]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,-1],[-1,-1]]
//输出：3
// 
//
// 示例 4： 
//
// 
//输入：grid = [[-1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// -100 <= grid[i][j] <= 100 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？ 
//
// 
// Related Topics 数组 二分查找 矩阵 
// 👍 87 👎 0

package leetcode.editor.cn;
public class CountNegativeNumbersInASortedMatrix{
    public static void main(String[] args){
        Solution solution = new CountNegativeNumbersInASortedMatrix().new Solution();
        int[][] grid = new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        solution.countNegatives(grid);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0;int m = grid.length,n = grid[0].length;
        for(int i =0;i < m;i++){
            res += binarySearch(grid[i],0,n);
        }
        return res;
    }

    private int binarySearch(int[] nums,int l,int r){
        while(l < r){
            int mid = (l + r) /2;
            if(nums[mid] < 0){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return nums.length - l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}