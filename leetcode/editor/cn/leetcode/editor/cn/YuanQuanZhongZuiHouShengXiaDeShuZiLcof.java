//0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
// 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 
//输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
//
// Related Topics 递归 数学 👍 773 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof{
    public static void main(String[] args){
        Solution solution = new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();
        solution.lastRemaining(5,3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int lastRemaining1(int n, int m) {
            return f(n,m);
        }

    public int f(int n,int m){
        if(n == 1)return 0;
        int x = f(n - 1,m);
        return (m + x) % n;
    }
    public int lastRemaining2(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for(int i =0;i < n;i++){
            list.add(i);
        }
        int idx  = 0;
        while (n > 1){
            idx =  (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public int lastRemaining(int n, int m){
        int index = 0;
        for(int i = 2;i <= n;i++){
            index = (m + index) % i;
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}