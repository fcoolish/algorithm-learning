//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 437 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

public class ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args){
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        int[] nums = new int[]{3,1,2};
        solution.getLeastNumbers(nums,2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int[] getLeastNumbers(int[] arr, int k) {
            int[] res = new int[k];
            quickSort(arr,0,arr.length - 1);
            for(int i =0;i < k;i++){
                res[i] = arr[i];
            }
            return res;
        }

        private void quickSort(int[] arr,int low,int high){
            if(low >= high){
                return;
            }
            int i = low,j =high,temp = 0;
            int base = arr[low];
            while(i < j){
                while(arr[j] >= base && i < j){
                    j--;
                }
                while(arr[i] <= base && i < j){
                    i++;
                }
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            arr[low] = arr[i];
            arr[i] = base;
            quickSort(arr,low,i - 1);
            quickSort(arr,i + 1,high);
        }

        public int[] getLeastNumbers2(int[] arr, int k) {
        PriorityQueue<Integer> deque = new PriorityQueue<>();
        int[] res = new int[k];
        for(int num:arr){
            deque.offer(num);
        }
        for(int i =0;i < k;i++){
            res[i] = deque.poll();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}