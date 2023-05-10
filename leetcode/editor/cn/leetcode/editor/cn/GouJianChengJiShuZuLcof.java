//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
//
// Related Topics 数组 前缀和 👍 320 👎 0

package leetcode.editor.cn;
public class GouJianChengJiShuZuLcof{
    public static void main(String[] args){
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
        int[] arr = {1, 2, 3, 4, 5};
        solution.constructArr(arr);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
        if(a == null || a.length == 0)return new int[]{};
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for(int i = 1;i < n;i++){
            left[i] = a[i - 1] * left[i - 1];
        }
        right[n - 1] = 1;
        for(int i = n - 2;i >= 0;i--){
            right[i] = a[i + 1] * right[i + 1];
        }
        int[] ans = new int[n];
        for(int i = 0;i < n;i++){
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}