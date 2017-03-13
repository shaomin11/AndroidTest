package shaomin.androidtest.algorithm.binarytree;

/**
 * Created by wangshaomin on 3/3/17.
 */

public class BinaryTree<K extends Comparable<K>, V> {
    private BinaryNode<K, V> root;

    public void addTreeNode(K key, V value) {
        root = add(key, value, root);
    }

    private BinaryNode<K, V> add(K key, V value, BinaryNode<K, V> node) {
        if (node == null) {
            node = new BinaryNode<>(key, value, null, null);
        }

        if (key.compareTo(node.key) < 0) {

        }
        return node;
    }
}
