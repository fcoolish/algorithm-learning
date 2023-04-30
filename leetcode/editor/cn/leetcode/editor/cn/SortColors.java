//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1577 👎 0

package leetcode.editor.cn;
public class SortColors{
    public static void main(String[] args){
        Solution solution = new SortColors().new Solution();
        int[] arr = {2,0,2,1,1,0};
        solution.sortColors(arr);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public void sortColors(int[] nums) {
        int p0 = 0,p1 = 0;
        for(int i =0;i < nums.length;i++){
            if(nums[i] == 1){
                int temp= nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            }else if(nums[i] == 0){
                int temp= nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if(p0 < p1){
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                p1++;
                p0++;
            }
        }
    }
    public void sortColors1(int[] nums) {
        quickSort(nums,0,nums.length - 1);
    }

    public void quickSort(int[] nums,int low,int high){
            if(low >=high)return;
            int temp,i,j;
            int base = nums[low];
            i = low;
            j = high;
            while (i < j){
                while(nums[j] >= base && i <j){
                    j--;
                }
                while(nums[i] <= base && i <j){
                    i++;
                }
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            nums[low] = nums[i];
            nums[i] = base;
            quickSort(nums,low,i - 1);
            quickSort(nums,i + 1,high);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}