//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// 
// s 由小写英文字母、数字和方括号
// '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为
// [1, 300] 
// 
//
// Related Topics 栈 递归 字符串 👍 1472 👎 0

package leetcode.editor.cn;

import java.util.*;

public class DecodeString{
    public static void main(String[] args){
        Solution solution = new DecodeString().new Solution();
        solution.decodeString("2[a2[bc]]");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int ptr = 0;
    public String decodeString1(String s) {
        int n = s.length();
        LinkedList<String> stk = new LinkedList<>();
        while (ptr < n){
            char cur = s.charAt(ptr);
            if(Character.isDigit(cur)){
                String digits = getDigits(s);
                stk.addLast(digits);
            }else  if(Character.isLetter(cur) || cur == '['){
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            }else{
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())){
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                stk.removeLast();
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuilder t = new StringBuilder();
                String o = getString(sub);
                while (repTime-- > 0){
                    t.append(o);
                }
                stk.addLast(t.toString());
            }
        }
        return getString(stk);
    }

    public String decodeString(String s){
        int n = s.length();
        Deque<String> deque = new ArrayDeque<>();
        while (ptr < n){
            char c = s.charAt(ptr);
            if(Character.isDigit(c)){
                String dig = getDigits(s);
                deque.addLast(dig);
            }else if(Character.isLetter(c) || c == '['){
                deque.addLast(String.valueOf(c));
                ptr++;
            }else {
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(deque.peekLast())){
                    sub.add(deque.pollLast());
                }
                Collections.reverse(sub);
                deque.removeLast();
                String str = getString1(sub);
                int rc = Integer.parseInt(deque.pollLast());
                StringBuilder rr = new StringBuilder();
                while (rc-- > 0){
                    rr.append(str);
                }
                deque.addLast(rr.toString());
            }
        }
        return getString(deque);
    }

    private String getDigits1(String s){
        StringBuilder ret = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))){
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    private String getDigits(String s){
        StringBuilder res = new StringBuilder();
        while (ptr < s.length() && Character.isDigit(s.charAt(ptr))){
            res.append(s.charAt(ptr));
            ptr++;
        }
        return res.toString();
    }

    private String getString1(LinkedList<String> v){
            StringBuilder ret = new StringBuilder();
           for(String s:v){
               ret.append(s);
           }
            return ret.toString();
        }

    private String getString(Deque<String> v){
        StringBuilder res = new StringBuilder();
        for (String vv:v){
            res.append(vv);
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}