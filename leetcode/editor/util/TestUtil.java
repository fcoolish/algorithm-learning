



import java.util.*;

/**
 * Created by fcoolish on 2020/3/16.
 */
public class TestUtil {




    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList arr = new ArrayList<Integer>();
        ListNode tmp = listNode;
        while(tmp!=null){
            arr.add(0,tmp.val);
            tmp = tmp.next;
        }
        return arr;
    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre.length == 0||in.length ==0){
            return  null;
        }
        TreeNode root = new TreeNode(pre[0]);
        //在中序中找到前序的根
        for(int i = 0;i < in.length;i++){
            if(in[i]==pre[0]){
                //左子树，注意copyOfRange函数，左闭右开
                root.left = reConstructBinaryTree(copyOfRange(pre,1,i+1),copyOfRange(in,0,i));
                //右子树，注意copyOfRange函数，左闭右开
                root.right = reConstructBinaryTree(copyOfRange(pre,i+1,pre.length),copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return  root;
    }

    public static int[] copyOfRange(int[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0)
            throw new IllegalArgumentException(from + " > " + to);
        int[] copy = new int[newLength];
        System.arraycopy(original, from, copy, 0,
                Math.min(original.length - from, newLength));
        return copy;
    }

    //栈操作
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //public void push(int node) {
    //    stack1.push(node);
    //}
    //
    //public int pop() {
    //    if(stack2.size()<=0){
    //        while(stack1.size()!=0){
    //            stack2.push(stack1.pop());
    //        }
    //    }
    //    return stack2.pop();
    //}



    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        int low = 0,high = array.length-1;
        while(array[low] == array[high]){
            ++low;
            --high;
        }

        while(array[low] > array[high]){
            int mid = low + (high-low) /2;
            if(array[mid] >= array[low]){
                low = mid +1;
            }else if(array[mid]<=array[high]){
                high = mid;
            }
        }
        return array[low];
    }

    public int Fibonacci(int n) {
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for(int i =2;i <=n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];

    }

    public int JumpFloor(int target) {
        if(target<=2){
            return  target;
        }
        int pre2 =1,pre1 = 2;
        for(int i = 3;i<=target;i++){
            int cur = pre2 +pre1;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
    public int JumpFloorII(int target) {

        return 1<<(target-1);
    }

    public int NumberOf1(int n) {
        int count = 0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }

    public double Power(double base, int exponent) {
        //如果为0直接返回
        if(base==0.0){
            return 0.0;
        }
        double result = 1.0d;
        //判断指数是否大于0
        int e = exponent > 0?exponent : -exponent;
        for(int i = 1;i<=e;i++){
            result *= base;
        }
        return exponent > 0 ? result:1/result;
    }


    public void reOrderArray(int [] array) {
        int len = array.length;
        if(len <= 1){
            return;
        }
        int i = 0;
        while(i<len){
            int j = i + 1;
            if(array[i]%2 == 0){//a[i]为偶数，直到替换
                while(array[j]%2 == 0){ //j为偶数，前进
                    if(j == len - 1){
                        return;
                    }
                    j++;
                }
                //此时j为奇数
                int count = j-i;
                int temp = array[i];
                array[i] = array[j];
                while(count>1){
                    array[i+count] = array[i+count - 1];
                    count--;
                }
                array[i+1] = temp;
            }
            i++;
        }
    }


        public ListNode FindKthToTail(ListNode head,int k) {
            if(head == null || k ==0){
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;
            for(int i=0;i<k;i++){
                if(fast==null){
                    return null;
                }
                fast = fast.next;
            }
            while (fast!=null){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }


    public ListNode ReverseList(ListNode head) {
        //初始化pre指针，用于记录当前结点的前一个结点地址
        ListNode pre = null;
        //初始化p指针，用于记录当前结点的下一个结点地址
        ListNode p = null;
        //head指向null时，循环终止
        while(head != null){
            //先用p指针记录当前结点的下一个结点地址。
            p = head.next;
            //让被当前结点与链表断开并指向前一个节点pre。
            head.next = pre;
            //pre指针指向当前结点
            pre = head;
            //head指向p（保存原链表中head的下一个结点地址）
            head = p;
        }
        //当循环结束时，pre所指的就是反转链表的头结点
        return  pre;
    }


    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode h  = new ListNode(0);
        ListNode cur = h;
        while(list1 != null && list2 !=null){
            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1!=null)cur.next = list1;
        if(list2!=null)cur.next = list2;
        return  h.next;
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
      if (root1 == null && root2 ==null){
          return  false;
      }

      return judgeSubTree(root1,root2) || judgeSubTree(root1.left,root2) ||
              judgeSubTree(root1.right,root2);

    }

    private boolean judgeSubTree(TreeNode root1,TreeNode root2){
        if (root2 ==null){
            return true;
        }

        if (root1 == null){
            return false;
        }
        if(root1.val != root2.val){
            return judgeSubTree(root1.left,root2) ||
                    judgeSubTree(root1.right,root2);
        }
        return judgeSubTree(root1.left,root1.left ) &&
                judgeSubTree(root1.right,root2.right);
    }

    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer>list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return list;
        }
        int up=0,down = matrix.length-1,left = 0,right = matrix[0].length-1;
        while (true){
            for(int col = left;col<=right;col++){
                list.add(matrix[up][col]);
            }
            up++;
            if(up > down){
                break;
            }
            for(int row=up;row<=down;row++){
                list.add(matrix[row][right]);
            }
            right--;
            if(left > right){
                break;
            }
            for(int col = right;col>=left;col--){
                list.add(matrix[down][col]);
            }
            down--;
            if(up > down){
                break;
            }
            for(int row=down;row>=up;row--){
                list.add(matrix[row][left]);
            }
            left++;
            if(left > right){
                break;
            }

        }
        return list;
    }

    private static Stack<Integer> stack = new Stack<Integer>();
    private static  Integer minElement = Integer.MAX_VALUE;

    public void push(int node){
        if(stack.empty()){
            minElement = node;
            stack.push(node);
        }else {
            if (node <= minElement){
                stack.push(minElement);
                minElement = node;
            }
            stack.push(node);
        }
    }

    public void pop(){
        if(stack.size() == 0)return;
        if(minElement == stack.peek()){
            if(stack.size()>1){
                stack.pop();
                minElement = stack.peek();
            }else{
                minElement = Integer.MAX_VALUE;
            }
        }
        stack.pop();
    }

    public int top(){
        return  stack.peek();
    }

    public int min(){
        return minElement;
    }


    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0 || popA.length != pushA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for(int i =0;i < pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)return  result;
        Queue<TreeNode>queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if (temp.left != null)queue.offer(temp.left);
            if (temp.right!= null)queue.offer(temp.right);
        }
        return  result;
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return helpVerify(sequence,0,sequence.length-1);
    }

    public boolean helpVerify(int[] sequence,int start,int root){
        int key = sequence[root];
        int i;
        //找到左右子树的分界点
        for(i=start;i < root;i++) {
            if (sequence[i] > key) {
                break;
            }
        }
            //在右子树中判断是否含有小于root的值，如果有返回false
            for(int j =i;j< root;j++){
                if(sequence[j] < key){
                    return false;
                }
            }
        return  helpVerify(sequence,start,i-1)&& helpVerify(sequence,i,root-1);
    }

    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null){
            return result;
        }
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            result.add(new ArrayList<Integer>(list));
        }
        ArrayList<ArrayList<Integer>> result1 = FindPath(root.left,target);
        ArrayList<ArrayList<Integer>> reslt2  = FindPath(root.right,target);
        list.remove(list.size()-1);
        return result;
    }

    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)return  null;
        RandomListNode newHead = null;
        RandomListNode p = pHead;
        RandomListNode q = null;
        Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        while(p != null){
            if(newHead == null){
                newHead = new RandomListNode(pHead.label);
                q = newHead;
                map.put(pHead,newHead);
            }else{
                if(p.next != null && map.containsKey(p.next)){
                    q.next = map.get(p.next);
                }else{
                    if(p.next != null){
                        RandomListNode temp = new RandomListNode(p.next.label);
                        map.put(p.next,temp);
                        q.next = temp;
                    }
                }
                if(p.random != null && map.containsKey(p.random)){
                    q.random = map.get(p.random);
                }else {
                    if (p.random !=null){
                        RandomListNode temp = new RandomListNode(p.random.label);
                        map.put(p.random,temp);
                        q.random = temp;
                    }
                }

                p = p.next;
                q = q.next;
            }

        }
        return newHead;
    }

    TreeNode pre = null;
    TreeNode root = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        Convert(pRootOfTree.left);
        if(root==null){
            root = pRootOfTree;
        }
        if(pre != null){
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert(pRootOfTree.right);
        return  root;
    }
    //
    //public TreeNode Convert(TreeNode pRootOfTree) {
    //    if(pRootOfTree == null){
    //        return null;
    //    }
    //    ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    //    Convert(pRootOfTree,list);
    //    return Convert(list);
    //}
    ////中序遍历
    //public void Convert(TreeNode pRootOfTree,ArrayList<TreeNode> list) {
    //    if (pRootOfTree.left != null) {
    //        Convert(pRootOfTree.left, list);
    //    }
    //    list.add(pRootOfTree);
    //    if (pRootOfTree.right != null) {
    //        Convert(pRootOfTree.right, list);
    //    }
    //}
    //    //遍历list，修改指针
    //public TreeNode Convert(ArrayList<TreeNode> list){
    //    for(int i=0;i <list.size()-1;i++){
    //        list.get(i).right = list.get(i+1);
    //        list.get(i+1).left = list.get(i);
    //    }
    //    return  list.get(0);
    //}



    public ArrayList<String> Permutation(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        ArrayList<String> result = PermutationHelp(stringBuilder);
        return result;
    }

    public ArrayList<String>PermutationHelp(StringBuilder str){
        Set<String>result = new TreeSet<String>();
        if(str.length() == 1)result.add(str.toString());
        else{
            for(int i = 0;i< str.length();i++){
                if(i ==0 || str.charAt(i) != str.charAt(0)){
                    char temp = str.charAt(i);
                    str.setCharAt(i,str.charAt(0));
                    str.setCharAt(0,temp);
                    ArrayList<String>newResult = PermutationHelp(new StringBuilder(str.substring(1)));
                    for(int j = 0;j<newResult.size();j++)
                        result.add(str.substring(0,1)+newResult.get(j));
                    //用完还是要放回去的
                    temp = str.charAt(0);
                    str.setCharAt(0,str.charAt(i));
                    str.setCharAt(i,temp);
                }
            }
            //Collections.sort(result, new Comparator<String>() {
            //    @Override
            //    public int compare(String arg0, String arg1) {
            //        int i = 1;
            //        if(arg0.compareTo(arg1)>0){
            //            return 1;
            //        }else if(arg0.compareTo(arg1)<0){
            //            return -1;
            //        }else{
            //            return compare(arg0.substring(i++),arg1.substring(i++));
            //        }
            //    }
            //});
        }
        return  new ArrayList<String>(result);
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null ||array.length ==0) return 0;
        //用来记录上一次的记录
        int preValue = array[0];
        int count = 1;
        for(int i  = 1;i < array.length;i++){
            if(array[i] == preValue)
                count++;
            else {
                count--;
                if(count==0){
                    preValue = array[i];
                    count = 1;
                }
            }
        }
        int num = 0;
        //判断是否大于半数
        for(int i = 0;i< array.length;i++){
            if(array[i] == preValue)
                num++;
        }
        return (num > array.length/2)?preValue:0;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(k == 0 || k >input.length)return result;
        //初次排序，完成k个元素的排序
        for(int i = 1;i < k;i++){
            int j = i - 1;
            int unFindElement = input[i];
            while(j >=0 && input[j] > unFindElement){
                input[j+1] = input[j];
                j--;
            }

            input[j+1] = unFindElement;
        }

        //遍历后面的元素，进行k个元素的更新和替换
        for(int i = k;i < input.length;i++){
            if(input[i] < input[k-1]){
                int newK = input[i];
                int j = k - 1;
                while(j>=0 && input[j] > newK){
                    input[j+1] = input[j];
                    j--;
                }
                input[j+1] = newK;
            }
        }
        //把钱k个元素返回
        for(int i = 0;i < k;i++){
            result.add(input[i]);
        }
        return result;
    }


    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1] > 0 ? array[i - 1] : 0;
            max = Math.max(max, array[i]);
        }
        return max;
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while(n > 0 ){
            String str  = String.valueOf(n);
            char[] chars = str.toCharArray();
            for(int i = 0;i< chars.length;i++){
                if(chars[i] == '1')
                    count++;
            }
            n--;
        }
        return count;
    }

    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0)return "";
        for(int i = 0;i < numbers.length;i++){
            for(int j = i+1;j < numbers.length;j++){
                int sum1 = Integer.valueOf(numbers[i]+""+numbers[j]);
                int sum2 = Integer.valueOf(numbers[j]+""+numbers[i]);
                if(sum1 > sum2){
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        String str = new String("");
        for(int i =0;i < numbers.length;i++) {
            str = str +numbers[i];
        }
        return str;
    }

    public int GetUglyNumber_Solution(int index) {
        if(index <=0)return 0;
        int p2=0,p3=0,p5=0;
        int[] result = new int[index];
        result[0] = 1;
        for(int i = 1;i < index;i++){
            result[i] = Math.min(result[p2]*2,Math.min(result[p3]*3,result[p5]*5));
            if(result[i] == result[p2]*2)p2++;
            if(result[i] == result[p3]*3)p3++;
            if(result[i] == result[p5]*5)p5++;
        }
        return result[index - 1];
    }


    public static int FirstNotRepeatingChar(String str) {
        if(str==null || str.length() ==0)return -1;
        int[] count = new int[256];
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)]++;
        }
        for(int i=0;i < str.length();i++){
            if(count[str.charAt(i)]==1)
                return  i;
        }
        return -1;
    }

    private int cnt;
    private void MergeSort(int[] array,int start,int end){
        if(start >= end)return;
        int mid = (start + end )/2;
        MergeSort(array,start,mid);
        MergeSort(array,mid+1,end);
        MergeOne(array,start,mid,end);
    }
    private void MergeOne(int[] array,int start,int mid,int end){
        int[] temp = new int[end - start+1];
        int k = 0,i = start,j = mid + 1;
        while(i <=mid && j <=end){
            if(array[i] <= array[j])
                temp[k++] = array[i++];
            else{
                temp[k++] = array[j++];
                cnt = (cnt+(mid - i + 1))%1000000007;
            }
        }
        while (i <= mid)
            temp[k++] = array[i++];
        while (j <= end)
            temp[k++] = array[j++];
        for (int l = 0;l<k;l++){
            array[start+l] = temp[l];
        }
    }

    public int InversePairs(int [] array) {
        MergeSort(array,0,array.length - 1);
        return cnt;
    }

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null ||pHead2 == null)return null;
		ListNode p1 = pHead1;
		ListNode p2 = pHead2;
		while (p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
			if(p1 != p2){
				if(p1 == null)p1 = pHead2;
				if(p2 == null)p2 = pHead1;
			}
		}
		return p1;
	}

    public int GetNumberOfK(int [] array , int k) {
        int index = Arrays.binarySearch(array,k);
        if(index < 0)return  0;
        int count = 1;
        for(int i = index +1;i < array.length && array[i] == k;i++)
            count++;
        for (int i = index - 1;i >=0 && array[i] == k ;i--)
            count ++;
        return count;
    }

//    public  int TreeDepth(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        int left = TreeDepth(root.left);
//        int right = TreeDepth(root.right);
//        return Math.max(left,right) + 1;
//    }

    public int TreeDepth(TreeNode root){
        if(root == null)return 0;
        if(root.left == null && root.right == null)
            return 1;
        return 1+Math.max(TreeDepth(root.left),TreeDepth(root.right));
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null )return true;
        if(Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1)
            return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length == 0)return;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i < array.length;i++){
            if (map.containsKey(array[i])){
                map.put(array[i],2);
            }else{
                map.put(array[i],1);
            }
        }
        int count = 0;
        for(int i = 0;i <array.length;i++){
            if (map.get(array[i]) == 1){
                if(count == 0){
                    num1[0] = array[i];
                    count++;
                }else{
                    num2[0] = array[i];
                }
            }
        }

    }

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        if(sum <= 0)return resList;
        int left = 1,right = 2;
        int sumValue = left + right;
        while(sum > right){
            if(sumValue < sum){
                right++;
                sumValue += right;
            }else if(sumValue > sum){
                sumValue -= left;
                left++;
            }else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i = left;i <= right;i++){
                    list.add(i);
                }
                resList.add(list);

                right++;
                sumValue +=right;
            }
        }
        return resList;

    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(array == null || array.length <=1){
            return result;
        }
        int smallIndex = 0,bigIndex = array.length - 1;
        while (smallIndex < bigIndex){
            if(array[smallIndex] + array[bigIndex] == sum){
                result.add(array[smallIndex]);
                result.add(array[bigIndex]);
                break;
            }else if(array[smallIndex] + array[bigIndex] < sum){
                smallIndex++;
            }else{
                bigIndex--;
            }
        }
        return result;
    }

    public String LeftRotateString(String str,int n) {
        if(str == null ||str.length() < n){
            return str;
        }
        return str.substring(n) + str.substring(0,n);
    }

    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0){
            return "";
        }
        StringBuilder str1 = new StringBuilder(str);
        str1.reverse();
        StringBuilder result = new StringBuilder();
        int j = 0;
        int blankNum = 0;
        //空格数量为0时候直接返回
        int index = str.indexOf(" ");
        //空格数为0时，直接返回字符串
        if(index == -1){
            return  str;
        }
        for(int i = 0;i < str1.length();i++){
            //1.当有空格，没有到达最后一个单词时候
            if(str1.charAt(i) == ' '&&(i !=str1.length() - 1)){
                blankNum++;
                StringBuilder str2 = new StringBuilder(str1.substring(j,i));
                result.append(str2.reverse().toString()).append(" ");
                j = i + 1;
            }
            //2、当有空格，且到达最后一个单词时
            if(blankNum != 0 &&i==(str1.length() - 1)){
                StringBuilder str3 = new StringBuilder(str1.substring(j,i + 1));
                result.append(str3.reverse());
            }

        }
        return  result.toString();
    }

    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length != 5){
            return false;
        }
        int num = 0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0;i < numbers.length;i++){
            if(numbers[i] == 0){
                num++;
            }else{
                set.add(numbers[i]);
            }
        }
        if((num + set.size() != 5)){
            return false;
        }
        if((set.last() - set.first()) < 5){
            return true;
        }
        return false;
    }

    public int LastRemaining_Solution(int n, int m) {
        if(n <= 0 || m <=0)return -1;
        return  n == 1 ? 0 : (LastRemaining_Solution(n  - 1,m) + m) % n;
    }

    public int Sum_Solution(int n) {
        int sum = n;
        boolean stop = (sum != 0)&& ((sum += Sum_Solution(n-1)) != 0);
        return sum;
    }

    public int Add(int num1,int num2) {
        int result = 0;
        int carry = 0;
        do{
            result = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = result;
            num2 = carry;
        }while (carry != 0);
        return result;
    }

    public int StrToInt(String str) {
        if(str == null || str.length() == 0)return  0;
        char[] arr = str.toCharArray();
        int i = 0;
        int flag = 1;
        int res = 0;
        if(arr[i] == '-'){
            flag = -1;
        }
        if(arr[i] == '+' || arr[i] == '-'){
            i++;
        }
        while(i < arr.length){
            //是数字
            if(arr[i] >='0' && arr[i] <='9'){
                int cur = arr[i] - '0';
                if(flag == 1 && (res > Integer.MAX_VALUE / 10) || res == Integer.MAX_VALUE/10 && cur >7){
                    return 0;
                }
                if(flag == -1 && (res > Integer.MAX_VALUE / 10) || res == Integer.MAX_VALUE/10 && cur >8){
                    return 0;
                }
                res = res * 10 + cur;
                i++;
            }else{
                //不是数字
                return 0;
            }
        }
        return res*flag;
    }


    public boolean duplicate(int numbers[],int length,int [] duplication) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0;i < length;i++){
            if(set.contains(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }else{
                set.add(numbers[i]);
            }
        }
        return false;
    }

    public int[] multiply(int[] A) {
        if(A == null || A.length == 0)return null;
        int length = A.length;
        int[] B = new int[length];
        //计算下三角形
        B[0] = 1;
        for(int i = 1;i<length;i++){
            B[i] = B[i - 1]*A[i - 1];
        }
        //计算上三角
        int temp = 1;
        for(int i = length - 1;i>=0;i--){
            B[i] = temp * B[i];
            temp = A[i] * temp;
        }
        return B;

    }

    public boolean match(char[] str, char[] pattern) {
        return matchStr(str,0,pattern,0);
    }

    public  boolean matchStr(char[] str,int i,char[] pattern,int j){
        if(i == str.length && j == pattern.length){
            return true;
        }else if(j == pattern.length){
            return false;
        }
        boolean next = (j + 1 < pattern.length && pattern[j + 1] == '*');
        if(next){
            if(i < str.length && (pattern[j] == '.' || str[i] == pattern[j])){
                return matchStr(str,i,pattern,j+2) || matchStr(str,i+1,pattern,j);
            }else{
                return matchStr(str,i,pattern,j+2);
            }
        }else{
            if(i < str.length && (pattern[j] == '.' || str[i] == pattern[j])){
                return matchStr(str,i+1,pattern,j+1);
            }else{
                return false;
            }
        }

    }

    public boolean isNumeric(char[] str) {
        //标志小数点和指数
        boolean point = false,exp = false;
        for(int i = 0;i<str.length;i++){
            if(str[i] == '+' || str[i] == '-'){
                if(i + 1== str.length || !(str[i + 1]>='0' && str[i +1 ]<='9' || str[i + 1]=='.')){
                    //+-号后面必定为数字 或后面为.
                    return  false;
                }
                if(!(i == 0 || str[i - 1]=='e'||str[i - 1]=='E')){
                    //+-号只出现在第一位或eE的后一位
                    return false;
                }
            }else if(str[i] == '.'){
                if(point || exp ||!(i + 1 <str.length && str[i + 1]>='0' && str[i + 1]<='9')){
                    return false;
                }
                point = true;
            }else if(str[i] == 'e' || str[i] == 'E'){
                if(exp || i + 1 == str.length || !(str[i + 1] >='0' &&str[i +1] <='9' ||
                        str[i+1]=='+' || str[i + 1]=='-')){
                    return false;
                }
                exp =true;
            }else if(str[i] >= '0' && str[i] <='9'){

            }else{
                return false;
            }
        }
        return true;
    }

    //Insert one char from stringstream
    String str = "";
    char[] hash = new char[256];
    public void Insert(char ch)
    {
        str += ch;
        hash[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(int i=0;i < str.length();i++) {
            if(hash[str.charAt(i)] == 1)
                return str.charAt(i);
        }
        return '#';
    }


    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null ||pHead.next == null){
            return  null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode slow2 = pHead;
                while (slow2  != slow){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }
        return  null;

    }

    public static ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null ||pHead.next == null){
            return  null;
        }
        //构建辅助头结点
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = pHead;
        while( cur != null){
            if(cur.next != null && cur.next.val == cur.val){
                //相同结点一直前进
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                //找到重复和不重复的边界
                cur = cur.next;
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }

        }
        return  head.next;
    }

	public TreeLinkNode GetNext(TreeLinkNode pNode)
	{
		if(pNode == null) return null;
		if(pNode.right != null){
		    pNode = pNode.right;
			while (pNode.left != null){
				pNode = pNode.left;
			}
			return pNode;
		}
		while(pNode.next != null){
			if(pNode.next.left == pNode){
			    return pNode.next;
            }
			pNode = pNode.next;
		}
		return  null;
	}

    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null)return true;
        return judgeTree(pRoot.left,pRoot.right);
    }

    public boolean judgeTree(TreeNode left,TreeNode right){
        if(left == null & right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }else{
            return judgeTree(left.left,right.right) &&judgeTree(left.right,right.left);
        }
    }

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        LinkedList<TreeNode> q = new LinkedList();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        boolean rev  = true;
        q.add(pRoot);
        while (!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node == null){
                    continue;
                }
                if(rev){
                    list.add(node.val);
                }else{
                    list.add(0,node.val);
                }
                q.offer(node.left);
                q.offer(node.right);
            }
            if(list.size() != 0){
                res.add(list);
            }
            rev = !rev;
        }
        return res;
    }

    public ArrayList<ArrayList<Integer> > PrintTree(TreeNode pRoot) {
        LinkedList<TreeNode> q = new LinkedList();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        q.add(pRoot);
        while (!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node == null){
                    continue;
                }
                list.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
            if(list.size() != 0){
                res.add(list);
            }
        }
        return res;
    }
    int index = -1;

    String Serialize(TreeNode root) {
        if(root == null){
            return "#";
        }else{
            return root.val + ","+ Serialize(root.left) + "," +Serialize(root.right);
        }
    }
    TreeNode Deserialize(String str) {
        String[] s = str.split(",");
        index++;
        int len = s.length;
        if(index > len){
            return null;
        }
        TreeNode treeNode = null;
        if(!s[index].equals("#")){
            treeNode = new TreeNode(Integer.parseInt(s[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);

        }
        return treeNode;
    }

    ArrayList<TreeNode> treeList = new ArrayList<TreeNode>();
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        addNode(pRoot);
        if(k >= 1 && treeList.size() >= k){
            return treeList.get(k - 1);
        }
        return null;
    }


    //中序遍历
    void addNode(TreeNode cur){
        if(cur != null){
            addNode(cur.left);
            treeList.add(cur);
            addNode(cur.right);
        }
    }
    private int count  = 0;
    private PriorityQueue<Integer> low = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> high = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    public void Insert(Integer num) {
        count++;
        if((count & 1) == 1){
            if(!low.isEmpty() && num > low.peek()){
                low.offer(num);
                num = low.poll();
            }
            high.offer(num);
        }else {
            if(!high.isEmpty() && num < high.peek()){
                high.offer(num);
                num = high.poll();
            }
            low.offer(num);
        }
    }

    public Double GetMedian() {
        double res = 0;
        if((count & 1) == 1){
            res = high.peek();
        }else{
            res = (high.peek() + low.peek()) / 2.0;
        }
        return res;
    }


    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(size < 1 ||num == null || num.length == 0) return res;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0;i < num.length;i++){
            while (!list.isEmpty() && num[i] > num[list.peekLast()]){
                list.pollLast();
            }
            list.add(i);
            //判断左边是否失效
            if(list.peekFirst() <= i - size){
                list.pollFirst();
            }
            if(i >=size - 1){
                res.add(num[list.peekFirst()]);
            }
        }
        return  res;
    }

    boolean[] visited = null;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        visited = new boolean[matrix.length];
        for(int i = 0;i < rows;i++){
            for(int j = 0;j< cols;j++){
                if(subHasPath(matrix,rows,cols,str,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean subHasPath(char[] matrix, int rows, int cols, char[] str,int row,int col,int len){
        if(matrix[row * cols + col] != str[len] || visited[row *cols + col ] == true)return false;
        if(len == str.length - 1) return  true;
        visited[row * cols + col] = true;
        if(row > 0 && subHasPath(matrix,rows,cols,str,row - 1,col,len + 1)) return  true;
        if(row < rows - 1 && subHasPath(matrix, rows, cols, str, row + 1, col, len + 1)) return true;
        if(col > 0 && subHasPath(matrix, rows, cols, str, row, col - 1, len + 1)) return true;
        if(col < col - 1 && subHasPath(matrix, rows, cols, str, row, col + 1, len + 1)) return true;
        visited[row * cols +col] = false;
        return  false;

    }

    public int movingCount(int threshold, int rows, int cols)
    {
        if(rows <= 0 || cols <= 0 || threshold < 0 ){
            return  0;
        }
        boolean[][] isVisited = new boolean[rows][cols];
        int count = movingCountCore(threshold, rows, cols,0,0,isVisited);
        return  count;
    }

    public  int movingCountCore(int thresold,int rows,int cols,int row,int col,boolean[][] isVisited){
        if(row < 0 || col < 0|| row >= rows || col >= cols || isVisited[row][col] || cal(row) + cal(col) >thresold){
            return 0;
        }
        isVisited[row][col] = true;
        return 1 + movingCountCore(thresold, rows, cols, row - 1, col, isVisited)
                 + movingCountCore(thresold, rows, cols, row + 1, col, isVisited)
                + movingCountCore(thresold, rows, cols, row, col - 1, isVisited)
                + movingCountCore(thresold, rows, cols, row, col + 1, isVisited);
    }

    public int cal(int num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int cutRope(int target) {
        if(target <= 0)return 0;
        if(target == 1 || target ==2)return 1;
        if(target == 3)return 2;
        int m = target % 3;
        switch (m){
            case 0:
                return  (int)Math.pow(3,target / 3);
            case 1:
                return  (int)Math.pow(3,target / 3 - 1) * 4;
            case 2:
                return  (int)Math.pow(3,target / 3) * 2;
        }
        return 0;
    }

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeDepth(node1);
        //String str = "baccss";
        //int i = FirstNotRepeatingChar(str);
        ListNode pHead = new ListNode(0);
        ListNode p1 = new ListNode(1);
        System.out.println("");


    }

}




