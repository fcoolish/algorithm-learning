//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
//
// Related Topics 递归 链表 👍 339 👎 0

package leetcode.editor.cn;
public class HeBingLiangGePaiXuDeLianBiaoLcof{
    public static void main(String[] args){
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode pHead = new ListNode(-1);
        ListNode index = pHead;
        ListNode a = l1,b = l2;
        while (a != null && b != null){
            if(a.val > b.val){
                index.next = b;
                b = b.next;
            }else{
                index.next = a;
                a = a.next;
            }
            index = index.next;
        }
        index.next = a == null ? b:a;
        return pHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}