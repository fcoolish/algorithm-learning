//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 'ABCCED'（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 
//'ABCCED'
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [['a','b'],['c','d']], word = 'abcd'
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
//
// Related Topics 数组 回溯 矩阵 👍 796 👎 0

package leetcode.editor.cn;
public class JuZhenZhongDeLuJingLcof{
    public static void main(String[] args){
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        solution.exist(board,"ABCCED");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    boolean exists = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length,n = board[0].length;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == word.charAt(0)){
                    dfs(board,word,m,n,i,j,word.length(),0);
                }
            }
        }
        return exists;
    }

    public void dfs(char[][] board,String s,int m,int n,int x,int y,int len,int k){
        if(k == len || exists){
            exists = true;
            return;
        }
        if(x < 0 || x >= m || y < 0 ||y >= n || board[x][y] != s.charAt(k)){
            return;
        }
        char temp = board[x][y];
        board[x][y] = ' ';
        dfs(board,s,m,n,x + 1,y,len,k+1);
        dfs(board,s,m,n,x - 1,y,len,k+1);
        dfs(board,s,m,n,x,y - 1,len,k+1);
        dfs(board,s,m,n,x,y + 1,len,k+1);
        board[x][y] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}