package com.xx.alg.tree;

import com.xx.alg.AbstractAlg;
import com.xx.struct.BinaryTreeNode;
import com.xx.utils.PrintUtils;

import java.util.Stack;

public class RootFirtTreeTraversal extends AbstractAlg<BinaryTreeNode<Integer>> {

    @Override
    protected BinaryTreeNode<Integer> prepareData() {
        BinaryTreeNode<Integer> binaryTreeNode = new BinaryTreeNode<>(2);
        binaryTreeNode.addLeft(1);
        binaryTreeNode.addRight(3);
        return binaryTreeNode;
    }

    @Override
    protected void realRun(BinaryTreeNode<Integer> data) {
        PrintUtils.print("递归先根遍历");
        firstRoot(data);
        PrintUtils.print("非递归先根遍历");
        firstRootNoRecursion(data);
        PrintUtils.print("递归中根遍历");
        centerRoot(data);
        PrintUtils.print("递归后根遍历");
        afterRoot(data);
    }

    private void firstRoot(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode != null) {
            PrintUtils.print(binaryTreeNode.value);
            firstRoot(binaryTreeNode.left);
            firstRoot(binaryTreeNode.right);
        }
    }

    private void firstRootNoRecursion(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(binaryTreeNode);
        while (!stack.isEmpty()) {
            BinaryTreeNode binaryTreeNode1Top = stack.pop();
            PrintUtils.print(binaryTreeNode1Top.value);
            //入栈右子树
            if (binaryTreeNode1Top.right != null) {
                stack.push(binaryTreeNode1Top.right);
            }
            //入栈左子树
            if (binaryTreeNode1Top.left != null) {
                stack.push(binaryTreeNode1Top.left);
            }
        }
    }

    private void centerRoot(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode != null) {
            firstRoot(binaryTreeNode.left);
            PrintUtils.print(binaryTreeNode.value);
            firstRoot(binaryTreeNode.right);
        }
    }


    private void centerRootNoRecursion(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(binaryTreeNode);
        while (!stack.isEmpty()) {
            //入栈右子树,先进后出
            while (stack.peek().left != null) {
                stack.push(stack.peek().left);
            }
            while (!stack.isEmpty()) {
                BinaryTreeNode binaryTreeNode1Top = stack.pop();
                PrintUtils.print(binaryTreeNode1Top.value);
                //入栈左子树
                if (binaryTreeNode1Top.right != null) {
                    stack.push(binaryTreeNode1Top.right);
                    break;
                }
            }

        }
    }

    private void afterRoot(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode != null) {
            firstRoot(binaryTreeNode.left);
            firstRoot(binaryTreeNode.right);
            PrintUtils.print(binaryTreeNode.value);
        }
    }
}
