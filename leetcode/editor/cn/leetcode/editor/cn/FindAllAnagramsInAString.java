//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1157 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString{
    public static void main(String[] args){
        Solution solution = new FindAllAnagramsInAString().new Solution();
        solution.findAnagrams("cbaebabacd","abc");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<Integer> findAnagrams(String s, String p){
        int sl = s.length();
        int pl = p.length();
        List<Integer> ans = new ArrayList<>();
        if(sl < pl){
            return ans;
        }
        int[] sc = new int[26];
        int[] pc = new int[26];
        for(int i = 0;i < pl;i++){
            sc[s.charAt(i) - 'a']++;
            pc[p.charAt(i) - 'a']++;
        }
        if(Arrays.equals(sc,pc)){
            ans.add(0);
        }
        for(int i =0;i < sl - pl;i++){
            sc[s.charAt(i) - 'a']--;
            sc[s.charAt(i + pl) - 'a']++;
            if(Arrays.equals(sc,pc)){
                ans.add(i + 1);
            }
        }
        return ans;
    }
    public List<Integer> findAnagrams1(String s, String p) {
        char[] charp = p.toCharArray();
        Arrays.sort(charp);
        String np = new String(charp);
        List<Integer> ans = new ArrayList<>();
        int pl = p.length();
        int sl = s.length();
        for(int i = 0;i <= sl - pl;i++){
            String str = s.substring(i,i + pl);
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String ns = new String(chars);
            if(ns.equals(np)){
                ans.add(i);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}