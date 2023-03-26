//给你一个下标从 0 开始的字符串数组 words 。 
//
// 如果两个字符串由相同的字符组成，则认为这两个字符串 相似 。 
//
// 
// 例如，"abca" 和 "cba" 相似，因为它们都由字符 'a'、'b'、'c' 组成。 
// 然而，"abacba" 和 "bcfd" 不相似，因为它们不是相同字符组成的。 
// 
//
// 请你找出满足字符串 words[i] 和 words[j] 相似的下标对 (i, j) ，并返回下标对的数目，其中 0 <= i < j <= word.
//length - 1 。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["aba","aabb","abcd","bac","aabc"]
//输出：2
//解释：共有 2 对满足条件：
//- i = 0 且 j = 1 ：words[0] 和 words[1] 只由字符 'a' 和 'b' 组成。 
//- i = 3 且 j = 4 ：words[3] 和 words[4] 只由字符 'a'、'b' 和 'c' 。 
// 
//
// 示例 2： 
//
// 输入：words = ["aabb","ab","ba"]
//输出：3
//解释：共有 3 对满足条件：
//- i = 0 且 j = 1 ：words[0] 和 words[1] 只由字符 'a' 和 'b' 组成。 
//- i = 0 且 j = 2 ：words[0] 和 words[2] 只由字符 'a' 和 'b' 组成。 
//- i = 1 且 j = 2 ：words[1] 和 words[2] 只由字符 'a' 和 'b' 组成。 
// 
//
// 示例 3： 
//
// 输入：words = ["nba","cba","dba"]
//输出：0
//解释：不存在满足条件的下标对，返回 0 。 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 哈希表 字符串 👍 13 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class CountPairsOfSimilarStrings{
    public static void main(String[] args){
        Solution solution = new CountPairsOfSimilarStrings().new Solution();
        String[] strs = {"abcd","aabc"};
        solution.similarPairs(strs);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int similarPairs(String[] words) {
        int res = 0;
        int n = words.length;
        for(int i = 0;i < n - 1;i++){
            for (int j = i + 1;j < n;j++){
                if(checkStr(words[i],words[j])){
                    res++;
                }
            }
        }
        return res;
    }

    public boolean checkStr(String a,String b){
        boolean[] cnt = new boolean[27];
        Set<Character> set = new HashSet<>();
        for(int i  = 0;i < a.length();i++){
            cnt[a.charAt(i) - 'a'] = true;
            set.add(a.charAt(i));
        }
        for(int i  = 0;i < b.length();i++){
            if(!cnt[b.charAt(i) - 'a']){
                return false;
            }
            set.remove(b.charAt(i));
        }
        return set.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}