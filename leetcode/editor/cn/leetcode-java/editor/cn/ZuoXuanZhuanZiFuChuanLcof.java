//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 数学 双指针 字符串 👍 290 👎 0

package leetcode.editor.cn;
public class ZuoXuanZhuanZiFuChuanLcof{
    public static void main(String[] args){
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        n = n % len;
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for(int i = 0;i < len;i++){
            if(i < n){
                a.append(s.charAt(i));
            }else{
                b.append(s.charAt(i));
            }
        }
        return b.append(a).toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}