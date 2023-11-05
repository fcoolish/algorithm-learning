//给你一个字符串 date ，它的格式为 Day Month Year ，其中： 
//
// 
// Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。 
// Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", 
//"Oct", "Nov", "Dec"} 中的一个元素。 
// Year 的范围在 [1900, 2100] 之间。 
// 
//
// 请你将字符串转变为 YYYY-MM-DD 的格式，其中： 
//
// 
// YYYY 表示 4 位的年份。 
// MM 表示 2 位的月份。 
// DD 表示 2 位的天数。 
// 
//
// 
//
// 示例 1： 
//
// 输入：date = "20th Oct 2052"
//输出："2052-10-20"
// 
//
// 示例 2： 
//
// 输入：date = "6th Jun 1933"
//输出："1933-06-06"
// 
//
// 示例 3： 
//
// 输入：date = "26th May 1960"
//输出："1960-05-26"
// 
//
// 
//
// 提示： 
//
// 
// 给定日期保证是合法的，所以不需要处理异常输入。 
// 
// Related Topics 字符串 👍 19 👎 0

package leetcode.editor.cn;
public class ReformatDate{
    public static void main(String[] args){
        Solution solution = new ReformatDate().new Solution();
        solution.reformatDate("20th Oct 2052");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reformatDate(String date) {
        String[] strs = date.split(" ");
        StringBuilder ans = new StringBuilder();
        ans.append(strs[2]).append('-');
        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int month = 0;
        for(int i = 0;i < 12;i++){
            if(strs[1].equals(months[i]) ){
                month = i + 1;
                break;
            }
        }
        if(month < 10){
            ans.append(0);
        }
        ans.append(month).append("-");
        if(Character.isDigit(strs[0].charAt(1))){
            ans.append(String.valueOf(strs[0].substring(0,2)));
        }else{
            ans.append("0").append(String.valueOf(strs[0].substring(0,1)));
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}