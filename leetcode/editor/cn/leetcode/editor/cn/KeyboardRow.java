//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 202 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class KeyboardRow{
    public static void main(String[] args){
        Solution solution = new KeyboardRow().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findWords(String[] words) {
        List<String> list = new LinkedList<>();
        for(String str:words){
            if(canPrint(str)){
                list.add(str);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public boolean  canPrint(String word){
        String strA = "qwertyuiop";
        String strB = "asdfghjkl";
        String strC = "zxcvbnm";
        int a = 0,b = 0, c = 0;
        for(int i =0;i < word.length();i++){
            if(strA.contains(Character.toString(word.charAt(i)))){
                a = 1;
            }else if(strB.contains(Character.toString(word.charAt(i)))){
                b = 1;
            }else if(strC.contains(Character.toString(word.charAt(i)))){
                c = 1;
            }
            if((a + b + c) > 1)return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}