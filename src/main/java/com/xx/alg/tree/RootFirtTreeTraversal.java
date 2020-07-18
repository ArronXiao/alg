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

        PrintUtils.print("非递归中根遍历");
        centerRootNoRecursion(data);

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
            //入栈右树
            if (binaryTreeNode1Top.right != null) {
                stack.push(binaryTreeNode1Top.right);
            }
            //入栈坐树
            if (binaryTreeNode1Top.left != null) {
                stack.push(binaryTreeNode1Top.left);
            }
        }
    }

    private void centerRoot(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode != null) {
            centerRoot(binaryTreeNode.left);
            PrintUtils.print(binaryTreeNode.value);
            centerRoot(binaryTreeNode.right);
        }
    }


    private void centerRootNoRecursion(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }
        BinaryTreeNode currentBNode = binaryTreeNode;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || currentBNode!= null) {
            while (currentBNode != null) {
                stack.push(currentBNode);
                currentBNode = currentBNode.left;
                //保证所有的左节点先压栈
            }
            if (!stack.isEmpty()) {
                currentBNode = stack.pop();
                PrintUtils.print(currentBNode.value);
                currentBNode = currentBNode.right;
            }
        }
    }

    private void afterRoot(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode != null) {
            afterRoot(binaryTreeNode.left);
            afterRoot(binaryTreeNode.right);
            PrintUtils.print(binaryTreeNode.value);
        }
    }


    private void afterNoRecursion(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }

        //这个还是不太懂哟，要先留着

        //一个根节点被访问的前提是：无右子树或右子树已被访问过
        //https://blog.csdn.net/z_ryan/article/details/80854233
        BinaryTreeNode currentBNode = binaryTreeNode;
        BinaryTreeNode lastVisiBNode = null;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (currentBNode != null) {
            stack.push(currentBNode);
            currentBNode = currentBNode.left;
        }
        while (!stack.empty()) {
            //走到这里，pCur都是空，并已经遍历到左子树底端(看成扩充二叉树，则空，亦是某棵树的左孩子)
            currentBNode = stack.pop();
            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if (currentBNode.right == null || currentBNode.right == lastVisiBNode) {
                PrintUtils.print(currentBNode.value);
                //修改最近被访问的节点
                lastVisiBNode = currentBNode;
            }
            /*这里的else语句可换成带条件的else if:
            else if (pCur->lchild == pLastVisit)//若左子树刚被访问过，则需先进入右子树(根节点需再次入栈)
            因为：上面的条件没通过就一定是下面的条件满足。仔细想想！
            */
            else {
                //根节点再次入栈
                stack.push(currentBNode);
                //进入右子树，且可肯定右子树一定不为空
                currentBNode = currentBNode.right;
                while (currentBNode != null) {
                    stack.push(currentBNode);
                    currentBNode = currentBNode.left;
                }
            }
        }
    }

}
