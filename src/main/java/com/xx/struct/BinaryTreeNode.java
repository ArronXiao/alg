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

    public void addLeft(T tmpvalue) {
        this.left = new BinaryTreeNode<>(tmpvalue);
    }

    public void addRight(T tmpvalue) {
        this.right = new BinaryTreeNode<>(tmpvalue);
    }
}
