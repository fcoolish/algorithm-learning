//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 哈希表 字符串 排序 👍 752 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class ValidAnagram{
    public static void main(String[] args){
        Solution solution = new ValidAnagram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public boolean isAnagram(String s, String t){
        if(s.length() != t.length())return false;
        char[] sc = s.toCharArray();
        char[] st = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(st);
        return new String(sc).equals(new String(st));
    }
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length())return false;
        int[] cnt = new int[26];
        int len = s.length();
        for(int i =0;i < len ;i++){
            cnt[s.charAt(i) - 'a']++;
            cnt[t.charAt(i) - 'a']--;
        }
        for(int i =0;i < 26;i++){
            if(cnt[i] != 0){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}