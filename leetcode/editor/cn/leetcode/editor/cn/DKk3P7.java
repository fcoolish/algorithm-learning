//给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。 
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
// 示例 3: 
//
// 
//输入: s = "a", t = "a"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s and t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// 
//
// 注意：本题与主站 242 题相似（字母异位词定义不同）：https://leetcode-cn.com/problems/valid-anagram/ 
// Related Topics 哈希表 字符串 排序 👍 33 👎 0

package leetcode.editor.cn;
public class DKk3P7{
    public static void main(String[] args){
        Solution solution = new DKk3P7().new Solution();
        solution.isAnagram("nl","cx");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int l = s.length();
        boolean match = true;
        for(int i =0;i < l;i++){
            if(s.charAt(i) != t.charAt(i)){
                match = false;
            }
        }
        if(match)return false;
        int[] arr = new int[26];
        for(int i =0;i < l;i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int i =0;i < 26;i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}