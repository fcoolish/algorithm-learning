//给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。 
//
// 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。 
//
// 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。 
//
// 返回词汇表 words 中你掌握的所有单词的 长度之和。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["cat","bt","hat","tree"], chars = "atach"
//输出：6
//解释： 
//可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
// 
//
// 示例 2： 
//
// 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//输出：10
//解释：
//可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length, chars.length <= 100 
// 所有字符串中都仅包含小写英文字母 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 154 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters{
    public static void main(String[] args){
        Solution solution = new FindWordsThatCanBeFormedByCharacters().new Solution();
        String[] words = new String[]{"cat","bt","hat","tree"};
        solution.countCharacters(words,"atach");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i < chars.length();i++){
           map.put(chars.charAt(i),map.getOrDefault(chars.charAt(i),0) + 1);
        }
        for(int i =0;i < words.length;i++){
            boolean match = true;
            Map<Character,Integer> count = new HashMap<>();
            for(int j =0;j < words[i].length();j++){
                count.put(words[i].charAt(j),count.getOrDefault(words[i].charAt(j),0)  +1);
            }
            for(Map.Entry<Character,Integer> entry:count.entrySet()){
                Character key = entry.getKey();
                int value  = entry.getValue();
                if(!map.containsKey(key) || (map.containsKey(key) && map.get(key) < value)){
                    match = false;
                    break;
                }
            }
            if (match){
                sum +=words[i].length();
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}