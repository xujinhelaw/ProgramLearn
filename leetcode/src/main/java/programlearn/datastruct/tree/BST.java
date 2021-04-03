/***
 *   二叉查找树
 *   代码转载来源说明
 *   博客：https://www.jianshu.com/p/5f4c9694b807
 *   代码仓库：https://github.com/nicktming/code/tree/master/data_structure
 * ***/
package programlearn.datastruct.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "[ " + key + "," + value + " ]";
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * 通过递归方法实现二叉搜索树的新增操作
     *
     * @param root  根节点
     * @param key   节点的key值
     * @param value 节点的value值
     * @return 返回已赋好值的根节点
     */
    public Node put(Node root, Key key, Value value) {
        if (key == null)
            throw new IllegalArgumentException();
        if (root == null)
            return new Node(key, value);
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = put(root.left, key, value);
        } else if (cmp > 0) {
            root.right = put(root.right, key, value);
        } else {
            root.value = value;
        }
        return root;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node root, Key key) {
        if (key == null)
            throw new IllegalArgumentException();
        if (root == null)
            return null;
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            //直接返回获取的值
            return get(root.left, key);
        } else if (cmp > 0) {
            return get(root.right, key);
        } else {
            return root.value;
        }
    }

    /**
     * 横向遍历
     */
    public void layerTraverse() {
        layerTraverse(root);
    }

    private void layerTraverse(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Queue<Node> tmp = new LinkedList<Node>();
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                System.out.print(cur + " ");
                if (cur != null) {
                    tmp.add(cur.left);
                    tmp.add(cur.right);
                }
            }
            //关键一步，根节点的左右节点加入tmp队列后，再赋值给queue
            queue = tmp;
            System.out.println();
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node root) {
        if (root == null) throw new IllegalArgumentException();
        if (root.left == null) return root.right; //如果找到最小键 直接返回最小键的右孩子
        root.left = deleteMin(root.left); //当前节点的左孩子等于当前节点的左子树删除最小键返回的子树根节点
        return root;
    }

    private Node min(Node root) {
        if (root == null) throw new IllegalArgumentException();
        while (root.left != null) root = root.left;
        return root;
    }

    public void delete(Key key) {
        root = delete(root,key);
    }

    private Node delete(Node h, Key key){
        if (key == null) throw new IllegalArgumentException();
        if (h == null) return null;

        int cmp = key.compareTo(h.key);
        if (cmp < 0){
            h.left = delete(h.left, key);
        }else if(cmp > 0) {
            h.right = delete(h.right, key);
        }else {
            if(h.left == null) return h.right;         //没有左子树删除
            if(h.right == null) return h.left;         //没有右子树删除
            Node min_of_h_right = min(h.right);        // 当前节点h右子树的最小键
            Node root_of_h_right = deleteMin(h.right); // 当前节点h右子树删除最小键后的根节点
            min_of_h_right.right = root_of_h_right;    // 最小键的右孩子 是 h右子树删除最小键后的根节点
            min_of_h_right.left = h.left;              // 最小键的左孩子 是 h的左孩子
            h = min_of_h_right;                        // 把当前节点设为最小键 然后返回给上一层
        }
        return h;
    }

    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<String, Integer>();
        bst.put("S", 0);
        bst.put("E", 1);
        bst.put("A", 2);
        bst.put("R", 3);
        bst.put("C", 4);
        bst.put("H", 5);
        bst.put("E", 6);
        bst.put("X", 7);
        bst.layerTraverse();
        System.out.println("Key is E value is " + bst.get("E"));
        bst.delete("E");
        bst.layerTraverse();

        bst.deleteMin();
        bst.layerTraverse();
    }
}
