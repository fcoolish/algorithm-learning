//给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。 
//
// 完成所有替换操作后，请你返回这个数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [17,18,5,4,6,1]
//输出：[18,6,6,6,1,-1]
//解释：
//- 下标 0 的元素 --> 右侧最大元素是下标 1 的元素 (18)
//- 下标 1 的元素 --> 右侧最大元素是下标 4 的元素 (6)
//- 下标 2 的元素 --> 右侧最大元素是下标 4 的元素 (6)
//- 下标 3 的元素 --> 右侧最大元素是下标 4 的元素 (6)
//- 下标 4 的元素 --> 右侧最大元素是下标 5 的元素 (1)
//- 下标 5 的元素 --> 右侧没有其他元素，替换为 -1
// 
//
// 示例 2： 
//
// 
//输入：arr = [400]
//输出：[-1]
//解释：下标 0 的元素右侧没有其他元素。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 104 
// 1 <= arr[i] <= 105 
// 
// Related Topics 数组 
// 👍 74 👎 0

package leetcode.editor.cn;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public static void main(String[] args) {
        Solution solution = new ReplaceElementsWithGreatestElementOnRightSide().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] replaceElements(int[] arr) {
            int length = arr.length;
            int[] res = new int[length];
            res[length - 1] = -1;
            for (int i = length - 2; i >= 0; i--) {
                res[i] = Math.max(res[i + 1], arr[i + 1]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}