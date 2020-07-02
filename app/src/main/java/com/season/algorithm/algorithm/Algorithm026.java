package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeNode;

import java.util.ArrayList;

public class Algorithm026 extends AlgorithmTree {
    /**
     * 二叉查找树（Binary Search Tree），
     * （又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
     * @return
     */
    @Override
    public String getName() {
        return "026-二叉搜索树与双向链表";
    }

    @Override
    public String getDesc() {
        return "输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。";
    }


    TreeNode treeRoot;
    @Override
    public String prepare() {
        //测试数据，不是二叉搜索树
        treeRoot = Algorithm004.buildTreeNode(new Integer[]{1,2,4,11, 7,3,5,6,8},
                new Integer[]{11,4,7,2,1,5,3,8,6});
        return logTreeNode(treeRoot);
    }

    @Override
    public void execute() {
        parse2LinkedList(treeRoot);
    }

    @Override
    public String verify() {
        return logTreeNodeRight(resNode);
    }

    TreeNode lastNode = null;
    TreeNode resNode = null;
    public void parse2LinkedList(TreeNode treeNode){
        if(treeNode==null) return;
        parse2LinkedList(treeNode.left);
        //此处节点已经排完序
        if (resNode == null) {
            lastNode = treeNode;
            //设置头节点
            resNode = treeNode;
        } else {
            lastNode.right = treeNode;
            treeNode.left = lastNode;
            lastNode = treeNode;
        }
        parse2LinkedList(treeNode.right);

    }

}
