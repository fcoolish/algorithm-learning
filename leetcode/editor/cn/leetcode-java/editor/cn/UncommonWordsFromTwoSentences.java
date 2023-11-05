//句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。 
//
// 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。 
//
// 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s1 = "this apple is sweet", s2 = "this apple is sour"
//输出：["sweet","sour"]
// 
//
// 示例 2： 
//
// 
//输入：s1 = "apple apple", s2 = "banana"
//输出：["banana"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 200 
// s1 和 s2 由小写英文字母和空格组成 
// s1 和 s2 都不含前导或尾随空格 
// s1 和 s2 中的所有单词间均由单个空格分隔 
// 
// Related Topics 哈希表 字符串 👍 166 👎 0

package leetcode.editor.cn;

import java.util.*;

public class UncommonWordsFromTwoSentences{
    public static void main(String[] args){
        Solution solution = new UncommonWordsFromTwoSentences().new Solution();
        solution.uncommonFromSentences("apple apple", "banana");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> ans = new ArrayList<>();
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for (String str:arr1){
            map.put(str, map.getOrDefault(str,0) + 1);
        }
        for (String str:arr2){
            map.put(str,map.getOrDefault(str,0) + 1);
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue() == 1){
                ans.add(entry.getKey());
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}