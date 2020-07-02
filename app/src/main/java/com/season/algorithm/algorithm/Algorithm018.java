package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeNode;

public class Algorithm018 extends AlgorithmTree {

    @Override
    public String getName() {
        return "018-二叉树的镜像";
    }

    /**
     * 镜像定义：
     * 	     源二叉树
     *     	    8
     *     	   /  \
     *     	  6   10
     *     	 / \  / \
     *     	5  7 9 11
     *         镜像二叉树
     *     	    8
     *     	   /  \
     *     	  10   6
     *     	 / \  / \
     *     	11 9 7  5
     *
     * @return
     */
    @Override
    public String getDesc() {
        return "操作给定的二叉树，将其变换为源二叉树的镜像。";
    }

    TreeNode treeRoot;
    @Override
    public String prepare() {
        treeRoot = getNode();
        return logTreeNode(treeRoot);
    }

    @Override
    public void execute() {
        mirror(treeRoot);
    }

    @Override
    public String verify() {
        return logTreeNode(treeRoot);
    }

    public static void mirror(TreeNode root){
        if(root == null ){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirror(root.left);
        mirror(root.right);
    }

}
