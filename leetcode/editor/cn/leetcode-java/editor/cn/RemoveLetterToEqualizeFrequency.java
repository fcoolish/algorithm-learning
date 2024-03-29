//给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。你需要选择 一个 下标并 删除 下标处的字符，使得 word 中剩余每个字母出现 频
//率 相同。 
//
// 如果删除一个字母后，word 中剩余所有字母的出现频率都相同，那么返回 true ，否则返回 false 。 
//
// 注意： 
//
// 
// 字母 x 的 频率 是这个字母在字符串中出现的次数。 
// 你 必须 恰好删除一个字母，不能一个字母都不删除。 
// 
//
// 
//
// 示例 1： 
//
// 输入：word = "abcc"
//输出：true
//解释：选择下标 3 并删除该字母，word 变成 "abc" 且每个字母出现频率都为 1 。
// 
//
// 示例 2： 
//
// 输入：word = "aazz"
//输出：false
//解释：我们必须删除一个字母，所以要么 "a" 的频率变为 1 且 "z" 的频率为 2 ，要么两个字母频率反过来。所以不可能让剩余所有字母出现频率相同。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= word.length <= 100 
// word 只包含小写英文字母。 
// 
// Related Topics 哈希表 字符串 计数 👍 20 👎 0

package leetcode.editor.cn;

import java.util.*;

public class RemoveLetterToEqualizeFrequency{
    public static void main(String[] args){
        Solution solution = new RemoveLetterToEqualizeFrequency().new Solution();
        //solution.equalFrequency("abcc");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 1.只有一种次数: 只有一种字母 || n种字母，每种字母的出现次数都为1
        // 2.只有两种次数: 只有一种字母的出现次数为1 || 1种字母的出现次数为n + 1，其他字母出现次数为n && n + 1次数的只有一种字母
        public boolean equalFrequency1(String word) {
            Map<Character,Integer> charMap = new HashMap<>();
            for(int i =0;i < word.length();i++){
                charMap.put(word.charAt(i),charMap.getOrDefault(word.charAt(i),0) + 1);
            }
            TreeMap<Integer,Integer> countMap = new TreeMap<>();
            for(Integer value:charMap.values()){
                countMap.put(value,countMap.getOrDefault(value,0) + 1);
            }
            if(countMap.size() > 2){
                return false;
            }
            if(countMap.size() == 1){
                return countMap.containsKey(1) || charMap.size() == 1;
            }
            return countMap.containsKey(1) && countMap.get(1) == 1
                    || (countMap.lastEntry().getValue() == 1 && countMap.lastKey() - countMap.firstKey() == 1);
        }

        //暴力是唯一的优雅
        public boolean equalFrequency(String word){
            int[] cnt = new int[26];
            List<Character> list = new ArrayList<>();
            for(int i =0;i < word.length();i++){
                cnt[word.charAt(i) - 'a']++;
                if(!list.contains(word.charAt(i))){
                    list.add(word.charAt(i));
                }
            }
            for(int i =0;i < list.size();i++){
                cnt[list.get(i) - 'a']--;
                int same = -1;
                boolean match = true;
                for(int j = 0;j < 26;j++){
                    if(cnt[j] == 0){
                        continue;
                    }
                    if(same == - 1){
                        same = cnt[j];
                    }else if(same != cnt[j]){
                        match = false;
                        break;
                    }
                }
                if(match){
                    return true;
                }
                cnt[list.get(i) - 'a']++;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}