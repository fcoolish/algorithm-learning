//给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。 
//
// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：text = "nlaebolko"
//输出：1
// 
//
// 示例 2： 
//
// 
//
// 输入：text = "loonbalxballpoon"
//输出：2
// 
//
// 示例 3： 
//
// 输入：text = "leetcode"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^4 
// text 全部由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 👍 116 👎 0

package leetcode.editor.cn;
public class MaximumNumberOfBalloons{
    public static void main(String[] args){
        Solution solution = new MaximumNumberOfBalloons().new Solution();
        solution.maxNumberOfBalloons("ballon");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfBalloons(String text) {
        String str = "balon";
        int[] map = new int[26];
        for(int i = 0;i < text.length();i++){
            map[text.charAt(i) - 'a']++;
        }
        int ans = -1;
        for(int i = 0;i < str.length();i++){
            int num = map[str.charAt(i) - 'a'];
            if(str.charAt(i) == 'l' || str.charAt(i) == 'o'){
                num = num / 2;
            }
            if(ans == -1){
                ans = num;
            }else{
                ans = Math.min(ans,num);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}