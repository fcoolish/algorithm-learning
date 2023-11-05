//有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。 
//
// 你也被给予三个整数 sr , sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。 
//
// 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对
//应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为 newColor 。 
//
// 最后返回 经过上色渲染后的图像 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, newColor = 2
//输出: [[2,2,2],[2,2,0],[2,0,1]]
//解析: 在图像的正中间，(坐标(sr,sc)=(1,1)),在路径上所有符合条件的像素点的颜色都被更改成2。
//注意，右下角的像素没有更改为2，因为它不是在上下左右四个方向上与初始点相连的像素点。
// 
//
// 示例 2: 
//
// 
//输入: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
//输出: [[2,2,2],[2,2,2]]
// 
//
// 
//
// 提示: 
//
// 
// m == image.length 
// n == image[i].length 
// 1 <= m, n <= 50 
// 0 <= image[i][j], newColor < 2¹⁶ 
// 0 <= sr < m 
// 0 <= sc < n 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 327 👎 0

package leetcode.editor.cn;
public class FloodFill{
    public static void main(String[] args){
        Solution solution = new FloodFill().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] dx = new int[]{ 0,0,-1,1};
    int[] dy = new int[]{-1,1,0,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color != newColor){
            dfs(image,sr,sc,color,newColor);
        }
        return image;
    }

    private void dfs(int[][] image,int x,int y,int color,int newColor){
        if(image[x][y] == color){
            image[x][y] = newColor;
            for(int k=0;k < 4;k++){
                int kx = x + dx[k];
                int ky = y + dy[k];
                if(kx >=0 && kx <image.length && ky>=0 && ky <image[0].length){
                    dfs(image,kx,ky,color,newColor);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}