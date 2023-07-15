//有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。 
//
// 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。 
//
// 
//
// 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。 
//
// 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。 
//
// 请返回待替换子串的最小可能长度。 
//
// 如果原字符串自身就是一个平衡字符串，则返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "QWER"
//输出：0
//解释：s 已经是平衡的了。 
//
// 示例 2： 
//
// 
//输入：s = "QQWE"
//输出：1
//解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
// 
//
// 示例 3： 
//
// 
//输入：s = "QQQW"
//输出：2
//解释：我们可以把前面的 "QQ" 替换成 "ER"。 
// 
//
// 示例 4： 
//
// 
//输入：s = "QQQQ"
//输出：3
//解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s.length 是 4 的倍数 
// s 中只含有 'Q', 'W', 'E', 'R' 四种字符 
// 
//
// Related Topics 字符串 滑动窗口 👍 245 👎 0

package leetcode.editor.cn;
public class ReplaceTheSubstringForBalancedString{
    public static void main(String[] args){
        Solution solution = new ReplaceTheSubstringForBalancedString().new Solution();
        solution.balancedString("QQWE");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int balancedString(String s) {
     int[] cnt = new int[4];
     String t = "QWER";
     int n = s.length();
     for(int i =0;i <n;i++){
         cnt[t.indexOf(s.charAt(i))]++;
     }
     int m = n/4;
     if(cnt[0] == m && cnt[1] == m && cnt[2] == m && cnt[3] == m){
         return 0;
     }
     int ans = n;
     for(int i =0,j = 0;i < n;i++){
        cnt[t.indexOf(s.charAt(i))]--;
        while (j <= i && cnt[0] <= m && cnt[1] <= m && cnt[2] <= m && cnt[3] <= m){
            ans = Math.min(ans,i - j + 1);
            cnt[t.indexOf(s.charAt(j++))]++;
        }
     }
     return ans;
    }}
//leetcode submit region end(Prohibit modification and deletion)

}