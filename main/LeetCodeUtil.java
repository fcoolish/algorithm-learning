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

    public String longestPalindrome(String s) {
        int len =s.length();
        if(len < 2){
            return s;
        }
        int maxLen = 1,begin = 0;
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        for(int i =0;i < len;i++){
            dp[i][i] = true;
        }
        for(int j = 1;j < len;j++){
            for(int i = 0;i < j;i++){
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    if(j - i <3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //只要条件成立就是回文
                if(dp[i][j] && j - i +1 >maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return  s.substring(begin,begin +maxLen);
    }

    public String convert(String s, int numRows) {
        if(numRows == 1)return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0;i< Math.min(numRows,s.length()); i++){
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for(char c:s.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow == 0 ||curRow == numRows - 1)
                goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for(StringBuilder row:rows)
            ret.append(row);
        return  ret.toString();
    }

    public static int reverse(int x) {
       int res = 0;
        while(x!=0){
            int pop = x % 10;
            if((Integer.MAX_VALUE/10 < res ) || (Integer.MIN_VALUE / 10) > res ){
                return 0;
            }
            res = res * 10 + pop;
            x = x / 10;
        }
       return res;
    }

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while(idx < n && chars[idx] == ' '){
            //去掉空格
            idx++;
        }
        if(idx == n){
            return 0;
        }
        boolean negative = false;
        if(chars[idx] == '-'){
            negative = true;
            idx++;
        }else if(chars[idx] == '+'){
            idx++;
        }else if(Character.isDigit(chars[idx])){
            return 0;
        }
        int ans = 0;
        while(idx < n && Character.isDigit(chars[idx])){
            int digit = chars[idx] - '0';
            if(ans >(Integer.MAX_VALUE - digit) / 10){
                return negative ? Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative?-ans:ans;
    }

    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0))return false;
        int revertedNumber = 0;
        while(x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x %10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        //int x = reverse(1534236469);
        //System.out.println("res:"+x);
    }
}
