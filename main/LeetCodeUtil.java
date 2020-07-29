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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length,length2 = nums2.length;
        int totalLength = length1 +length2;
        if(totalLength % 2 == 1){
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1,nums2,midIndex + 1);
            return  median;
        } else {
            int midIndex1 = totalLength /2 -1,midIndex2 = totalLength /2;
            double median = (getKthElement(nums1,nums2,midIndex1 +1) + getKthElement(nums1,nums2,midIndex2 + 1))/2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1,int nums2[],int k){
        int length1 = nums1.length,length2 = nums2.length;
        int index1 = 0,index2 = 0;
        int kthElement = 0;

        while(true){
            //边界情况
            if(index1 == length1){
                return  nums2[index2 + k - 1];
            }
            if(index2 == length2){
                return nums1[index1 + k -1];
            }
            if(k == 1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            //正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half,length1) - 1;
            int newIndex2 = Math.min(index2 + half,length2) - 1;
            int pivot1 = nums1[newIndex1],pivot2 = nums2[newIndex2];
            if(pivot1 <= pivot2){
                k -=(newIndex1 - index1 + 1);
                index1 = newIndex1 +1;
            }else{
                k -=(newIndex2 - index2 +1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {

    }
}
