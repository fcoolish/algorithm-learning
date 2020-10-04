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


    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //枚举a
        for(int first = 0;first < n;first++){
            //需要和上一次枚举的数不相同
            if(first > 0&&nums[first] == nums[first - 1]){
                continue;
            }
            int third = n - 1;
            int target  = -nums[first];
            //枚举b
            for(int second = first + 1;second < n; second++){
                //需要和上一次不同
                if(second > first + 1&& nums[second] == nums[second -1]){
                    continue;
                }
                //需要保证b的指针在c的左侧
                while(second < third && nums[second] + nums[third] > target){
                    --third;
                }
                //如果指针重复，随着b后续增加
                //就会有a+b+c=0且b<c的c了，退出循环
                if(second == third){
                    break;
                }
                if(nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;
        //枚举A
        for(int i =0;i < n;i++){
            if(i > 0&& nums[i] == nums[i - 1]){
                    continue;
            }
            //使用双指针枚举b和c
            int j = i + 1,k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return target;
                }
                if(Math.abs(sum - target) < Math.abs(best - target)){
                    best = sum;
                }
                if(sum > target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return best;
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if(digits.length() == 0){
            return combinations;
        }
        Map<Character,String>phoneMap = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtracks(combinations,phoneMap,digits,0,new StringBuffer());
        return combinations;
    }

    public void backtracks(List<String> combinations,Map<Character,String> phoneMap,String digits,int index,StringBuffer combination){
        if(index == digits.length()){
            combinations.add(combination.toString());
        }else{
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for(int i = 0;i < lettersCount;i++){
                combination.append(letters.charAt(i));
                backtracks(combinations,phoneMap,digits,index + 1,combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //枚举a
        for(int first = 0;first < n -3;first++){
            //需要和上一次枚举的数不相同
            if(first > 0&&nums[first] == nums[first - 1]){
                continue;
            }
            //枚举b
            for(int second = first + 1;second < n - 2; second++){
                //需要和上一次不同
                if(second >first+ 1 &&nums[second] == nums[second -1]){
                    continue;
                }
                for(int third = second + 1;third < n -1;third++){
                    if(third >second+ 1 &&nums[third] == nums[third -1]){
                        continue;
                    }
                    int four = n - 1;
                    //需要保证b的指针在c的左侧
                    while(third < four && nums[first] + nums[second] + nums[four] + nums[third] > target){
                        four--;
                    }
                    if(four == third){
                        break;
                    }
                    if(nums[first] + nums[second] + nums[four] + nums[third] == target){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[four]);
                        ans.add(list);
                    }

                }

            }
        }
        return ans;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)return null;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode fast = pHead;
        ListNode slow = pHead;
        for(int i = 0;i<= n;i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pHead.next;
    }

    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 == 1){
            return false;
        }

        Map<Character,Character> pairs = new HashMap<Character, Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0;i< n;i++){
            char ch = s.charAt(i);
            if(pairs.containsKey(ch)){
                if(stack.isEmpty() || stack.peek() != pairs.get(ch)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ?l2:l1;
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(l1 !=null && l2!= null){
            if(l1.val >=l2.val){
                temp.next = l2;
                l2 = l2.next;
            }else{
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        if(l1 !=null)temp.next = l1;
        if(l2 !=null)temp.next = l2;
        return head.next;
    }

    public ListNode mergeLists(ListNode[] lists,int left,int right) {
        if(left == right) return lists[1];
        if(left > right)return null;
        int mid = (left + right)/2;
        return mergeTwoLists(mergeLists(lists,left,mid),mergeLists(lists,mid + 1,right));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null ||lists.length == 0)return null;
        return mergeLists(lists,0,lists.length - 1);
    }


    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrace(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    public void backtrace(List<String> ans,StringBuilder cur,int open,int close,int max){
        if(cur.length() == max * 2){
            ans.add(cur.toString());
            return;
        }
        if(open < max){
            cur.append('(');
            backtrace(ans,cur,open + 1,close,max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if(close < open){
            cur.append(")");
            backtrace(ans,cur,open,close +1,max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second  =  head.next;
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while(end.next != null){
            for(int i =0;i<k&&end!=null;i++){
                end = end.next;
            }
            if(end == null){
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return  pre;
    }

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length ==0)return 0;
        int i = 0;
        for(int j = 1;j < nums.length;j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length ==0)return 0;
        int i = 0;
        for(int j = 0;j < nums.length;j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int strStr(String haystack, String needle) {
        int n  = haystack.length();
        int L = needle.length();
        if(L == 0)return 0;
        int pn = 0;
        while(pn < n - L + 1){
            while(pn < n - L + 1&&haystack.charAt(pn) != needle.charAt(0)){
                    pn++;
                }
                int currLen = 0 ,pL = 0;
                while (pL < L && pn <n && haystack.charAt(pn) == needle.charAt(pL)){
                    pn++;
                    pL++;
                    currLen++;
                }
                if(currLen == L)return pn -L;
                pn = pn - currLen + 1;
        }
        return -1;
    }

    public int divide(int dividend, int divisor) {
        if(divisor == -1 && dividend == Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        if(dividend == 0)return 0;
        if(divisor == 1) return dividend;
        if(divisor == -1){
            if(dividend >Integer.MIN_VALUE)return -dividend;
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if((dividend > 0&& divisor < 0) || (dividend < 0 && divisor > 0)){
            sign = -1;
        }
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? - divisor : divisor;
        if(a > b)return 0;
        int ans = calDiv(a,b);
        return  sign == -1 ? -ans : ans;
    }

    int calDiv(int a,int b){
        if(a > b) return 0;
        int count = 1;
        int tb = b;
        while(tb + tb >= a && tb + tb < 0){
            tb +=tb;
            count += count;
        }
        return count+calDiv(a - tb,b);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || words == null || words.length == 0)return res;
        HashMap<String,Integer> map  = new HashMap<String, Integer>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(int i = 0;i <s.length() - all_len + 1;i++){
            String tmp = s.substring(i,i+all_len);
            HashMap<String,Integer> tmp_map = new HashMap<String, Integer>();
            for(int j = 0;j < all_len;j +=one_word){
                String w = tmp.substring(j,j + one_word);
                tmp_map.put(w,tmp_map.getOrDefault(w,0) + 1);
            }
            if(map.equals(tmp_map))res.add(i);
        }
        return res;
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length -2;
        while(i >=0 && nums[i + 1] <= nums[i]){
            i--;
        }
        if(i >=0){
            int j = nums.length - 1;
            while(j >=0 && nums[j] <= nums[i]){
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reverse(nums,i + 1);
    }

    public void reverse(int[] nums,int start){
        int i = start,j = nums.length -1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public int longestValidParentheses(String s) {
        if(s == null || s.length() ==0)return 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int max = 0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    max = Math.max(max,i - stack.peek());
                }
            }
        }
        return max;
    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)return -1;
        int n = nums.length;
        if(n == 1){
            return nums[0] == target?0:-1;
        }
        int l = 0,r = n -1;
        while(l <=r){
            int mid = (l + r)/2;
            if(nums[mid] == target)return mid;
            if(nums[0] <= nums[mid]){
                if(nums[0] <= target && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(nums[mid] < target&&target <=nums[n - 1]){
                    l = mid +1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        //System.out.println("list:");
    }
}
