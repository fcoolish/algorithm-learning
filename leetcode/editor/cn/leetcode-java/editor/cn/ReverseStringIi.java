//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
// Related Topics 双指针 字符串 👍 371 👎 0

package leetcode.editor.cn;
public class ReverseStringIi{
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new ReverseStringIi().new Solution();
        solution.reverseStr("abcdefg",2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();
            int l = s.length();
            for(int i =0;i < l;i+=2 *k){
                int right = Math.min(i + k,l) - 1;
                int left = i;
                while (left < right){
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                    right--;
                }
            }
            return new String(chars);
        }

        public String reverseStr2(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int l = s.length();
        for(int i =0;i < l;i+=2 *k){
            int start = i;
            int end = Math.min(l,start + k);
            for(int j = end - 1;j >= start;j--){
                ans.append(s.charAt(j));
            }
            for(int m = end;m < Math.min(end + k,l);m++){
                ans.append(s.charAt(m));
            }
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}