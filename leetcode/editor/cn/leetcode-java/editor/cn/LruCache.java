//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 2666 👎 0

package leetcode.editor.cn;

import java.util.*;

public class LruCache{
    public static void main(String[] args){
        LRUCache solution = new LruCache().new LRUCache(2);
        solution.put(1,1);
        solution.put(2,2);
        solution.get(1);
        solution.put(3,3);
        solution.get(2);
        solution.put(4,4);
        solution.get(1);
        solution.get(3);
        solution.get(4);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    private class DLinkNode{
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;
        private DLinkNode(int key,int value){
            this.key = key;
            this.value = value;
        }
        private  DLinkNode(){};
    }
    Map<Integer,DLinkNode> map ;
    DLinkNode head  = new DLinkNode();
    DLinkNode tail  = new DLinkNode();
    int capacity = 0;
    public LRUCache(int capacity){
        this.map = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key){
        DLinkNode node = map.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        DLinkNode node = map.get(key);
        if(node == null){
            DLinkNode nn = new DLinkNode(key,value);
            map.put(key,nn);
            addToHead(nn);
            if(map.size() > capacity){
                DLinkNode deNode = removeTail();
                map.remove(deNode.key);
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

     public void addToHead(DLinkNode node){
         node.next = head.next;
         node.pre = head;
        head.next.pre = node;
        head.next = node;
      }

        public void moveToHead(DLinkNode node){
            removeNode(node);
            addToHead(node);
        }

        public void removeNode(DLinkNode node){
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }

        public DLinkNode removeTail(){
            DLinkNode pre = tail.pre;
            removeNode(pre);
            return pre;
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