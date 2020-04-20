


import java.util.*;

/**
 * Created by admin on 2018/3/16.
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
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
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

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        Convert(pRootOfTree,list);
        return Convert(list);
    }
    //中序遍历
    public void Convert(TreeNode pRootOfTree,ArrayList<TreeNode> list) {
        if (pRootOfTree.left != null) {
            Convert(pRootOfTree.left, list);
        }
        list.add(pRootOfTree);
        if (pRootOfTree.right != null) {
            Convert(pRootOfTree.right, list);
        }
    }
        //遍历list，修改指针
    public TreeNode Convert(ArrayList<TreeNode> list){
        for(int i=0;i <list.size()-1;i++){
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        return  list.get(0);
    }



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


    public static void main(String[] args) {


    }

}




