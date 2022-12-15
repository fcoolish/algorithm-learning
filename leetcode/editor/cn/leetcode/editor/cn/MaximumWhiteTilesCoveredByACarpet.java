//给你一个二维整数数组 tiles ，其中 tiles[i] = [li, ri] ，表示所有在 li <= j <= ri 之间的每个瓷砖位置 j 都被涂成
//了白色。 
//
// 同时给你一个整数 carpetLen ，表示可以放在 任何位置 的一块毯子。 
//
// 请你返回使用这块毯子，最多 可以盖住多少块瓷砖。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：tiles = [[1,5],[10,11],[12,18],[20,25],[30,32]], carpetLen = 10
//输出：9
//解释：将毯子从瓷砖 10 开始放置。
//总共覆盖 9 块瓷砖，所以返回 9 。
//注意可能有其他方案也可以覆盖 9 块瓷砖。
//可以看出，瓷砖无法覆盖超过 9 块瓷砖。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：tiles = [[10,11],[1,1]], carpetLen = 2
//输出：2
//解释：将毯子从瓷砖 10 开始放置。
//总共覆盖 2 块瓷砖，所以我们返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tiles.length <= 5 * 10⁴ 
// tiles[i].length == 2 
// 1 <= li <= ri <= 10⁹ 
// 1 <= carpetLen <= 10⁹ 
// tiles 互相 不会重叠 。 
// 
// Related Topics 贪心 数组 二分查找 前缀和 排序 👍 39 👎 0

package leetcode.editor.cn;
public class MaximumWhiteTilesCoveredByACarpet{
    public static void main(String[] args){
        Solution solution = new MaximumWhiteTilesCoveredByACarpet().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}