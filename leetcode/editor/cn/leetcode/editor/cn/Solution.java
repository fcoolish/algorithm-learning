package leetcode.editor.cn;

import java.util.*;

/**
 * @author fcoolish
 * @date 2023/3/4
 */
public class Solution {
    public int splitNum(int num) {
        String numStr = String.valueOf(num);
        int[] freq = new int[10]; // 统计每个数字出现的次数
        for (char c : numStr.toCharArray()) {
            freq[c - '0']++;
        }
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for (int i = 1; i <= 9; i++) { // 枚举分割点
            if (freq[i] == 0) { // 当前数字不在 num 中出现
                continue;
            }
            int count = freq[i];
            while (count-- > 0) {
                if (num1.length() <= num2.length()) {
                    num1.append(i);
                } else {
                    num2.append(i);
                }
            }
        }
        int a = num1.length() > 0 ? Integer.parseInt(num1.toString()) : 0;
        int b = num2.length() > 0 ? Integer.parseInt(num2.toString()) : 0;
        return a + b;
    }


    public long coloredCells(int n) {
        long sum = 1;
        for (int i = 2; i <= n; i++) {
            sum = sum + (i - 1) * 4;
        }
        return sum;
    }

    public int passThePillow1(int n, int time) {
        int cnt = 1;
        boolean flag = true;
        while (time > 0) {
            if (flag) {
                if (cnt < n) {
                    cnt++;
                    time--;
                } else {
                    cnt--;
                    time--;
                    flag = !flag;
                }
            } else {
                if (cnt > 1) {
                    cnt--;
                    time--;
                } else {
                    cnt++;
                    time--;
                    flag = !flag;
                }
            }
        }
        return cnt;
    }

    public int pillowFight(int n, int time) {
        int count = 0;
        int index = 1;
        boolean pos = true;
        while (count < time) {
            count++;
            if (index == 1) {
                pos = true;
            } else if (index == n) {
                pos = false;
            }
            if (pos) {
                index++;
            } else {
                index--;
            }
        }
        return index;
    }

    int res = -1;
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> res = new ArrayList<>();
        //设置优先队列
        Queue<TreeNode> queue = new ArrayDeque<>();
        //层序遍历
        if (root != null) {
            queue.add(root);
        }
        //层序遍历临界条件是：队列不为空，也就是没有遍历完成
        while (!queue.isEmpty()){
            //获取当前队列的长度
            int n = queue.size();
            long nums = 0;
            for (int i = 0; i < n; i++) {
                //先从队列里面取出来这些值
                TreeNode poll = queue.poll();
                //加入num，然后进行左右字数的遍历
                nums += poll.val;
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
            res.add(nums);
        }
        Collections.sort(res,Collections.reverseOrder());
        return res.size() >= k ? res.get(k - 1): -1;
    }




    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //long res = solution.coloredCells(3);
       // int res = solution.passThePillow(18, 38);
    }
}