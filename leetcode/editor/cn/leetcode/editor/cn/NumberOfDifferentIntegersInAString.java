//给你一个字符串 word ，该字符串由数字和小写英文字母组成。 
//
// 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123 34 8 34" 。注意，剩下的这些整数为（相邻彼此至少有
//一个空格隔开）："123"、"34"、"8" 和 "34" 。 
//
// 返回对 word 完成替换后形成的 不同 整数的数目。 
//
// 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "a123bc34d8ef34"
//输出：3
//解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
// 
//
// 示例 2： 
//
// 
//输入：word = "leet1234code234"
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：word = "a1b01c001"
//输出：1
//解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 1000 
// word 由数字和小写英文字母组成 
// 
// Related Topics 哈希表 字符串 👍 84 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDifferentIntegersInAString{
    public static void main(String[] args){
        Solution solution = new NumberOfDifferentIntegersInAString().new Solution();
        solution.numDifferentIntegers("0a0");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int l = word.length();
        StringBuilder dig = new StringBuilder();
        for(int i =0;i <= l;i++){
            if(i < l && Character.isDigit(word.charAt(i))){
                dig.append(word.charAt(i));
                while(dig.length() > 1 && dig.charAt(0) == '0' ){
                    dig.deleteCharAt(0);
                }
            }else if(dig.length() > 0){
                set.add(dig.toString());
                dig.delete(0,dig.length());
            }
        }
        return set.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}