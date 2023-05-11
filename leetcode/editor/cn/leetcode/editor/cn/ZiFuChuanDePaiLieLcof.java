//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
//
// Related Topics 字符串 回溯 👍 679 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ZiFuChuanDePaiLieLcof{
    public static void main(String[] args){
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //回溯法
    public String[] permutation(String s) {
        int n = s.length();
        Set<String> ans = new HashSet<>();
        dfs(new StringBuilder(s),ans,n,0);
        return ans.toArray(new String[ans.size()]);
    }

    public void dfs(StringBuilder s,Set<String> ans,int n,int index){
        if(index == n){
            ans.add(new String(s));
            return;
        }
        for(int i = index;i < n;i++){
            char c = s.charAt(i);
            s.setCharAt(i,s.charAt(index));
            s.setCharAt(index,c);
            dfs(s,ans,n,index + 1);
            s.setCharAt(index, s.charAt(i));
            s.setCharAt(i,c);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}