//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2443 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args){
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length() == 0)return list;
        Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        int n = digits.length();
        dfs(n,digits,map,new StringBuilder(),list,0);
        return list;
    }

    private void dfs(int n,String dig,Map<Character,String> map,StringBuilder sb,List<String> list,int index){
        if(index == n){
            list.add(new String(sb.toString()));
            return;
        }
        String str = map.get(dig.charAt(index));
        for(int i =0;i < str.length();i++){
            sb.append(str.charAt(i));
            dfs(n,dig,map,sb,list,index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}