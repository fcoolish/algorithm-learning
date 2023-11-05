//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 
// 👍 709 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        solution.generate(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> lists = new LinkedList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> temp = new LinkedList<>();
                for (int j = 0; j <= i; j++) {
                    int num = 0;
                    if (j == 0 || i == j) {
                        num = 1;
                    } else {
                        num = lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j);
                    }
                    temp.add(num);
                }
                lists.add(temp);
            }
            return lists;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}