//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2478 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring{
    public static void main(String[] args){
        Solution solution = new MinimumWindowSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Map<Character,Integer> tmap = new HashMap<>();
    Map<Character,Integer> smap = new HashMap<>();
    public String minWindow(String s, String t) {
        int sl = s.length(),tl = t.length();
        for(int i =0;i < tl;i++){
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0) + 1);
        }
        int ansL = -1,ansR = -1;
        int len = Integer.MAX_VALUE;
        int l = 0,r = 0;
        while (r < sl){
            if(r < sl && tmap.containsKey(s.charAt(r))){
                smap.put(s.charAt(r),smap.getOrDefault(s.charAt(r),0) + 1);
            }
            while (check() && l <= r){
                if(r - l + 1< len){
                    len = r - l + 1;
                    ansL = l;
                    ansR = r + 1;
                }
                if(tmap.containsKey(s.charAt(l))){
                    smap.put(s.charAt(l),smap.getOrDefault(s.charAt(l),0) - 1);
                }
                l++;
            }
            r++;
        }
        return ansL == -1 ? "":s.substring(ansL,ansR);
    }

    private boolean check(){
        for(Map.Entry<Character,Integer> entry:tmap.entrySet()){
            if(smap.getOrDefault(entry.getKey(),0) < entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}