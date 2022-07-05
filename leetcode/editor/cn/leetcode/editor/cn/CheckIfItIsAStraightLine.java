//给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ， [x, y] 表示横坐标为 x、纵坐标为 y 的点。请你来
//判断，这些点是否在该坐标系中属于同一条直线上。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 
//输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 2 <= coordinates.length <= 1000 
// coordinates[i].length == 2 
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4 
// coordinates 中不含重复的点 
// 
// Related Topics 几何 数组 数学 👍 117 👎 0

package leetcode.editor.cn;
public class CheckIfItIsAStraightLine{
    public static void main(String[] args){
        Solution solution = new CheckIfItIsAStraightLine().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x = coordinates[0][0];
        int y = coordinates[0][1];
        int n = coordinates.length;
        for(int i =0; i < n;i++){
            coordinates[i][0] -= x;
            coordinates[i][1] -= y;
        }
        int A = coordinates[1][1], B = coordinates[1][0];
        for(int i =2; i < n;i++){
            int c = coordinates[i][0];
            int d = coordinates[i][1];
            if(A*c != B * d)return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}