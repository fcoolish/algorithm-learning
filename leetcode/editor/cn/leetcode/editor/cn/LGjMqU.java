//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// 
//
// 
// 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/ 
//
// Related Topics 栈 递归 链表 双指针 👍 119 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LGjMqU{
    public static void main(String[] args){
        Solution solution = new LGjMqU().new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        solution.reorderList(n1);
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
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur);
            cur = cur.next;
            list.get(list.size() - 1).next = null;
        }
        int len = list.size();
        ListNode pre = new ListNode(-1);
        for(int i =0;i < (len + 1)/2;i++){
            ListNode node = list.get(i);
            ListNode node2 = list.get(len - 1 - i);
            pre.next = node;
            pre = pre.next;
            if(node != node2){
                pre.next = node2;
                pre = pre.next;
            }
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}