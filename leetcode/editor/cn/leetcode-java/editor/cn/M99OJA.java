//给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。 
//
// 
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "google"
//输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出：[["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// 
//
// 
// 注意：本题与主站 131 题相同： https://leetcode-cn.com/problems/palindrome-partitioning/ 
//
// Related Topics 深度优先搜索 广度优先搜索 图 哈希表 👍 58 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class M99OJA{
    public static void main(String[] args){
        Solution solution = new M99OJA().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[][] partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        int n = s.length();
        dfs(0,n,s,ans,new ArrayList<>());
        String[][] as = new String[ans.size()][];
        for(int i =0;i < ans.size();i++){
            as[i] = ans.get(i).toArray(new String[ans.get(i).size()]);
        }
        return as;
    }

    public void dfs(int index,int n,String s,List<List<String>> ans,List<String> list){
        if(index == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i < n;i++){
            String ss = s.substring(index,i + 1);
            if(check(ss)){
                list.add(ss);
                dfs(i + 1,n,s,ans,list);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean check(String ss){
        if(ss.length() == 1)return true;
        int l = 0,r = ss.length() - 1;
        while (l < r){
            if(ss.charAt(l )!= ss.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}