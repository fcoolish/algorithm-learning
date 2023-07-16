//给定两个用链表表示的整数，每个节点包含一个数位。 
//
// 这些数位是反向存放的，也就是个位排在链表首部。 
//
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢? 
//
// 示例： 
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
//
// Related Topics 递归 链表 数学 👍 184 👎 0

package leetcode.editor.cn;
public class SumListsLcci{
    public static void main(String[] args){
        Solution solution = new SumListsLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(-1);
        ListNode pre = dum;
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0){
            int n1 = l1 == null ? 0:l1.val;
            int n2 = l2 == null ? 0:l2.val;
            int sum = n1 + n2 + temp;
            if(sum >= 0){
                ListNode nn = new ListNode(sum%10);
                temp = sum/10;
                pre.next = nn;
                pre = pre.next;
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return dum.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}