//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针 排序 👍 143 👎 0

package leetcode.editor.cn;

public class SortedMergeLcci {
    public static void main(String[] args) {
        Solution solution = new SortedMergeLcci().new Solution();
        int[] num = new int[]{1,2,3,0,0,0};
        int[] num2 = new int[]{2,5,6};
        solution.merge(num,3,num2,3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int i = m - 1,j = n - 1;
            while(i >=0 && j >=0){
                if(A[i] > B[j]){
                    A[i + j + 1] = A[i];
                    i--;
                }else{
                    A[i + j + 1] = B[j];
                    j--;
                }
            }
            while (j >=0){
                A[j] = B[j];
                j--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}