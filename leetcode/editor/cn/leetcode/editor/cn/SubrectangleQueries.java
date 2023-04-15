//请你实现一个类 SubrectangleQueries ，它的构造函数的参数是一个 rows x cols 的矩形（这里用整数矩阵表示），并支持以下两种操作
//： 
//
// 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) 
//
// 
// 用 newValue 更新以 (row1,col1) 为左上角且以 (row2,col2) 为右下角的子矩形。 
// 
//
// 2. getValue(int row, int col) 
//
// 
// 返回矩形中坐标 (row,col) 的当前值。 
// 
//
// 
//
// 示例 1： 
//
// 输入：
//["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue",
//"updateSubrectangle","getValue","getValue"]
//[[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10
//],[3,1],[0,2]]
//输出：
//[null,1,null,5,5,null,10,5]
//解释：
//SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,
//3,4],[3,2,1],[1,1,1]]);  
//// 初始的 (4x3) 矩形如下：
//// 1 2 1
//// 4 3 4
//// 3 2 1
//// 1 1 1
//subrectangleQueries.getValue(0, 2); // 返回 1
//subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
//// 此次更新后矩形变为：
//// 5 5 5
//// 5 5 5
//// 5 5 5
//// 5 5 5 
//subrectangleQueries.getValue(0, 2); // 返回 5
//subrectangleQueries.getValue(3, 1); // 返回 5
//subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
//// 此次更新后矩形变为：
//// 5   5   5
//// 5   5   5
//// 5   5   5
//// 10  10  10 
//subrectangleQueries.getValue(3, 1); // 返回 10
//subrectangleQueries.getValue(0, 2); // 返回 5
// 
//
// 示例 2： 
//
// 输入：
//["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue",
//"updateSubrectangle","getValue"]
//[[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2
//]]
//输出：
//[null,1,null,100,100,null,20]
//解释：
//SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,
//2,2],[3,3,3]]);
//subrectangleQueries.getValue(0, 0); // 返回 1
//subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
//subrectangleQueries.getValue(0, 0); // 返回 100
//subrectangleQueries.getValue(2, 2); // 返回 100
//subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
//subrectangleQueries.getValue(2, 2); // 返回 20
// 
//
// 
//
// 提示： 
//
// 
// 最多有 500 次updateSubrectangle 和 getValue 操作。 
// 1 <= rows, cols <= 100 
// rows == rectangle.length 
// cols == rectangle[i].length 
// 0 <= row1 <= row2 < rows 
// 0 <= col1 <= col2 < cols 
// 1 <= newValue, rectangle[i][j] <= 10^9 
// 0 <= row < rows 
// 0 <= col < cols 
// 
//
// Related Topics 设计 数组 矩阵 👍 38 👎 0

package leetcode.editor.cn;
class SubrectangleQueries1{
    public static void main(String[] args){
        SubrectangleQueries1 solution = new SubrectangleQueries1();
        int[][] arr = {{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
        SubrectangleQueries queries = solution.new SubrectangleQueries(arr);
        int v1 = queries.getValue(0,2);
        queries.updateSubrectangle(0,0,3,2,5);
        int v2 = queries.getValue(0,2);
        int v3 =  queries.getValue(0,2);
        queries.updateSubrectangle(3,0,3,2,10);
        int v4 =  queries.getValue(3,1);
        int v5 =  queries.getValue(0,2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class SubrectangleQueries {
    int[][] rectangleR = null;
    public SubrectangleQueries(int[][] rectangle) {
        rectangleR =  rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i = row1;i <= row2;i++)
            for(int j = col1;j <= col2;j++){
                rectangleR[i][j] = newValue;
            }
    }
    
    public int getValue(int row, int col) {
        return rectangleR[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
//leetcode submit region end(Prohibit modification and deletion)

}