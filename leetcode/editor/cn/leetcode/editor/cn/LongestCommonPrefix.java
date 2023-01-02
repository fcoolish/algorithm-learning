//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 2590 👎 0

package leetcode.editor.cn;

public class LongestCommonPrefix{
    public static void main(String[] args){
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] sts = {"a"};
        solution.longestCommonPrefix(sts);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min = 201;
        for(String str:strs){
            min = Math.min(min,str.length());
        }
        String ans = "";
        int l = strs.length;
        for(int i= 1 ;i <= min;i++){
            boolean match = true;
            String str = strs[0].substring(0,i);
            for(int j= 0;j < l;j++){
                if(!strs[j].substring(0,i).equals(str)){
                    match = false;
                    break;
                }
            }
            if(match){
                ans = str;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}