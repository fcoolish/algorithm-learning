//给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。 
//
// 
//示例:
//输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//输出: 2
//解释: 
//这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
// 
//
// 
//
// 注意: 
//
// 
// 3 <= points.length <= 50. 
// 不存在重复的点。 
// -50 <= points[i][j] <= 50. 
// 结果误差值在 10^-6 以内都认为是正确答案。 
// 
// Related Topics 几何 数组 数学 
// 👍 103 👎 0

package leetcode.editor.cn;
public class LargestTriangleArea{
    public static void main(String[] args){
        Solution solution = new LargestTriangleArea().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double area = 0.0;
        for(int i = 0;i < n - 2;i++){
            for(int j = i+ 1;j < n - 1;j++){
                for(int k =j + 1;k < n;k++){
                    area = Math.max(getArea(points[i],points[j],points[k]),area);
                }
            }
        }
        return area;
    }

    private double getArea(int[] A,int[] B,int[] C){
        return 0.5 * Math.abs(A[0] * B[1] + B[0] * C[1] + C[0] * A[1]
        - A[1] * B[0] - B[1] * C[0] - C[1] * A[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}