//给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// 
//
// 
// 注意：本题与主站 148 题相同：https://leetcode-cn.com/problems/sort-list/ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 121 👎 0

package leetcode.editor.cn;

public class SevenWHec2{
    public static void main(String[] args){
        Solution solution = new SevenWHec2().new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        solution.sortList(n1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head,ListNode tail) {
        if(head == null)return head;
        if(head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head,fast = head;
        while (fast != tail){
            fast  = fast.next;
            slow = slow.next;
            if(fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode pre = sortList(head,mid);
        ListNode end = sortList(mid,tail);
        return mergeTwo(pre,end);
    }

    private ListNode mergeTwo(ListNode l1,ListNode l2){
        ListNode dum = new ListNode(-1);
        ListNode pre = dum;
        while (l1 != null && l2 != null){
            if(l1.val > l2.val){
                pre.next = l2;
                l2 = l2.next;
            }else{
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2:l1;
        return dum.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}