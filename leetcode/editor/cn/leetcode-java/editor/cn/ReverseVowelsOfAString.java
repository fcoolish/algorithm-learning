//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 271 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        solution.reverseVowels("A man, a plan, a canal: Panama");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            int l =0,r = chars.length - 1;
            String str = "AOEIUaoeiu";
            while (l < r){
                while (l < r && !str.contains(String.valueOf(chars[l]))){
                    l++;
                }
                while (l< r && !str.contains(String.valueOf(chars[r]))){
                    r--;
                }
                if(chars[l] != chars[r]){
                    char ch = chars[l];
                    chars[l] = chars[r];
                    chars[r] = ch;
                }
                l++;
                r--;
            }
            return new String(chars);
        }

        public String reverseVowels2(String s) {
            char[] chars = s.toCharArray();
            String str = "AOEIUaoeiu";
            List<Integer> index = new ArrayList<>();
            StringBuilder letter = new StringBuilder();
            for(int i =0;i < s.length();i++){
                if(str.contains(String.valueOf(s.charAt(i)))){
                    letter.append(s.charAt(i));
                    index.add(0,i);
                }
            }
            if(letter.length() <= 1)return s;
            for(int i =0;i < letter.length();i++){
                chars[index.get(i)] = letter.charAt(i);
            }
            return new String(chars);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}