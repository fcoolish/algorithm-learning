//请你编写一个程序来计算两个日期之间隔了多少天。 
//
// 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。 
//
// 
//
// 示例 1： 
//
// 输入：date1 = "2019-06-29", date2 = "2019-06-30"
//输出：1
// 
//
// 示例 2： 
//
// 输入：date1 = "2020-01-15", date2 = "2019-12-31"
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 给定的日期是 1971 年到 2100 年之间的有效日期。 
// 
// Related Topics 数学 字符串 👍 52 👎 0

package leetcode.editor.cn;
public class NumberOfDaysBetweenTwoDates{
    public static void main(String[] args){
        Solution solution = new NumberOfDaysBetweenTwoDates().new Solution();
        solution.daysBetweenDates("2020-01-15","2019-12-31");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int daysBetweenDates(String date1, String date2) {
        String[] arr1 = date1.split("-");
        String[] arr2 = date2.split("-");
        int[] month = new int[]{0,31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int day1 = Integer.parseInt(arr1[2]);
        int day2 = Integer.parseInt(arr2[2]);
        //process year
        for(int i = 1971;i < Integer.parseInt(arr1[0]);i++){
            day1 += 365;
            if(isLeapYear(i))day1++;
        }
        for(int i = 1971;i < Integer.parseInt(arr2[0]);i++){
            day2 += 365;
            if(isLeapYear(i))day2++;
        }
        //process month
        for(int i = 1;i <= Integer.parseInt(arr1[1]);i++){
            day1 += month[i];
            if(i== 3 && isLeapYear(Integer.parseInt(arr1[0])))day1++;
        }
        for(int i = 1;i <= Integer.parseInt(arr2[1]);i++){
            day2 += month[i];
            if(i== 3 && isLeapYear(Integer.parseInt(arr2[0])))day2++;
        }
        return Math.abs(day1 -day2);
    }

    private boolean isLeapYear(int year){
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}