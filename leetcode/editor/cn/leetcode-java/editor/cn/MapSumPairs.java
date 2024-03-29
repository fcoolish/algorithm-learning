//设计一个 map ，满足以下几点: 
//
// 
// 字符串表示键，整数表示值 
// 返回具有前缀等于给定字符串的键的值的总和 
// 
//
// 实现一个 MapSum 类： 
//
// 
// MapSum() 初始化 MapSum 对象 
// void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 
//key 已经存在，那么原来的键值对 key-value 将被替代成新的键值对。 
// int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["MapSum", "insert", "sum", "insert", "sum"]
//[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//输出：
//[null, null, 3, null, 5]
//
//解释：
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // 返回 3 (apple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // 返回 5 (apple + app = 3 + 2 = 5)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length, prefix.length <= 50 
// key 和 prefix 仅由小写英文字母组成 
// 1 <= val <= 1000 
// 最多调用 50 次 insert 和 sum 
// 
//
// Related Topics 设计 字典树 哈希表 字符串 👍 238 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs{
    public static void main(String[] args){
        //Solution solution = new MapSumPairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MapSum {

    class TrieNode{
        int val = 0;
        TrieNode[] children = new TrieNode[26];
    }
    Map<String,Integer> map;
    TrieNode root;
    public MapSum() {
        map = new HashMap<>();
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key,0);
        map.put(key,val);
        TrieNode node = root;
        for(char c:key.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            node.val += delta;
        }
    }
    
    public int sum(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(node.children[c - 'a'] == null){
                return 0;
            }
            node = node.children[c - 'a'];
        }
        return node.val;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}