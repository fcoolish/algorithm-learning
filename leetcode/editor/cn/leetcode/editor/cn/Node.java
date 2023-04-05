package leetcode.editor.cn;

import java.util.List;

/**
 * @author fcoolish
 * @date 2023/4/5
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}