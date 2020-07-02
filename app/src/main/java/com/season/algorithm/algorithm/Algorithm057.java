package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeLinkNode;


public class Algorithm057 extends AlgorithmTree {

    /**
     * @return
     */
    @Override
    public String getName() {
        return "057-二叉树的下一个结点";
    }

    @Override
    public String getDesc() {
        return "给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。" +
                "注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。";
    }

    TreeLinkNode treeRoot;
    @Override
    public String prepare() {
        TreeLinkNode rootNode = new TreeLinkNode(1);
        TreeLinkNode nodeLeft = new TreeLinkNode(rootNode, 2);
        TreeLinkNode nodeRight = new TreeLinkNode(rootNode, 3);
        rootNode.left = nodeLeft; rootNode.right = nodeRight;

        TreeLinkNode nodeLeft2 = new TreeLinkNode(nodeLeft, 4);
        nodeLeft.left = nodeLeft2;

       // treeRoot = nodeLeft;
        treeRoot = nodeRight;
        return logTreeNode(treeRoot);
    }

    @Override
    public void execute() {
        res = getNextNode(treeRoot);
    }

    @Override
    public String verify() {
        return logTreeNode(res);
    }

    public static TreeLinkNode getNextNode(TreeLinkNode node){
        if(node==null) return null;
        if(node.right!=null){    //如果有右子树，则找右子树的最左节点
            node = (TreeLinkNode) node.right;
            while(node.left!=null) node = (TreeLinkNode) node.left;
            return node;
        }
        while(node.next!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
            if(node.next.left==node) return node.next;
            node = node.next;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }

    TreeLinkNode res;

}
