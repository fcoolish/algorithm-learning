//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 
//false 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//inputs = ["Trie", "insert", "search", "search", "startsWith", "insert", 
//"search"]
//inputs = [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次 
// 
//
// 
//
// 
//
// 
// 注意：本题与主站 208 题相同：https://leetcode-cn.com/problems/implement-trie-prefix-tree/
// 
//
// Related Topics 设计 字典树 哈希表 字符串 👍 52 👎 0

package leetcode.editor.cn;
public class QC3q1f{
    public static void main(String[] args){
        //Solution solution = new QC3q1f().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    Trie[] children;
    boolean end = false;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node= this;
        for(int i = 0;i < word.length();i++){
            if(node.children[word.charAt(i) - 'a'] == null){
                Trie newNode = new Trie();
                node.children[word.charAt(i) - 'a'] = newNode;
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        node.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = startsWithPre(word);
        return trie != null && trie.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWithPre(prefix) != null;
    }

    public Trie startsWithPre(String prefix) {
        Trie node = this;
        for(int i =0;i < prefix.length();i++){
            if(node.children[prefix.charAt(i) - 'a'] == null){
                return null;
            }
            node = node.children[prefix.charAt(i) - 'a'];
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}