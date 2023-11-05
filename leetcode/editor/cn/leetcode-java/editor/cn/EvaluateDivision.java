//给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 
//values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。 
//
// 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj =
// ? 的结果作为答案。 
//
// 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替
//代这个答案。 
//
// 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
//,["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//条件：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// 示例 2： 
//
// 
//输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], 
//queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
// 
//
// 示例 3： 
//
// 
//输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],[
//"a","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj 由小写英文字母与数字组成 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 数组 最短路 👍 923 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision{
    public static void main(String[] args){
        Solution solution = new EvaluateDivision().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            int nvars = 0;
            Map<String, Integer> variables = new HashMap<String, Integer>();

            int n = equations.size();
            for (int i = 0; i < n; i++) {
                if (!variables.containsKey(equations.get(i).get(0))) {
                    variables.put(equations.get(i).get(0), nvars++);
                }
                if (!variables.containsKey(equations.get(i).get(1))) {
                    variables.put(equations.get(i).get(1), nvars++);
                }
            }
            int[] f = new int[nvars];
            double[] w = new double[nvars];
            Arrays.fill(w, 1.0);
            for (int i = 0; i < nvars; i++) {
                f[i] = i;
            }

            for (int i = 0; i < n; i++) {
                int va = variables.get(equations.get(i).get(0)), vb = variables.get(equations.get(i).get(1));
                merge(f, w, va, vb, values[i]);
            }
            int queriesCount = queries.size();
            double[] ret = new double[queriesCount];
            for (int i = 0; i < queriesCount; i++) {
                List<String> query = queries.get(i);
                double result = -1.0;
                if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                    int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                    int fa = findf(f, w, ia), fb = findf(f, w, ib);
                    if (fa == fb) {
                        result = w[ia] / w[ib];
                    }
                }
                ret[i] = result;
            }
            return ret;
        }

        public void merge(int[] f, double[] w, int x, int y, double val) {
            int fx = findf(f, w, x);
            int fy = findf(f, w, y);
            f[fx] = fy;
            w[fx] = val * w[y] / w[x];
        }

        public int findf(int[] f, double[] w, int x) {
            if (f[x] != x) {
                int father = findf(f, w, f[x]);
                w[x] = w[x] * w[f[x]];
                f[x] = father;
            }
            return f[x];
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}