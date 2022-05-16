//给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。 
//
// 注意：请不要在超过该数组长度的位置写入元素。 
//
// 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。 
//
// 
//
// 示例 1： 
//
// 输入：[1,0,2,3,0,4,5,0]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
// 
//
// 示例 2： 
//
// 输入：[1,2,3]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10000 
// 0 <= arr[i] <= 9 
// 
// Related Topics 数组 双指针 👍 118 👎 0

package leetcode.editor.cn;
public class DuplicateZeros{
    public static void main(String[] args){
        Solution solution = new DuplicateZeros().new Solution();
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        solution.duplicateZeros(arr);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public void duplicateZeros(int[] arr) {
            int n = arr.length,count = 0;
            for(int i =0;i < n;i++){
                if(arr[i] == 0){
                    count++;
                }
            }
            for(int j = n - 1;j >=0;j--){
                if(arr[j] == 0){
                    count--;
                    continue;
                }
                int newIndex = j + count;
                if(newIndex < n){
                    arr[newIndex] = arr[j];
                }
                if(newIndex > j){//说明发生了移动
                    arr[j] = 0;
                }
            }
            return;
        }

        public void duplicateZeros2(int[] arr) {
        int n = arr.length;
        for(int i =0;i < n;i++){
            if(arr[i] == 0){
                for(int j = n - 1;j >= i + 1;j--){
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}