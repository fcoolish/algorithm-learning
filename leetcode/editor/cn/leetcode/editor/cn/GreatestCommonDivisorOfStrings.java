//对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。 
//
// 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 X 能除尽 str2 。 
//
// 
//
// 示例 1： 
//
// 
//输入：str1 = "ABCABC", str2 = "ABC"
//输出："ABC"
// 
//
// 示例 2： 
//
// 
//输入：str1 = "ABABAB", str2 = "ABAB"
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：str1 = "LEET", str2 = "CODE"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= str1.length, str2.length <= 1000 
// str1 和 str2 由大写英文字母组成 
// 
// Related Topics 数学 字符串 👍 249 👎 0

package leetcode.editor.cn;
public class GreatestCommonDivisorOfStrings{
    public static void main(String[] args){
        Solution solution = new GreatestCommonDivisorOfStrings().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        for(int i = Math.min(len1,len2);i >=1;i--){
            if(len1 %  i== 0 && len2 % i == 0){
                String str = str1.substring(0,i);
                if(isCheck(str,str1) && isCheck(str,str2)){
                    return str;
                }
            }
        }
        return "";
    }

    private boolean isCheck(String x,String a){
        int lenx = a.length() / x.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i <= lenx;i++){
            sb.append(x);
        }
        return sb.toString().equals(a);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}