//给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答
//案。
// 
//
// 示例 1： 
//
// 
//输入：words = ["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 由小写英文字母组成 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 264 👎 0

package leetcode.editor.cn;

import java.util.*;

public class FindCommonCharacters {
    public static void main(String[] args) {
        Solution solution = new FindCommonCharacters().new Solution();
        String[] str = new String[]{"ab","b"};
        solution.commonChars(str);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] words) {
            int[] minCount = new int[26];
            List<String> res = new ArrayList<>();
            Arrays.fill(minCount,Integer.MAX_VALUE);
            for(String str:words){
                int[] count = new int[26];
                for(int i =0;i < str.length();i++){
                    count[str.charAt(i) - 'a']++;
                }
                for(int i =0;i < 26;i++){
                    minCount[i] = Math.min(count[i],minCount[i]);
                }
            }
            for(int i = 0;i < 26;i++){
                for(int j =0;j < minCount[i];j++){
                    res.add(String.valueOf((char)(i + 'a')));
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}