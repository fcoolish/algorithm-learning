//有 N 位扣友参加了微软与力扣举办了「以扣会友」线下活动。主办方提供了 2*N 道题目，整型数组 questions 中每个数字对应了每道题目所涉及的知识点类型。
//        若每位扣友选择不同的一题，请返回被选的 N 道题目至少包含多少种知识点类型。
//
//        示例 1：
//
//        输入：questions = [2,1,6,2]
//
//        输出：1
//
//        解释：有 2 位扣友在 4 道题目中选择 2 题。
//        可选择完成知识点类型为 2 的题目时，此时仅一种知识点类型
//        因此至少包含 1 种知识点类型。
//
// Related Topics 数组 矩阵 模拟 
// 👍 305 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HalfQuestions {
    public static void main(String[] args){
        Solution solution = new HalfQuestions().new Solution();
        int[] num = new int[]{2,1,6,2};
        solution.halfQuestions(num);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int halfQuestions(int[] questions) {
            int n = questions.length;
            int[] arr = new int[1001];
            for(int i =0;i < n;i++){
                arr[questions[i]]++;
            }
            Arrays.sort(arr);
            int res = 0,sum = 0;
            for(int i =1000;i >=0;i--){
                if(sum < n/2){
                    sum +=arr[i];
                    res++;
                }else{
                    break;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}