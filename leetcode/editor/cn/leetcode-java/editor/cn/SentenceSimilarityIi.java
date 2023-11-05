//我们可以将一个句子表示为一个单词数组，例如，句子 I am happy with leetcode"可以表示为 arr = ["I","am",
//happy","with","leetcode"] 
//
// 给定两个句子 sentence1 和 sentence2 分别表示为一个字符串数组，并给定一个字符串对 similarPairs ，其中 
//similarPairs[i] = [xi, yi] 表示两个单词 xi 和 yi 是相似的。 
//
// 如果 sentence1 和 sentence2 相似则返回 true ，如果不相似则返回 false 。 
//
// 两个句子是相似的，如果: 
//
// 
// 它们具有 相同的长度 (即相同的字数) 
// sentence1[i] 和 sentence2[i] 是相似的 
// 
//
// 请注意，一个词总是与它自己相似，也请注意，相似关系是可传递的。例如，如果单词 a 和 b 是相似的，单词 b 和 c 也是相似的，那么 a 和 c 也是 
//相似 的。 
//
// 
//
// 示例 1: 
//
// 
//输入: sentence1 = ["great","acting","skills"], sentence2 = ["fine","drama",
//"talent"], similarPairs = [["great","good"],["fine","good"],["drama","acting"],[
//"skills","talent"]]
//输出: true
//解释: 这两个句子长度相同，每个单词都相似。
// 
//
// 示例 2: 
//
// 
//输入: sentence1 = ["I","love","leetcode"], sentence2 = ["I","love","onepiece"], 
//similarPairs = [["manga","onepiece"],["platform","anime"],["leetcode",
//"platform"],["anime","manga"]]
//输出: true
//解释: "leetcode" --> "platform" --> "anime" --> "manga" --> "onepiece".
//因为“leetcode”和“onepiece”相似，而且前两个单词是相同的，所以这两句话是相似的。 
//
// 示例 3: 
//
// 
//输入: sentence1 = ["I","love","leetcode"], sentence2 = ["I","love","onepiece"], 
//similarPairs = [["manga","hunterXhunter"],["platform","anime"],["leetcode",
//"platform"],["anime","manga"]]
//输出: false
//解释: “leetcode”和“onepiece”不相似。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= sentence1.length, sentence2.length <= 1000 
// 1 <= sentence1[i].length, sentence2[i].length <= 20 
// sentence1[i] 和 sentence2[i] 只包含大小写英文字母 
// 0 <= similarPairs.length <= 2000 
// similarPairs[i].length == 2 
// 1 <= xi.length, yi.length <= 20 
// xi 和 yi 只含英文字母 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 哈希表 字符串 👍 70 👎 0

package leetcode.editor.cn;

import java.util.*;

public class SentenceSimilarityIi{
    public static void main(String[] args){
        Solution solution = new SentenceSimilarityIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length)return  false;
        Map<String,List<String>> graph = new HashMap<>();
        for(List<String> pair:similarPairs){
            for(String p:pair){
                if(!graph.containsKey(p)){
                    graph.put(p,new ArrayList<>());
                }
                graph.getOrDefault(pair.get(0),new ArrayList<>()).add(pair.get(1));
                graph.getOrDefault(pair.get(1),new ArrayList<>()).add(pair.get(0));
            }
        }
        for(int i = 0;i < sentence1.length;i++){
            String s1 = sentence1[i],s2 = sentence2[i];
            Stack<String> stack = new Stack<>();
            Set<String> seen = new HashSet<>();
            stack.push(s1);
            seen.add(s1);
            search:{
                while (!stack.isEmpty()){
                    String word = stack.pop();
                    if(word.equals(s2))break search;
                    if(graph.containsKey(word)){
                        for(String nei:graph.get(word)){
                            if(!seen.contains(nei)){
                                stack.push(nei);
                                seen.add(nei);
                            }
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}