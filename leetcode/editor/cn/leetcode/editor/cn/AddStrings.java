//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
// Related Topics 数学 字符串 模拟 👍 642 👎 0

package leetcode.editor.cn;
public class AddStrings{
    public static void main(String[] args){
        Solution solution = new AddStrings().new Solution();
        solution.addStrings("9","99");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String addStrings(String num1, String num2) {
            int l1 = num1.length() - 1;
            int l2 = num2.length() - 1;
            StringBuilder ans = new StringBuilder();
            int temp = 0;
            while (l1 >= 0 || l2 >= 0 || temp > 0){
                int n1 = l1 >= 0 ?num1.charAt(l1) - '0':0;
                int n2 = l2 >= 0 ?num2.charAt(l2) - '0':0;
                int sum = n1 + n2 + temp;
                ans.insert(0,sum % 10);
                temp = sum /10;
                l1--;
                l2--;
            }
            return ans.toString();
        }

        public String addStrings2(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        int temp = 0,x = l1,y = l2;
        while (x >= 0 & y >= 0){
            int n1 = num1.charAt(x) - '0';
            int n2 = num2.charAt(y) - '0';
            int sum = n1 + n2 + temp;
            if(sum <= 9){
                ans.insert(0,sum);
                x--;
                y--;
                temp = 0;
            }else{
                int diff = sum - 10;
                temp = 1;
                ans.insert(0,diff);
                x--;
                y--;
            }
        }
        while (x >= 0){
            int num = num1.charAt(x) - '0';
            int sum = num + temp;
            if(sum <= 9){
                ans.insert(0,sum);
                x--;
                temp = 0;
            }else{
                int diff = sum - 10;
                temp = 1;
                ans.insert(0,diff);
                x--;
            }
        }
        while (y >= 0){
            int num = num2.charAt(y) - '0';
            int sum = num + temp;
            if(sum <= 9){
                ans.insert(0,sum);
                y--;
                temp = 0;
            }else{
                int diff = sum - 10;
                temp = 1;
                ans.insert(0,diff);
                y--;
            }
        }
        if(temp > 0){
            ans.insert(0,temp);
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}