//给你一个数字数组 arr 。 
//
// 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。 
//
// 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,5,1]
//输出：true
//解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,4]
//输出：false
//解释：无法通过重新排序得到等差数列。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 1000 
// -10^6 <= arr[i] <= 10^6 
// 
// Related Topics 数组 排序 
// 👍 23 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CanMakeArithmeticProgressionFromSequence {
    public static void main(String[] args) {
        Solution solution = new CanMakeArithmeticProgressionFromSequence().new Solution();
        int[] arr = new int[]{3, 5, 1};
        //solution.canMakeArithmeticProgression(arr);
        solution.quickSort(arr, 0, arr.length - 1);
        System.out.println("");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
            int n = arr[1] - arr[0];
            for (int i = 2; i < arr.length; i++) {
                if ((arr[i] - arr[i - 1]) != n) {
                    return false;
                }
            }
            return true;
        }

        private void quickSort(int[] arr, int left, int right) {
            if (left >= right) return;
            int i = left, j = right, temp = 0;
            int base = arr[left];
            while (i < j) {
                while (arr[j] >= base && i < j) {
                    j--;
                }
                while (arr[i] <= base && i < j) {
                    i++;
                }
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            arr[left] = arr[i];
            arr[i] = base;
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)
    public boolean canMakeArithmeticProgression2(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);
        int m = list.get(1) - list.get(0);
        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) != m) {
                return false;
            }
        }
        return true;
    }

}