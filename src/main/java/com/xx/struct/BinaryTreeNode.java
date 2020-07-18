package com.xx.struct;

public class BinaryTreeNode<T> {
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public T value;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public BinaryTreeNode() {

    }

    public BinaryTreeNode addLeft(T tmpvalue) {
        this.left = new BinaryTreeNode<>(tmpvalue);
        return this;
    }

    public BinaryTreeNode addRight(T tmpvalue) {
        this.right = new BinaryTreeNode<>(tmpvalue);
        return this;
    }
}
