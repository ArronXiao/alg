package com.xx.alg;

import com.xx.struct.LinkNode;
import com.xx.utils.PrintUtils;

public class ReverseLink extends AbstractAlg<LinkNode> {
    @Override
    protected LinkNode prepareData() {
        LinkNode linkNode = new LinkNode(1);
        LinkNode linkNode1 = new LinkNode(2);
        LinkNode linkNode2 = new LinkNode(3);
        LinkNode linkNode3 = new LinkNode(4);
        LinkNode linkNode4 = new LinkNode(5);
        linkNode.nextNode = linkNode1;
        linkNode1.nextNode = linkNode2;
        linkNode2.nextNode = linkNode3;
        linkNode3.nextNode = linkNode4;
        return linkNode;
    }

    @Override
    protected void realRun(LinkNode data) {
        LinkNode root = data;
        LinkNode pre = null;
        LinkNode next;
         while (root != null) {
            next = root.nextNode;  //第一步移动到下一步
            root.nextNode = pre;    // 下一步进行反转
            pre = root;            //继续前移
            root = next;          //继续迁移
         }
         root = pre;
        PrintUtils.print(root);
        PrintUtils.print("---------- reverse2");
        PrintUtils.print(reverse2(root));
    }

    private LinkNode reverse2(LinkNode head) {
        if (head == null || head.nextNode == null) {
            return head;
        }
        LinkNode preNode = head.nextNode; //反转之前，先保存最后一个节点，不然后下次找不到咯
        LinkNode reHead = reverse2(head.nextNode); //新的节点的头结点
        preNode.nextNode = head; //链接新的链表和之前是一个节点
        head.nextNode = null;   //将单独节点的下一个置空
        return reHead;
    }
}
