//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
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
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1986 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList{
    public static void main(String[] args){
        Solution solution = new SortList().new Solution();
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

    public ListNode sortList(ListNode head){
        return sortList(head,null);
    }

    private ListNode sortList(ListNode head,ListNode tail){
        if(head == null)return head;
        if(head.next== tail){
            head.next = null;
            return head;
        }
        ListNode fast = head,slow = head;
        while (fast != tail){
            fast = fast.next;
            slow = slow.next;
            if(fast.next != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode l1 = sortList(head,mid);
        ListNode l2 = sortList(mid,tail);
        ListNode node = merge(l1,l2);
        return node;
    }

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode vnode = new ListNode(-1);
        ListNode pre = vnode;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2:l1;
        return vnode.next;
    }

    public ListNode sortList1(ListNode head) {
        if(head == null)return head;
        List<ListNode> list = new ArrayList<>();
        ListNode cur= head;
        while (cur != null){
            list.add(cur);
            cur = cur.next;
        }
        Collections.sort(list,(a,b) -> a.val - b.val);
        for(int i = 0;i < list.size() - 1;i++){
            list.get(i + 1).next = null;
            list.get(i).next = list.get(i + 1);
        }
        return list.get(0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}