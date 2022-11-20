//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 位运算 哈希表 字符串 👍 95 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutationLcci{
    public static void main(String[] args){
        Solution solution = new PalindromePermutationLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null)return true;
        Map<Character,Integer> map = new HashMap<>();
        int count = 0;
        for(int i =0;i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for(Integer value:map.values()){
            count =count +  value % 2;
            if(count > 1){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}