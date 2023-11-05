//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
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
// Related Topics 字符串 动态规划 回溯 👍 1503 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PalindromePartitioning{
    public static void main(String[] args){
        Solution solution = new PalindromePartitioning().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<String>> partition1(String s) {
        int n = s.length();
        List<List<String>> res= new ArrayList<>();
        if(n == 0)return  res;
        Deque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        dfs(charArray,0,n,stack,res);
        return  res;
    }

    private void dfs(char[] charArray,int index,int n,Deque<String> deque,List<List<String>> ans){
        if(index == n){
            ans.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index;i < n;i++){
            if(!checkPalinedrome(charArray,index,i)){
                continue;
            }
            deque.addLast(new String(charArray,index,i + 1 - index));
            dfs(charArray,i + 1,n,deque,ans);
            deque.removeLast();
        }
    }

    private boolean checkPalinedrome(char[] charArray,int l,int r){
        while (l < r){
            if(charArray[l] != charArray[r]){
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