//图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。 
//
// 每个单元格的 平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。 
//
// 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。 
//
// 
//
// 给你一个表示图像灰度的 m x n 整数矩阵 img ，返回对图像的每个单元格平滑处理后的图像 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入:img = [[1,1,1],[1,0,1],[1,1,1]]
//输出:[[0, 0, 0],[0, 0, 0], [0, 0, 0]]
//解释:
//对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
//对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
//对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
// 
//
// 示例 2: 
//
// 
//输入: img = [[100,200,100],[200,50,200],[100,200,100]]
//输出: [[137,141,137],[141,138,141],[137,141,137]]
//解释:
//对于点 (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
//
//对于点 (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.
//666667) = 141
//对于点 (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) =
// 138
// 
//
// 
//
// 提示: 
//
// 
// m == img.length 
// n == img[i].length 
// 1 <= m, n <= 200 
// 0 <= img[i][j] <= 255 
// 
// Related Topics 数组 矩阵 
// 👍 168 👎 0

package leetcode.editor.cn;
public class ImageSmoother{
    public static void main(String[] args){
        Solution solution = new ImageSmoother().new Solution();
        int[][] img = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        solution.imageSmoother(img);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[] dx = new int[]{0,0,-1,1,-1,1,-1,1};
        int[] dy = new int[]{-1,1,0,0,-1,-1,1,1};
        int m = img.length,n = img[0].length;
        int[][] res = new int[m][n];
        for(int i =0;i < m;i++){
            for(int j =0;j < n;j++){
                int count = 1,sum = img[i][j];
                for (int k =0;k < 8;k++){
                    int mx = i + dx[k];
                    int my = j + dy[k];
                    if(mx >=0 && mx < m && my >=0 && my <n){
                        count++;
                        sum +=img[mx][my];
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}