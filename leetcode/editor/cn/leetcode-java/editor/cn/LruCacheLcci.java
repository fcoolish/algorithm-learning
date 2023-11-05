//设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存
//被填满时，它应该删除最近最少使用的项目。 
//
// 它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 写入数据 put(key, value)
// - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 184 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCacheLcci{
    public static void main(String[] args){
        //Solution solution = new LruCacheLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    class DNode{
        int key;
        int value;
        DNode pre;
        DNode next;
        DNode(){};
        DNode(int k,int v){
            this.key = k;
            this.value = v;
        }
    }


    Map<Integer,DNode> map;
    int cap = 0;
    int size = 0;
    DNode head;
    DNode tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DNode node = map.get(key);
        if(node == null){
            return -1;
        }
        removeToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DNode node = map.get(key);
        if(node != null){
            node.value = value;
            removeToHead(node);
        }else{
            DNode nn = new DNode(key,value);
            map.put(key,nn);
            addToHead(nn);
            size++;
            if(size > cap){
                DNode tn = removeTail();
                map.remove(tn.key);
                size--;
            }
        }
    }

    public void addToHead(DNode node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public void removeNode(DNode node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

        public DNode removeTail(){
            DNode node = tail.pre;
            removeNode(node);
            return node;
        }

        public void removeToHead(DNode node){
            removeNode(node);
            addToHead(node);
        }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}