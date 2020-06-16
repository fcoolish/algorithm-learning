import java.util.*;

/**
 * Created by admin on 2020/6/13.
 */
public class LeetCodeUtil {


    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length ==0 ){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++){
            int search = target - nums[i];
            if(map.containsKey(search)){
                return new int[]{i,map.get(search)};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1,q= l2,curr = dummyHead;
        int carry = 0;
        while(p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val: 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null)p = p.next;
            if(q != null)q = q.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
