//三合一。描述如何只用一个数组来实现三个栈。 
//
// 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
//stackNum表示栈下标，value表示压入的值。 
//
// 构造函数会传入一个stackSize参数，代表每个栈的大小。 
//
// 示例1: 
//
// 
// 输入：
//["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
//[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
// 输出：
//[null, null, null, 1, -1, -1, true]
//说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
// 
//
// 示例2: 
//
// 
// 输入：
//["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
//[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, -1, -1]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= stackNum <= 2 
// 
// Related Topics 栈 设计 数组 👍 51 👎 0

package leetcode.editor.cn;
public class ThreeInOneLcci{
    public static void main(String[] args){
        ThreeInOneLcci solution = new ThreeInOneLcci();
//        TripleInOne te= new TripleInOne(2);
//        te.push(0,1);
//        te.push(0,2);
//        te.push(0,3);
//        int a = te.pop(0);
//        a = te.pop(0);
//        a = te.pop(0);
//        a = te.peek(0);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class TripleInOne {
        int N = 3;
        int[][] data;
        int[] locations;
       int[] stack = null;
    public TripleInOne(int stackSize) {
        data = new int[N][stackSize];
        locations = new int[N];
    }

    public void push(int stackNum, int value) {
        int[] stack = data[stackNum];
        int loc = locations[stackNum];
        if(loc < stack.length){
            stack[loc] = value;
            locations[stackNum]++;
        }
    }
    
    public int pop(int stackNum) {
        int[] stack = data[stackNum];
        int loc = locations[stackNum];
        if(loc > 0){
            int val = stack[loc - 1];
            locations[stackNum]--;
            return val;
        }
        return -1;
    }
    
    public int peek(int stackNum) {
        int[] stack = data[stackNum];
        int loc = locations[stackNum];
        if(loc >0){
            return stack[loc - 1];
        }
        return -1;
    }
    
    public boolean isEmpty(int stackNum) {
        return locations[stackNum] == 0;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
//leetcode submit region end(Prohibit modification and deletion)

}