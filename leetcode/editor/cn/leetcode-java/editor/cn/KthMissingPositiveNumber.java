//给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。 
//
// 请你找到这个数组里第 k 个缺失的正整数。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [2,3,4,7,11], k = 5
//输出：9
//解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,3,4], k = 2
//输出：6
//解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 1 <= arr[i] <= 1000 
// 1 <= k <= 1000 
// 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j] 
// 
// Related Topics 数组 二分查找 👍 112 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class KthMissingPositiveNumber{
    public static void main(String[] args){
        Solution solution = new KthMissingPositiveNumber().new Solution();
        int[] nums = new int[]{1,2,3,4};
        solution.findKthPositive(nums,2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int findKthPositive1(int[] arr, int k) {
            List<Integer> list = new ArrayList<>();
            int n = arr.length;
            for (int num : arr) {
                list.add(num);
            }
            for(int i = 1;i < Integer.MAX_VALUE;i++){
                if(!list.contains(i)){
                    k--;
                    if(0 == k)return i;
                }
            }
            return -1;
        }

        public int findKthPositive2(int[] arr, int k) {
            boolean[] map = new boolean[2022];
            for (int num : arr) {
                map[num] = true;
            }
            for(int i =1;i < 2022;i++){
                if(!map[i]){
                    k--;
                    if(0 == k)return i;
                }
            }
            return -1;
        }

        public int findKthPositive(int[] arr, int k) {
        int index = 1,count = 0;
        int n = arr.length;
        for(int num:arr){
            while (index !=num){
                count++;
                if(count == k){
                    return index;
                }
                index++;
            }
            index++;
        }
        return k > count ? (arr[n - 1]+k - count):index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}