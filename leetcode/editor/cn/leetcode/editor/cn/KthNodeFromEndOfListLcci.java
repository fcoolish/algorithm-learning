//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针 👍 118 👎 0

package leetcode.editor.cn;
public class KthNodeFromEndOfListLcci{
    public static void main(String[] args){
        Solution solution = new KthNodeFromEndOfListLcci().new Solution();
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
    public int kthToLast(ListNode head, int k) {
        ListNode fN = head;
        ListNode sN = head;
        while (k > 0 && fN != null){
            fN = fN.next;
            k--;
        }
        while (fN != null){
            fN = fN.next;
            sN = sN.next;
        }
        return sN.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}