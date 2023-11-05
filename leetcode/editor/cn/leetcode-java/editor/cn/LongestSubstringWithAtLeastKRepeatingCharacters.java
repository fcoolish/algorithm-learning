//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文字母组成 
// 1 <= k <= 10⁵ 
// 
//
// Related Topics 哈希表 字符串 分治 滑动窗口 👍 819 👎 0

package leetcode.editor.cn;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestSubstring(String s, int k){
            int n = s.length();
            int max = 0;
            for(int t = 1;t <= 26;t++){
                char[] cnt = new char[26];
                int l = 0,r = 0;
                int sum = 0,tot = 0;
                while (r < n){
                    cnt[s.charAt(r) - 'a']++;
                    if(cnt[s.charAt(r) - 'a'] == 1)tot++;
                    if(cnt[s.charAt(r) - 'a'] == k)sum++;
                    while (t < tot){
                        cnt[s.charAt(l) - 'a']--;
                        if(cnt[s.charAt(l) - 'a'] == 0)tot--;
                        if(cnt[s.charAt(l) - 'a'] == k - 1)sum--;
                        l++;
                    }
                    if(sum == tot){
                        max = Math.max(max,r - l + 1);
                    }
                    r++;
                }

            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}