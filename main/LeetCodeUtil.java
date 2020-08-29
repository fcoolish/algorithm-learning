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

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for(int i = 0;i <= m; i++){
            for(int j = 1;j <= n; ++j){
                if(p.charAt(j-1) == '*'){
                    f[i][j] = f[i][j - 2];
                    if(matches(s,p,i,j - 1)){
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }else{
                    if(matches(s,p,i,j)){
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s,String p,int i,int j){
        if(i == 0){
            return  false;
        }
        if(p.charAt(j - 1) == '.'){
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public int maxArea(int[] height) {
        int l = 0,r = height.length - 1;
        int ans = 0;
        while(l < r){
            int area = Math.min(height[1],height[r]) * (r - l);
            ans = Math.max(ans,area);
            if(height[1] <= height[r]){
                ++l;
            }else{
                --r;
            }
        }
        return ans;
    }

    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < values.length;i++){
            while(values[i] <= num){
                num -=values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length();i++){
            int num = getValue(s.charAt(i));
            if(num > preNum){
                sum -= preNum;
            }else{
                sum +=preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public int getValue(char ch){
        switch (ch){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return  "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for(int i = 0;i<length;i++){
            char c = strs[0].charAt(i);
            for(int j = 1;j<count;j++){
                if(strs[j].length() ==i || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {

        //System.out.println("list:");
    }
}
