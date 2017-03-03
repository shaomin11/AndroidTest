package shaomin.androidtest.algorithm.binarytree;

import java.util.HashSet;

/**
 * Created by wangshaomin on 3/2/17.
 */

/**
 * 树节点
 */
public class BinaryNode<K, V> {

    /**
     * key和value数组
     */
    public K key;
    public HashSet<V> values = new HashSet<V>();

    /**
     * 左右节点
     */
    public BinaryNode<K, V> left;
    public BinaryNode<K, V> right;

    public BinaryNode() {
    }

    public BinaryNode(K key, V value, BinaryNode<K, V> left, BinaryNode<K, V> right) {
        this.key = key;
        this.values.add(value);

        this.left = left;
        this.right = right;
    }

}
