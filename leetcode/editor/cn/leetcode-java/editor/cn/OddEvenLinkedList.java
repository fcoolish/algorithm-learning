//给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。 
//
// 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。 
//
// 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。 
//
// 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,3,5,2,4] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [2,1,3,5,6,4,7]
//输出: [2,3,6,7,1,5,4] 
//
// 
//
// 提示: 
//
// 
// n == 链表中的节点数 
// 0 <= n <= 10⁴ 
// -10⁶ <= Node.val <= 10⁶ 
// 
//
// Related Topics 链表 👍 699 👎 0

package leetcode.editor.cn;
public class OddEvenLinkedList{
    public static void main(String[] args){
        Solution solution = new OddEvenLinkedList().new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        solution.oddEvenList(n1);
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

    public ListNode oddEvenList(ListNode head){
        if(head == null)return head;
        ListNode evenHead = head.next;
        ListNode odd = head,even = head.next;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    public ListNode oddEvenList1(ListNode head) {
        if(head == null)return head;
        ListNode pre = head;
        ListNode cur = head;
        ListNode eDum = new ListNode(-1);
        ListNode ep = eDum;
        boolean even = false;
        while (cur != null){
            if(even){
                ep.next = new ListNode(cur.val);
                ep = ep.next;
                cur = cur.next;
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
            even = !even;
        }
        pre.next = eDum.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}